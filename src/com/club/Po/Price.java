package com.club.Po;

/**
 * Created by Administrator on 2019-04-25.
 */
public class Price {
    private int priceId;
    private String priceName;
    private float priceMoney;

    @Override
    public String toString() {
        return "Price{" +
                "priceId=" + priceId +
                ", priceName='" + priceName + '\'' +
                ", priceMoney=" + priceMoney +
                '}';
    }

    public Price() {
    }

    public Price(String priceName, float priceMoney) {
        this.priceName = priceName;
        this.priceMoney = priceMoney;
    }

    public Price(int priceId, String priceName, float priceMoney) {
        this.priceId = priceId;
        this.priceName = priceName;
        this.priceMoney = priceMoney;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }

    public float getPriceMoney() {
        return priceMoney;
    }

    public void setPriceMoney(float priceMoney) {
        this.priceMoney = priceMoney;
    }
}
