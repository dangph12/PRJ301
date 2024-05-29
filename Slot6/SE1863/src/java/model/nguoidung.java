package model;
public class nguoidung {

    public nguoidung(String Tensudung, String Matkhau, String Masinhvien, String Lop) {
        this.Tensudung = Tensudung;
        this.Matkhau = Matkhau;
        this.Masinhvien = Masinhvien;
        this.Lop = Lop;
    }
    
    public String Tensudung;

    /**
     * Get the value of Tensudung
     *
     * @return the value of Tensudung
     */
    public String getTensudung() {
        return Tensudung;
    }

    /**
     * Set the value of Tensudung
     *
     * @param Tensudung new value of Tensudung
     */
    public void setTensudung(String Tensudung) {
        this.Tensudung = Tensudung;
    }

    public String Matkhau;

    /**
     * Get the value of Matkhau
     *
     * @return the value of Matkhau
     */
    public String getMatkhau() {
        return Matkhau;
    }

    /**
     * Set the value of Matkhau
     *
     * @param Matkhau new value of Matkhau
     */
    public void setMatkhau(String Matkhau) {
        this.Matkhau = Matkhau;
    }

    public String Masinhvien;

    /**
     * Get the value of Masinhvien
     *
     * @return the value of Masinhvien
     */
    public String getMasinhvien() {
        return Masinhvien;
    }

    /**
     * Set the value of Masinhvien
     *
     * @param Masinhvien new value of Masinhvien
     */
    public void setMasinhvien(String Masinhvien) {
        this.Masinhvien = Masinhvien;
    }

    public String Lop;

    /**
     * Get the value of Lop
     *
     * @return the value of Lop
     */
    public String getLop() {
        return Lop;
    }

    /**
     * Set the value of Lop
     *
     * @param Lop new value of Lop
     */
    public void setLop(String Lop) {
        this.Lop = Lop;
    }

}
