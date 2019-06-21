package com.club.Po;

import com.club.common.DateJsonDeserializer;
import com.club.common.DateJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

/**
 * Created by Administrator on 2019-05-04.
 */
public class MemberList {

    private int id;
    private int memId;
    private String memName;
    private String cardName;
    private float cardPrice;
    @JsonSerialize(using=DateJsonSerializer.class)
    @JsonDeserialize(using=DateJsonDeserializer.class)
    private Date memDate;

    @Override
    public String toString() {
        return "MemberList{" +
                "id=" + id +
                ", memId=" + memId +
                ", memName='" + memName + '\'' +
                ", cardName='" + cardName + '\'' +
                ", cardPrice=" + cardPrice +
                ", memDate=" + memDate +
                '}';
    }

    public MemberList() {
    }

    public MemberList(int memId, String memName, String cardName, float cardPrice, Date memDate) {
        this.memId = memId;
        this.memName = memName;
        this.cardName = cardName;
        this.cardPrice = cardPrice;
        this.memDate = memDate;
    }

    public MemberList(int id, int memId, String memName, String cardName, float cardPrice, Date memDate) {
        this.id = id;
        this.memId = memId;
        this.memName = memName;
        this.cardName = cardName;
        this.cardPrice = cardPrice;
        this.memDate = memDate;
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

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public float getCardPrice() {
        return cardPrice;
    }

    public void setCardPrice(float cardPrice) {
        this.cardPrice = cardPrice;
    }

    public Date getMemDate() {
        return memDate;
    }

    public void setMemDate(Date memDate) {
        this.memDate = memDate;
    }
}
