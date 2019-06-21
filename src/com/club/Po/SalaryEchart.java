package com.club.Po;

/**
 * Created by Administrator on 2019-05-06.
 */
public class SalaryEchart {
    private String month;
    private float userSalary;
    private float coachSalary;

    public SalaryEchart() {
    }

    public SalaryEchart(String month, float userSalary, float coachSalary) {
        this.month = month;
        this.userSalary = userSalary;
        this.coachSalary = coachSalary;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public float getUserSalary() {
        return userSalary;
    }

    public void setUserSalary(float userSalary) {
        this.userSalary = userSalary;
    }

    public float getCoachSalary() {
        return coachSalary;
    }

    public void setCoachSalary(float coachSalary) {
        this.coachSalary = coachSalary;
    }
}
