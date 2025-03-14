public class Hospital {
    private Operacion[] operacionesProgramadas;
    private PersonalSalud[] personal;
    private Paciente[] pacientes;

    public Hospital(Operacion[] operacionesProgramadas, PersonalSalud[] personal, Paciente[] pacientes) {
        this.operacionesProgramadas = operacionesProgramadas;
        this.personal = personal;
        this.pacientes = pacientes;
    }


    // Lista de Enfermeros, lanzar excepcion si no hay enfermeros en la lista de personal
    public Enfermero[] listaEnfermeros() throws EEnfermero{
        int count = 0;
        for (PersonalSalud persona: this.personal){
            if (persona instanceof Enfermero){
                count++;
            }
        }

        if (count == 0){
            throw new EEnfermero("No hay enfermeros en la lista del personal");
        }

        Enfermero[] enfermeros = new Enfermero[count];
        int index = 0;
        for (PersonalSalud persona: this.personal){
            if (persona instanceof Enfermero){
                enfermeros[index++] = (Enfermero) persona;
            }
        }

        return enfermeros;
    }

    // Cirugias en que participo un enfermero determinado, dado tipo de documento y numero de documento

    public Operacion[] operacionesEnfermero(String tipodoc, String doc) {
        int count = 0;
        for (Operacion operacion: this.operacionesProgramadas){
            if (operacion.participoEnfermero(tipodoc, doc)){
                count++;
            }
        }

        Operacion[] operaciones = new Operacion[count];
        int index = 0;

        for (Operacion operacion: operacionesProgramadas){
            if (operacion.participoEnfermero(tipodoc, doc)){
                operaciones[index++] = operacion;
            }
        }
        return operaciones;
    }



    // Operaciones negativas en las que ha participado cada personal, en el orden en que estan en personal
    //tenga en cuenta el medico, el anestesiologo, enfermeros y personal que participo

    public int[] cantidadNegativas() {
        int[] cantidadNegativas = new int[personal.length];

        for(int i = 0; i< personal.length; i++){
            PersonalSalud personalSalud = personal[i];
            int contadorNegativas = 0;

            for (Operacion operacion: operacionesProgramadas){
                if (!operacion.isResultado()){
                    if (personalSalud instanceof Medico && (operacion.getCirujano() == personalSalud || operacion.getAnesteciologo() == personalSalud)){
                        contadorNegativas++;
                    } else if (personalSalud instanceof Enfermero && operacion.participoEnfermero(personalSalud.getTipoDocumento(), personalSalud.getDocumento())) {
                        contadorNegativas++;
                    } else {
                        if (operacion.getPersonalApoyo() != null){
                            for (PersonalSalud apoyo: operacion.getPersonalApoyo()){
                                if (apoyo == personalSalud){
                                    contadorNegativas++;
                                }
                            }
                        }
                    }
                }
            }
            cantidadNegativas[i] = contadorNegativas;
        }
        return cantidadNegativas;
    }
}
