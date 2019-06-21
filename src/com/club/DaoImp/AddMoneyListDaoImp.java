package com.club.DaoImp;

import com.club.Dao.AddMoneyListDao;
import com.club.Po.AddMoneyList;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-04.
 */
public class AddMoneyListDaoImp implements AddMoneyListDao {
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
    public List<AddMoneyList> selectAllList() throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<AddMoneyList> lists = sqlSession.selectList("addMoneyList.selectAllList");
        sqlSession.commit();
        sqlSession.close();
        return lists;
    }

    @Override
    public void insertMoneyList(AddMoneyList addMoneyList) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("addMoneyList.insertMoneyList",addMoneyList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteMoneyList(int id) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("addMoneyList.deleteMoneyList",id);
        sqlSession.commit();
        sqlSession.close();
    }
}
