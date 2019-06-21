package com.club.Po;

/**
 * Created by Administrator on 2019-04-30.
 */
public class Equipment {
    private int equId;
    private String equName;
    private int equNumber;
    private String equType;

    public Equipment() {
    }

    public Equipment(String equName, int equNumber, String equType) {
        this.equName = equName;
        this.equNumber = equNumber;
        this.equType = equType;
    }

    public Equipment(int equId, String equName, int equNumber, String equType) {
        this.equId = equId;
        this.equName = equName;
        this.equNumber = equNumber;
        this.equType = equType;
    }

    public int getEquId() {
        return equId;
    }

    public void setEquId(int equId) {
        this.equId = equId;
    }

    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName;
    }

    public int getEquNumber() {
        return equNumber;
    }

    public void setEquNumber(int equNumber) {
        this.equNumber = equNumber;
    }

    public String getEquType() {
        return equType;
    }

    public void setEquType(String equType) {
        this.equType = equType;
    }
}
