public class Enfermero extends PersonalSalud{
    private String sala;

    public Enfermero(String tipoDocumento, String documento, String nombre, String noCarnet, String departamento, String sala){
        super(tipoDocumento, documento, nombre, noCarnet, departamento);
        this.sala = sala;
    }

    public String getSala(){
        return this.sala;
    }

    public void setSala(String sala){
        this.sala = sala;
    }
}
