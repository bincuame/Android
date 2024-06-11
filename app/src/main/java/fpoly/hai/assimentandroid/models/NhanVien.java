package fpoly.hai.assimentandroid.models;

import java.io.Serializable;

public class NhanVien implements Serializable {
    private String maNhanVien;
    private String tenNhanVien;
    private String tenPhongBanNhanVien;

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getTenPhongBanNhanVien() {
        return tenPhongBanNhanVien;
    }

    public void setTenPhongBanNhanVien(String tenPhongBanNhanVien) {
        this.tenPhongBanNhanVien = tenPhongBanNhanVien;
    }

    public NhanVien(String maNhanVien, String tenNhanVien, String tenPhongBanNhanVien) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.tenPhongBanNhanVien = tenPhongBanNhanVien;
    }
}
