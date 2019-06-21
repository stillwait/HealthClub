package com.club.DaoImp;

import com.club.Dao.CardDao;
import com.club.Po.Card;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019-04-21.
 */
public class CardDaoImp implements CardDao {
    private static SqlSessionFactory sqlSessionFactory; //生成sql会话工厂类对象
    static{
        String resource = "SqlMapConfig.xml";      //加载mybatis配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);    //返回io流
            //生成sql会话工厂类对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Card> selectAllCard() throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Card> list = sqlSession.selectList("card.selectAllCard");
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public List<Card> selectCardName() throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Card> list = sqlSession.selectList("card.selectCardName");
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public Card selectCardById(int cardId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Card card = sqlSession.selectOne("card.selectCardById",cardId);
        sqlSession.commit();
        sqlSession.close();
        return card;
    }

    @Override
    public void updateCard(Card card) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("card.updateCard",card);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteCard(int coachId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("card.deleteCard",coachId);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public String insertCard(Card card) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map<String, Object> param=new HashMap<String, Object>();
        param.put("cardName", card.getCardName());
        param.put("cardPrice", card.getCardPrice());
        Card card1 = sqlSession.selectOne("card.selectCardByName",param);
        if (card1 == null){
            sqlSession.insert("card.insertCard",card);
            sqlSession.commit();
            sqlSession.close();
            return "*添加成功";
        }else{
            return "*该会员卡已存在";
        }
    }
}
