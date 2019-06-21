package com.club.DaoImp;

import com.club.Dao.SalaryListDao;
import com.club.Po.SalaryList;
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
public class SalaryListDaoImp implements SalaryListDao {
    private static SqlSessionFactory sqlSessionFactory;
    static{

        String resource = "SqlMapConfig.xml";      //加载mybatis配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);    //返回io流
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void insertSalaryList(SalaryList salaryList) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("salaryList.insertSalaryList",salaryList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<SalaryList> selectAllSalaryList() throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<SalaryList> lists = sqlSession.selectList("salaryList.selectAllSalaryList");
        sqlSession.commit();
        sqlSession.close();
        return lists;
    }

    @Override
    public void deleteSalaryList(int id) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("salaryList.deleteSalaryList",id);
        sqlSession.commit();
        sqlSession.close();
    }
}
