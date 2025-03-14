public class Medico extends PersonalSalud {
        private String especialidad;
        private boolean cirujano;

        public Medico(String tipoDocumento, String documento, String nombre, String noCarnet, String departamento, String especialidad, boolean cirujano) {
                super(tipoDocumento, documento, nombre, noCarnet, departamento);
                this.especialidad = especialidad;
                this.cirujano = cirujano;
        }

        public String getEspecialidad() {
                return especialidad;
        }

        public void setEspecialidad(String especialidad) {
                this.especialidad = especialidad;
        }

        public boolean isCirujano() {
                return cirujano;
        }

        public void setCirujano(boolean cirujano) {
                this.cirujano = cirujano;
        }
}
