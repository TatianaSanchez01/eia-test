package QuizHospital;

import java.util.Scanner;

public class Main {
    private Hospital hospital;


    public Main(Hospital hospital) {
        super();
        this.hospital = hospital;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tipo=Integer.parseInt(in.nextLine());
        String[] parametros=null;
        if (tipo==2) parametros=in.nextLine().split(",");
        String[] cantidades=in.nextLine().split(",");
        Operacion[] operacionesProgramadas=new Operacion[Integer.parseInt(cantidades[2])];
        PersonalSalud[] personal= new PersonalSalud[Integer.parseInt(cantidades[1])];
        Paciente[] pacientes=new Paciente[Integer.parseInt(cantidades[0])];
        int cantPS = 0,cantO=0,cantP=0;
        String line;
        while (!(line=in.nextLine()).equals("")) {
            String[] datos=line.split(",");
            if (datos[0].equals("p"))
                pacientes[cantP++]=new Paciente(datos[1], datos[2], datos[3], Integer.parseInt(datos[4]), datos[5]);
            else if (datos[0].equals("o")) {
                //QuizHospital.Operacion(String codigo, QuizHospital.Paciente paciente, QuizHospital.Medico cirujano, QuizHospital.Medico anesteciologo, QuizHospital.Enfermero[] enfermeros,
                //QuizHospital.PersonalSalud[] personalApoyo, boolean resultado, int salon)
                String[] listEnf=null;
                if (!datos[4].equals(""))
                    listEnf=datos[4].split(" ");
                Enfermero[] enfermeros=null;
                if (listEnf!=null && listEnf.length!=0) {
                    enfermeros=new Enfermero[listEnf.length];
                    int i=0;
                    for (String e:listEnf) {
                        enfermeros[i++]=(Enfermero) personal[Integer.parseInt(e)];
                    }
                }
                String[] lisPers=null;
                if (!datos[5].equals(""))
                    lisPers=datos[5].split(" ");
                PersonalSalud[] apoyo=null;
                if (lisPers!=null && lisPers.length!=0) {
                    apoyo=new PersonalSalud[lisPers.length];
                    int i=0;
                    for (String e:lisPers) {
                        apoyo[i++]= personal[Integer.parseInt(e)];
                    }
                }
                operacionesProgramadas[cantO++]=new Operacion(datos[0]+datos[1], pacientes[Integer.parseInt(datos[1])],
                        (Medico)personal[Integer.parseInt(datos[2])], (Medico)personal[Integer.parseInt(datos[3])],
                        enfermeros, apoyo,Boolean.parseBoolean(datos[6]), Integer.parseInt(datos[7]));
            }else if (datos[0].equals("s")){
                personal[cantPS++]= new PersonalSalud(datos[1], datos[2], datos[3], datos[4], datos[5]);
            } else if (datos[0].equals("m")) {
                personal[cantPS++]= new Medico(datos[1], datos[2], datos[3], datos[4], datos[5],datos[6],Boolean.parseBoolean(datos[7]));
            } else if (datos[0].equals("e")) {
                personal[cantPS++]= new Enfermero(datos[1], datos[2], datos[3], datos[4], datos[5],datos[6]);
            }

        }

        Main quiz=new Main(new Hospital(operacionesProgramadas, personal, pacientes));

        if (tipo==1) {
            try{
                Enfermero[] le=quiz.hospital.listaEnfermeros();
                for(Enfermero e:le)
                    System.out.println(e.getNombre());
            } catch (EEnfermero ex){
                System.out.println(ex.getMessage());
            }

        }
        if (tipo==2) {
            Operacion[] op=quiz.hospital.operacionesEnfermero(parametros[0],parametros[1]);
            for (Operacion o:op)
                System.out.println(o.getCodigo()+ " "+ o.getCirujano().getEspecialidad()+ " "+ o.getSalon());
        }else if(tipo==3) { // Cantidad negativa
            int[] cantidad=quiz.hospital.cantidadNegativas();
            for (int i=0;i<cantidad.length;i++) {
                System.out.println(personal[i].getNoCarnet()+": "+cantidad[i]);
            }
        }
        in.close();
    }
}