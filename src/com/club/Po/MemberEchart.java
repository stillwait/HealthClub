package com.club.Po;

/**
 * Created by Administrator on 2019-05-06.
 */
public class MemberEchart {

    private String month;
    private float money;

    public MemberEchart(String month, float money) {
        this.month = month;
        this.money = money;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }
}
