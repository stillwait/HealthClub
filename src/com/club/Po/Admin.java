package com.club.Po;

/**
 * Created by Administrator on 2019-05-15.
 */
public class Admin {
    private int adminId;
    private String adminPwd;
    private String adminName;
    private String adminSex;
    private int adminAge;
    private String adminPhone;
    private String adminPic;

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminPwd='" + adminPwd + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminSex='" + adminSex + '\'' +
                ", adminAge=" + adminAge +
                ", adminPhone='" + adminPhone + '\'' +
                ", adminPic='" + adminPic + '\'' +
                '}';
    }

    public Admin(String adminPwd, String adminName, String adminSex, int adminAge, String adminPhone, String adminPic) {
        this.adminPwd = adminPwd;
        this.adminName = adminName;
        this.adminSex = adminSex;
        this.adminAge = adminAge;
        this.adminPhone = adminPhone;
        this.adminPic = adminPic;
    }

    public Admin(int adminId, String adminPwd, String adminName, String adminSex, int adminAge, String adminPhone, String adminPic) {
        this.adminId = adminId;
        this.adminPwd = adminPwd;
        this.adminName = adminName;
        this.adminSex = adminSex;
        this.adminAge = adminAge;
        this.adminPhone = adminPhone;
        this.adminPic = adminPic;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminSex() {
        return adminSex;
    }

    public void setAdminSex(String adminSex) {
        this.adminSex = adminSex;
    }

    public int getAdminAge() {
        return adminAge;
    }

    public void setAdminAge(int adminAge) {
        this.adminAge = adminAge;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public String getAdminPic() {
        return adminPic;
    }

    public void setAdminPic(String adminPic) {
        this.adminPic = adminPic;
    }
}
