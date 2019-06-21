package com.club.Po;

/**
 * Created by Administrator on 2019-05-04.
 */
public class SalaryList {

    private int salaryId;
    private int userId;
    private String userName;
    private String userRole;
    private String year;
    private String month;
    private float baseSalary;
    private int cqts;
    private int qqts;
    private String overTime;
    private float overSalary;
    private float jiangJin;
    private float yfSalary;

    @Override
    public String toString() {
        return "SalaryList{" +
                "salaryId=" + salaryId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userRole='" + userRole + '\'' +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", baseSalary=" + baseSalary +
                ", cqts=" + cqts +
                ", qqts=" + qqts +
                ", overTime='" + overTime + '\'' +
                ", overSalary=" + overSalary +
                ", jiangJin=" + jiangJin +
                ", yfSalary=" + yfSalary +
                '}';
    }

    public SalaryList() {
    }

    public SalaryList(int userId, String userName, String userRole, String year, String month, float baseSalary, int cqts, int qqts, String overTime, float overSalary, float jiangJin, float yfSalary) {
        this.userId = userId;
        this.userName = userName;
        this.userRole = userRole;
        this.year = year;
        this.month = month;
        this.baseSalary = baseSalary;
        this.cqts = cqts;
        this.qqts = qqts;
        this.overTime = overTime;
        this.overSalary = overSalary;
        this.jiangJin = jiangJin;
        this.yfSalary = yfSalary;
    }

    public SalaryList(int salaryId, int userId, String userName, String userRole, String year, String month, float baseSalary, int cqts, int qqts, String overTime, float overSalary, float jiangJin, float yfSalary) {
        this.salaryId = salaryId;
        this.userId = userId;
        this.userName = userName;
        this.userRole = userRole;
        this.year = year;
        this.month = month;
        this.baseSalary = baseSalary;
        this.cqts = cqts;
        this.qqts = qqts;
        this.overTime = overTime;
        this.overSalary = overSalary;
        this.jiangJin = jiangJin;
        this.yfSalary = yfSalary;
    }

    public float getOverSalary() {
        return overSalary;
    }

    public void setOverSalary(float overSalary) {
        this.overSalary = overSalary;
    }

    public int getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getCqts() {
        return cqts;
    }

    public void setCqts(int cqts) {
        this.cqts = cqts;
    }

    public int getQqts() {
        return qqts;
    }

    public void setQqts(int qqts) {
        this.qqts = qqts;
    }

    public String getOverTime() {
        return overTime;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    public float getJiangJin() {
        return jiangJin;
    }

    public void setJiangJin(float jiangJin) {
        this.jiangJin = jiangJin;
    }

    public float getYfSalary() {
        return yfSalary;
    }

    public void setYfSalary(float yfSalary) {
        this.yfSalary = yfSalary;
    }
}
