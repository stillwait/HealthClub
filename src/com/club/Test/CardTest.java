package com.club.Test;

import com.club.Dao.CardDao;
import com.club.DaoImp.CardDaoImp;
import com.club.Po.Card;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-04-21.
 */
public class CardTest {

    @Test
    public void selctCardName() throws IOException, SQLException {
        CardDao cardDao = new CardDaoImp();
        List<Card> list = cardDao.selectCardName();
        System.out.println(list);
    }
}
