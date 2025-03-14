public class PersonalSalud extends Persona {
    protected String noCarnet;
    protected String departamento;

    public PersonalSalud(String tipoDocumento, String documento, String nombre, String noCarnet, String departamento) {
        super(tipoDocumento, documento, nombre);
        this.noCarnet = noCarnet;
        this.departamento = departamento;
    }

    public String getNoCarnet() {
        return noCarnet;
    }

    public void setNoCarnet(String noCarnet) {
        this.noCarnet = noCarnet;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
