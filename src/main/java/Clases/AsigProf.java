package Clases;

public class AsigProf {
    private String cod_Asig;
    private Integer cod_Prof;

    public AsigProf(String cod_Asig, Integer cod_Prof) {
        this.cod_Asig = cod_Asig;
        this.cod_Prof = cod_Prof;
    }

    public String getCod_Asig() {
        return cod_Asig;
    }

    public void setCod_Asig(String cod_Asig) {
        this.cod_Asig = cod_Asig;
    }

    public Integer getCod_Prof() {
        return cod_Prof;
    }

    public void setCod_Prof(Integer cod_Prof) {
        this.cod_Prof = cod_Prof;
    }
}
