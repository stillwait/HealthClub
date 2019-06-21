package com.club.Po;

import com.club.common.DateJsonDeserializer;
import com.club.common.DateJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019-04-25.
 */
public class MemProject{
    private int id;
    private int memId;
    private int proId;
    private int priceId;
    @JsonSerialize(using=DateJsonSerializer.class)
    @JsonDeserialize(using=DateJsonDeserializer.class)
    private Date proDate;
    private float realMoney;
//    private Project project;


    @Override
    public String toString() {
        return "MemProject{" +
                "id=" + id +
                ", memId=" + memId +
                ", proId=" + proId +
                ", priceId=" + priceId +
                ", proDate=" + proDate +
                ", realMoney=" + realMoney +
                '}';
    }

    public MemProject() {
    }

    public MemProject(int id, int memId, int proId, int priceId, Date proDate, float realMoney) {
        this.id = id;
        this.memId = memId;
        this.proId = proId;
        this.priceId = priceId;
        this.proDate = proDate;
        this.realMoney = realMoney;
    }

    public MemProject(int memId, int proId, int priceId, Date proDate, float realMoney) {
        this.memId = memId;
        this.proId = proId;
        this.priceId = priceId;
        this.proDate = proDate;
        this.realMoney = realMoney;
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

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public Date getProDate() {
        return proDate;
    }

    public void setProDate(Date proDate) {
        this.proDate = proDate;
    }

    public float getRealMoney() {
        return realMoney;
    }

    public void setRealMoney(float realMoney) {
        this.realMoney = realMoney;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }
}
