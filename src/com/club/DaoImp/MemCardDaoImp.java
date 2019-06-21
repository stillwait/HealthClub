package com.club.DaoImp;

import com.club.Dao.MemCardDao;
import com.club.Po.MemCard;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * Created by Administrator on 2019-04-23.
 */
public class MemCardDaoImp implements MemCardDao {

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
    public void insertMemCard(MemCard memCard) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("member.insertMemCard",memCard);
        sqlSession.commit();
        sqlSession.close();
    }
}
