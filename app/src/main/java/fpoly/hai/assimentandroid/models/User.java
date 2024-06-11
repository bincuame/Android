package fpoly.hai.assimentandroid.models;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private String passWord;
    private String PassWordConfirm;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPassWordConfirm() {
        return PassWordConfirm;
    }

    public void setPassWordConfirm(String passWordConfirm) {
        PassWordConfirm = passWordConfirm;
    }

    public User(String userName, String passWord, String passWordConfirm) {
        this.userName = userName;
        this.passWord = passWord;
        PassWordConfirm = passWordConfirm;
    }
}
