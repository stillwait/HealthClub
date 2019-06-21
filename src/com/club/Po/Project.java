package com.club.Po;

/**
 * Created by Administrator on 2019-04-22.
 */
public class Project {
    private int proId;
    private String proName;
    private String proDescribe;
    private String proDate;


    public Project() {
    }

    public Project(int proId) {
        this.proId = proId;
    }

    public Project(String proName, String proDescribe, String proDate) {
        this.proName = proName;
        this.proDescribe = proDescribe;
        this.proDate = proDate;
    }

    public Project(int proId, String proName, String proDescribe, String proDate) {
        this.proId = proId;
        this.proName = proName;
        this.proDescribe = proDescribe;
        this.proDate = proDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "proId=" + proId +
                ", proName='" + proName + '\'' +
                ", proDescribe='" + proDescribe + '\'' +
                ", proDate='" + proDate + '\'' +
                '}';
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDescribe() {
        return proDescribe;
    }

    public void setProDescribe(String proDescribe) {
        this.proDescribe = proDescribe;
    }

    public String getProDate() {
        return proDate;
    }

    public void setProDate(String proDate) {
        this.proDate = proDate;
    }
}
