package Clases;

public class Especialidad {
    private String especialidad;
    private String nombre;

    public Especialidad(String especialidad, String nombre) {
        this.especialidad = especialidad;
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
