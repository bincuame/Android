package fpoly.hai.assimentandroid.models;

import java.io.Serializable;

public class PhongBan implements Serializable {

    private String namePhongBan;

    public String getNamePhongBan() {
        return namePhongBan;
    }

    public void setNamePhongBan(String namePhongBan) {
        this.namePhongBan = namePhongBan;
    }

    public PhongBan( String namePhongBan) {
        this.namePhongBan = namePhongBan;
    }
}
