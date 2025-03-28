package QuizHospital;

public class Paciente extends Persona {
    private int edad;
    private String eps;

    public Paciente(String tipoDocumento, String documento, String nombre, int edad, String eps) {
        super(tipoDocumento, documento, nombre);
        this.edad = edad;
        this.eps = eps;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }
}
