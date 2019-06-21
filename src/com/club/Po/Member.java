package com.club.Po;

import com.club.common.DateJsonDeserializer;
import com.club.common.DateJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2019-04-18.
 */
public class Member {
    private int memId;
    private String memName;
    private String memPwd;
    private String memSex;
    private int memAge;
    private String memPhone;
    @JsonSerialize(using=DateJsonSerializer.class)
    @JsonDeserialize(using=DateJsonDeserializer.class)
//    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date memDate;
    private float memMoney;
    private String memPic;

    public Member() {
    }

    public Member(int memId,float memMoney) {
        this.memId = memId;
        this.memMoney = memMoney;
    }

    public Member(String memName, String memPwd, String memSex, int memAge, String memPhone, Date memDate, float memMoney, String memPic) {
        this.memName = memName;
        this.memPwd = memPwd;
        this.memSex = memSex;
        this.memAge = memAge;
        this.memPhone = memPhone;
        this.memDate = memDate;
        this.memMoney = memMoney;
        this.memPic = memPic;
    }

    public Member(String memName, String memPwd, String memSex, int memAge, String memPhone, Date memDate, float memMoney) {
        this.memName = memName;
        this.memPwd = memPwd;
        this.memSex = memSex;
        this.memAge = memAge;
        this.memPhone = memPhone;
        this.memDate = memDate;
        this.memMoney = memMoney;
    }

    public Member(int memId, String memName, String memPwd, String memSex, int memAge, String memPhone, Date memDate, float memMoney, String memPic) {
        this.memId = memId;
        this.memName = memName;
        this.memPwd = memPwd;
        this.memSex = memSex;
        this.memAge = memAge;
        this.memPhone = memPhone;
        this.memDate = memDate;
        this.memMoney = memMoney;
        this.memPic = memPic;
    }

    public Member(int memId, String memName, String memPwd, String memSex, int memAge, String memPhone, Date memDate, float memMoney) {
        this.memId = memId;
        this.memName = memName;
        this.memPwd = memPwd;
        this.memSex = memSex;
        this.memAge = memAge;
        this.memPhone = memPhone;
        this.memDate = memDate;
        this.memMoney = memMoney;
    }

    public Member(int memId, String memName, String memPwd, String memSex, int memAge, String memPhone, Date memDate) {
        this.memId = memId;
        this.memName = memName;
        this.memPwd = memPwd;
        this.memSex = memSex;
        this.memAge = memAge;
        this.memPhone = memPhone;
        this.memDate = memDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memId=" + memId +
                ", memName='" + memName + '\'' +
                ", memPwd='" + memPwd + '\'' +
                ", memSex='" + memSex + '\'' +
                ", memAge=" + memAge +
                ", memPhone='" + memPhone + '\'' +
                ", memDate=" + memDate +
                ", memMoney=" + memMoney +
                ", memPic='" + memPic + '\'' +
                '}';
    }

    public String getMemPic() {
        return memPic;
    }

    public void setMemPic(String memPic) {
        this.memPic = memPic;
    }

    public String getMemPwd() {
        return memPwd;
    }

    public void setMemPwd(String memPwd) {
        this.memPwd = memPwd;
    }

    public int getMemId() {
        return memId;
    }

    public void setMemId(int memId) {
        this.memId = memId;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemSex() {
        return memSex;
    }

    public void setMemSex(String memSex) {
        this.memSex = memSex;
    }

    public int getMemAge() {
        return memAge;
    }

    public void setMemAge(int memAge) {
        this.memAge = memAge;
    }

    public String getMemPhone() {
        return memPhone;
    }

    public void setMemPhone(String memPhone) {
        this.memPhone = memPhone;
    }

    public Date getMemDate() {
        return memDate;
    }

    public void setMemDate(Date memDate) {
        this.memDate = memDate;
    }

    public float getMemMoney() {
        return memMoney;
    }

    public void setMemMoney(float memMoney) {
        this.memMoney = memMoney;
    }
}
