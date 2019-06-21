package com.club.Po;

import com.club.common.DateJsonDeserializer;
import com.club.common.DateJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

/**
 * Created by Administrator on 2019-05-04.
 */
public class AddMoneyList {
    private int id;
    private int memId;
    private String memName;
    private float addMoney;
    private float memMoney;
    @JsonSerialize(using=DateJsonSerializer.class)
    @JsonDeserialize(using=DateJsonDeserializer.class)
    private Date date;

    @Override
    public String toString() {
        return "AddMoneyList{" +
                "id=" + id +
                ", memId=" + memId +
                ", memName='" + memName + '\'' +
                ", addMoney=" + addMoney +
                ", memMoney=" + memMoney +
                ", date=" + date +
                '}';
    }

    public AddMoneyList() {
    }

    public AddMoneyList(int memId, String memName, float addMoney, float memMoney, Date date) {
        this.memId = memId;
        this.memName = memName;
        this.addMoney = addMoney;
        this.memMoney = memMoney;
        this.date = date;
    }

    public AddMoneyList(int id, int memId, String memName, float addMoney, float memMoney, Date date) {
        this.id = id;
        this.memId = memId;
        this.memName = memName;
        this.addMoney = addMoney;
        this.memMoney = memMoney;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public float getAddMoney() {
        return addMoney;
    }

    public void setAddMoney(float addMoney) {
        this.addMoney = addMoney;
    }

    public float getMemMoney() {
        return memMoney;
    }

    public void setMemMoney(float memMoney) {
        this.memMoney = memMoney;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
