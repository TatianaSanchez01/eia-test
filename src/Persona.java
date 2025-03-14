public abstract class Persona {
    protected String tipoDocumento;
    protected String documento;
    protected String nombre;

    public Persona(String tipoDocumento, String documento, String nombre) {
        super();
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
