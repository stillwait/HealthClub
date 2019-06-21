package com.club.Po;

/**
 * Created by Administrator on 2019-04-23.
 */
public class MemCard {
    private int id;
    private int memId;
    private int cardId;

    public MemCard() {
    }

    @Override
    public String toString() {
        return "MemCard{" +
                "id=" + id +
                ", memId=" + memId +
                ", cardId=" + cardId +
                '}';
    }

    public MemCard(int memId, int cardId) {
        this.memId = memId;
        this.cardId = cardId;
    }

    public MemCard(int id, int memId, int cardId) {
        this.id = id;
        this.memId = memId;
        this.cardId = cardId;
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

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
}
