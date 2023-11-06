package Clases;

public class Profesores {
    private Integer cod_Prof;
    private String nombre_Ape, especialidad;
    private Integer jefe_Dep;
    private String f_Nac;
    private String sexo;
    private Integer cod_Centro;

    public Profesores(Integer cod_Prof, String nombre_Ape, String especialidad, Integer jefe_Dep,String f_Nac, String sexo, Integer cod_Centro) {
        this.cod_Prof = cod_Prof;
        this.nombre_Ape = nombre_Ape;
        this.especialidad = especialidad;
        this.jefe_Dep=jefe_Dep;
        this.f_Nac = f_Nac;
        this.sexo = sexo;
        this.cod_Centro = cod_Centro;
    }

    public Integer getCod_Prof() {
        return cod_Prof;
    }

    public void setCod_Prof(Integer cod_Prof) {
        this.cod_Prof = cod_Prof;
    }

    public String getNombre_Ape() {
        return nombre_Ape;
    }

    public void setNombre_Ape(String nombre_Ape) {
        this.nombre_Ape = nombre_Ape;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Integer getJefe_Dep() {
        return jefe_Dep;
    }

    public void setJefe_Dep(Integer jefe_Dep) {
        this.jefe_Dep = jefe_Dep;
    }

    public String getF_Nac() {
        return f_Nac;
    }

    public void setF_Nac(String f_Nac) {
        this.f_Nac = f_Nac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getCod_Centro() {
        return cod_Centro;
    }

    public void setCod_Centro(Integer cod_Centro) {
        this.cod_Centro = cod_Centro;
    }
}
