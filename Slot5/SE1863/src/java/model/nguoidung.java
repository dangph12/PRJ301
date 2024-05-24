package model;
public class nguoidung {
    public String Tensudung;
    public String Matkhau;

    public nguoidung(String Tensudung, String Matkhau, boolean attend) {
        this.Tensudung = Tensudung;
        this.Matkhau = Matkhau;
        this.attend = attend;
    }

    public void setTensudung(String Tensudung) {
        this.Tensudung = Tensudung;
    }

    public void setMatkhau(String Matkhau) {
        this.Matkhau = Matkhau;
    }

    public String getTensudung() {
        return Tensudung;
    }

    public String getMatkhau() {
        return Matkhau;
    }
    
    public boolean attend;

    /**
     * Get the value of attend
     *
     * @return the value of attend
     */
    public boolean isAttend() {
        return attend;
    }

    /**
     * Set the value of attend
     *
     * @param attend new value of attend
     */
    public void setAttend(boolean attend) {
        this.attend = attend;
    }

}
