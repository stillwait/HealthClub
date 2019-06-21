package com.club.servicesImp;

import com.club.Dao.CardDao;
import com.club.DaoImp.CardDaoImp;
import com.club.Po.Card;
import com.club.services.CardServices;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-04-21.
 */
public class CardServicesImp implements CardServices {
    @Override
    public List<Card> selectAllCard() throws SQLException {
        CardDao cardDao = new CardDaoImp();
        List<Card> list = cardDao.selectAllCard();
        return list;
    }

    @Override
    public Card selectCardById(int cardId) throws SQLException {
        CardDao cardDao = new CardDaoImp();
        Card card = cardDao.selectCardById(cardId);
        return card;
    }

    @Override
    public List<Card> selectCardName() throws SQLException {
        CardDao cardDao = new CardDaoImp();
        List<Card> list = cardDao.selectCardName();
        return list;
    }

    @Override
    public void updateCard(Card card) throws SQLException {
        CardDao cardDao = new CardDaoImp();
        cardDao.updateCard(card);
    }

    @Override
    public void deleteCard(int coachId) throws SQLException {
        CardDao cardDao = new CardDaoImp();
        cardDao.deleteCard(coachId);
    }

    @Override
    public String insertCard(Card card) throws SQLException {
        CardDao cardDao = new CardDaoImp();
        String msg = cardDao.insertCard(card);
        return msg;
    }
}
