package Clases;

public class Asignaturas {
    private String cod, nombre;

    public Asignaturas(String cod, String nombre) {
        this.cod = cod;
        this.nombre = nombre;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
