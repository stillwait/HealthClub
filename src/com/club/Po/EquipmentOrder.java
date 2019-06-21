package com.club.Po;

import com.club.common.DateJsonDeserializer;
import com.club.common.DateJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

/**
 * Created by Administrator on 2019-05-04.
 */
public class EquipmentOrder {

    private int orderId;
    private int equId;
    private String equName;
    private int equNumber;
    private float equPrice;
    private float equMoney;
    @JsonSerialize(using=DateJsonSerializer.class)
    @JsonDeserialize(using=DateJsonDeserializer.class)
    private Date equDate;

    @Override
    public String toString() {
        return "EquipmentOrder{" +
                "orderId=" + orderId +
                ", equId=" + equId +
                ", equName='" + equName + '\'' +
                ", equNumber=" + equNumber +
                ", equPrice=" + equPrice +
                ", equMoney=" + equMoney +
                ", equDate=" + equDate +
                '}';
    }

    public EquipmentOrder() {
    }

    public EquipmentOrder(int orderId, int equId, String equName, int equNumber, float equPrice, float equMoney, Date equDate) {
        this.orderId = orderId;
        this.equId = equId;
        this.equName = equName;
        this.equNumber = equNumber;
        this.equPrice = equPrice;
        this.equMoney = equMoney;
        this.equDate = equDate;
    }

    public EquipmentOrder(int equId, String equName, int equNumber, float equPrice, float equMoney, Date equDate) {
        this.equId = equId;
        this.equName = equName;
        this.equNumber = equNumber;
        this.equPrice = equPrice;
        this.equMoney = equMoney;
        this.equDate = equDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public float getEquPrice() {
        return equPrice;
    }

    public void setEquPrice(float equPrice) {
        this.equPrice = equPrice;
    }

    public float getEquMoney() {
        return equMoney;
    }

    public void setEquMoney(float equMoney) {
        this.equMoney = equMoney;
    }

    public Date getEquDate() {
        return equDate;
    }

    public void setEquDate(Date equDate) {
        this.equDate = equDate;
    }
}
