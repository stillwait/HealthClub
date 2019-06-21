package com.club.Po;

/**
 * Created by Administrator on 2019-04-21.
 */
public class Card {
    private int cardId;
    private String cardName;
    private float cardPrice;
    private String cardBenefit;

    public Card() {
    }

    public Card(String cardName, float cardPrice, String cardBenefit) {
        this.cardName = cardName;
        this.cardPrice = cardPrice;
        this.cardBenefit = cardBenefit;
    }

    public Card(int cardId, String cardName, float cardPrice, String cardBenefit) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.cardPrice = cardPrice;
        this.cardBenefit = cardBenefit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", cardName='" + cardName + '\'' +
                ", cardPrice=" + cardPrice +
                ", cardBenefit='" + cardBenefit + '\'' +
                '}';
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
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

    public String getCardBenefit() {
        return cardBenefit;
    }

    public void setCardBenefit(String cardBenefit) {
        this.cardBenefit = cardBenefit;
    }
}
