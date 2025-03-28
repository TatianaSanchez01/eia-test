package QuizHospital;

public class Operacion {
    private String codigo;
    private Paciente paciente;
    private Medico cirujano;
    private Medico anesteciologo;
    private Enfermero[] enfermeros;
    private PersonalSalud[] personalApoyo;
    private boolean resultado;
    private int salon;

    public Operacion(String codigo, Paciente paciente, Medico cirujano, Medico anesteciologo, Enfermero[] enfermeros,
                     PersonalSalud[] personalApoyo, boolean resultado, int salon) {
        this.codigo = codigo;
        this.paciente = paciente;
        this.cirujano = cirujano;
        this.anesteciologo = anesteciologo;
        this.enfermeros = enfermeros;
        this.personalApoyo = personalApoyo;
        this.resultado = resultado;
        this.salon = salon;
    }

    public String getCodigo() {
        return codigo;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public Medico getCirujano() {
        return cirujano;
    }
    public Medico getAnesteciologo() {
        return anesteciologo;
    }
    public Enfermero[] getEnfermeros() {
        return enfermeros;
    }
    public PersonalSalud[] getPersonalApoyo() {
        return personalApoyo;
    }
    public boolean isResultado() {
        return resultado;
    }
    public int getSalon() {
        return salon;
    }

    //Verdadero si el enfermero participo
    public boolean participoEnfermero(String tipodoc, String doc) {
        if (enfermeros != null){
            for( Enfermero enfermero: enfermeros){
                if(enfermero.getTipoDocumento().equals(tipodoc) && enfermero.getDocumento().equals(doc)){
                    return true;
                }
            }
        }
        return true;
    }
}
