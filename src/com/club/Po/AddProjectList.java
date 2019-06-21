package com.club.Po;

import com.club.common.DateJsonDeserializer;
import com.club.common.DateJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

/**
 * Created by Administrator on 2019-05-05.
 */
public class AddProjectList {

    private int id;
    private int memId;
    private String memName;
    private String proName;
    private String proTime;
    private float proPrice;
    @JsonSerialize(using=DateJsonSerializer.class)
    @JsonDeserialize(using=DateJsonDeserializer.class)
    private Date date;

    public AddProjectList() {
    }

    @Override
    public String toString() {
        return "AddProjectList{" +
                "id=" + id +
                ", memId=" + memId +
                ", memName='" + memName + '\'' +
                ", proName=" + proName +
                ", proTime='" + proTime + '\'' +
                ", proPrice=" + proPrice +
                ", date=" + date +
                '}';
    }

    public AddProjectList(int memId, String memName, String proName, String proTime, float proPrice, Date date) {
        this.memId = memId;
        this.memName = memName;
        this.proName = proName;
        this.proTime = proTime;
        this.proPrice = proPrice;
        this.date = date;
    }

    public AddProjectList(int id, int memId, String memName, String proName, String proTime, float proPrice, Date date) {
        this.id = id;
        this.memId = memId;
        this.memName = memName;
        this.proName = proName;
        this.proTime = proTime;
        this.proPrice = proPrice;
        this.date = date;
    }

    public String getProTime() {
        return proTime;
    }

    public void setProTime(String proTime) {
        this.proTime = proTime;
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

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public float getProPrice() {
        return proPrice;
    }

    public void setProPrice(float proPrice) {
        this.proPrice = proPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
