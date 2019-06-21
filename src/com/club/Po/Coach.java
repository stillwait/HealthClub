package com.club.Po;

/**
 * Created by Administrator on 2019-04-24.
 */
public class Coach {
    private int coachId;
    private String coachName;
    private String coachSex;
    private int coachAge;
    private String coachEdu;
    private String coachExp;
    private String coachCert;
    private String coachAdv;
    private String coachMotto;
    private String coachPhone;
    private String coachPic;

    public Coach() {
    }

    public Coach(int coachId, String coachName, String coachSex, int coachAge, String coachEdu, String coachExp, String coachCert, String coachAdv, String coachMotto, String coachPhone, String coachPic) {
        this.coachId = coachId;
        this.coachName = coachName;
        this.coachSex = coachSex;
        this.coachAge = coachAge;
        this.coachEdu = coachEdu;
        this.coachExp = coachExp;
        this.coachCert = coachCert;
        this.coachAdv = coachAdv;
        this.coachMotto = coachMotto;
        this.coachPhone = coachPhone;
        this.coachPic = coachPic;
    }

    public Coach(String coachName, String coachSex, int coachAge, String coachEdu, String coachExp, String coachCert, String coachAdv, String coachMotto, String coachPhone, String coachPic) {
        this.coachName = coachName;
        this.coachSex = coachSex;
        this.coachAge = coachAge;
        this.coachEdu = coachEdu;
        this.coachExp = coachExp;
        this.coachCert = coachCert;
        this.coachAdv = coachAdv;
        this.coachMotto = coachMotto;
        this.coachPhone = coachPhone;
        this.coachPic = coachPic;
    }

    public String getCoachPhone() {
        return coachPhone;
    }

    public void setCoachPhone(String coachPhone) {
        this.coachPhone = coachPhone;
    }

    public String getCoachEdu() {
        return coachEdu;
    }

    public void setCoachEdu(String coachEdu) {
        this.coachEdu = coachEdu;
    }

    public String getCoachExp() {
        return coachExp;
    }

    public void setCoachExp(String coachExp) {
        this.coachExp = coachExp;
    }

    public String getCoachCert() {
        return coachCert;
    }

    public void setCoachCert(String coachCert) {
        this.coachCert = coachCert;
    }

    public String getCoachAdv() {
        return coachAdv;
    }

    public void setCoachAdv(String coachAdv) {
        this.coachAdv = coachAdv;
    }

    public String getCoachMotto() {
        return coachMotto;
    }

    public void setCoachMotto(String coachMotto) {
        this.coachMotto = coachMotto;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getCoachSex() {
        return coachSex;
    }

    public void setCoachSex(String coachSex) {
        this.coachSex = coachSex;
    }

    public int getCoachAge() {
        return coachAge;
    }

    public void setCoachAge(int coachAge) {
        this.coachAge = coachAge;
    }

    public String getCoachPic() {
        return coachPic;
    }

    public void setCoachPic(String coachPic) {
        this.coachPic = coachPic;
    }
}
