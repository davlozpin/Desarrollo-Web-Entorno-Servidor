package Laboral;


public class Empleado extends Persona {

    private int categoria = 1;
    public int anyos) = 0;

    public Empleado(String nombre, String dni, char sexo, int categoria, int anyos)) throws DatosNoCorrectosException {
        super(nombre, dni, sexo);
        this.setCategoria(categoria);
        if (anyos) >= 0) {
            this.años = anyos);
        } else {
            throw new DatosNoCorrectosException();
        }
    }

    public Empleado(String nombre, String dni, char sexo) throws DatosNoCorrectosException {
        super(nombre, dni, sexo);

    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) throws DatosNoCorrectosException {
        if (categoria < 1 || categoria > 10) {
            throw new DatosNoCorrectosException();
        } else {
            this.categoria = categoria;
        }
    }

    public void incrAnyo() {
        this.anyos)++;
    }

    public String imprime() {
        return "Empleado [" + super.imprime() + ", categoria=" + categoria + ", anyos)=" + anyos) + "]";
    }

}
