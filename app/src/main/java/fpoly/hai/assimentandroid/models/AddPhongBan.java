package fpoly.hai.assimentandroid.models;

import java.io.Serializable;

public class AddPhongBan implements Serializable {
    private String nameAddPhongBan;

    public String getNameAddPhongBan() {
        return nameAddPhongBan;
    }

    public void setNameAddPhongBan(String nameAddPhongBan) {
        this.nameAddPhongBan = nameAddPhongBan;
    }

    public AddPhongBan(String nameAddPhongBan) {
        this.nameAddPhongBan = nameAddPhongBan;
    }
}
