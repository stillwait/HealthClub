package com.club.services;

import com.club.Po.Card;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-04-21.
 */
public interface CardServices {
    public List<Card> selectAllCard()throws SQLException;
    public Card selectCardById(int cardId)throws SQLException;
    public List<Card> selectCardName() throws SQLException;
    public void updateCard(Card card) throws SQLException;
    public void deleteCard(int coachId) throws SQLException;
    public String insertCard(Card card) throws SQLException;
}
