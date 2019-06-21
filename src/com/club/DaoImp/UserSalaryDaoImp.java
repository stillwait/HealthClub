package com.club.DaoImp;

import com.club.Dao.UserSalaryDao;
import com.club.Po.UserSalary;
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
 * Created by Administrator on 2019-05-04.
 */
public class UserSalaryDaoImp implements UserSalaryDao {

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
    public List<UserSalary> selectAllUserSalary() throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<UserSalary> list = sqlSession.selectList("userSalary.selectAllUserSalary");
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public List<UserSalary> selectUserSalaryByYear(String year) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<UserSalary> list = sqlSession.selectList("userSalary.selectUserSalaryByYear",year);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public UserSalary selectUserSalaryById(int id) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserSalary userSalary = sqlSession.selectOne("userSalary.selectUserSalaryById",id);
        sqlSession.commit();
        sqlSession.close();
        return userSalary;
    }

    @Override
    public UserSalary selectUserSalaryByTime(int userId, String year, String month) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map<String, Object> param=new HashMap<String, Object>();
        param.put("userId", userId);
        param.put("year", year);
        param.put("month", month);
        UserSalary userSalary = sqlSession.selectOne("userSalary.selectUserSalaryByTime",param);
        sqlSession.commit();
        sqlSession.close();
        return userSalary;
    }

    @Override
    public void insertUserSalary(UserSalary userSalary) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("userSalary,insertUserSalary",userSalary);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void editUserSalary(UserSalary userSalary) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("userSalary.editUserSalary",userSalary);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteUserSalary(int id) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("userSalary.deleteUserSalary",id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<String> selectYear() throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<String> year = sqlSession.selectList("userSalary.selectYear");
        sqlSession.commit();
        sqlSession.close();
        return year;
    }

    @Override
    public List<Integer> selectNumber() throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Integer> list = sqlSession.selectList("userSalary.selectNumber");
        sqlSession.commit();
        sqlSession.close();
        return list;
    }
}
