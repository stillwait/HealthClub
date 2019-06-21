package com.club.Po;

/**
 * Created by Administrator on 2019-04-30.
 */
public class ProPrice {
    private int id;
    private int proId;
    private int priceId;

    public ProPrice() {
    }

    @Override
    public String toString() {
        return "ProPrice{" +
                "id=" + id +
                ", proId=" + proId +
                ", priceId=" + priceId +
                '}';
    }

    public ProPrice(int proId, int priceId) {
        this.proId = proId;
        this.priceId = priceId;
    }

    public ProPrice(int id, int proId, int priceId) {
        this.id = id;
        this.proId = proId;
        this.priceId = priceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }
}
