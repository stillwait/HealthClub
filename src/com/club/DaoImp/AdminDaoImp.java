package com.club.DaoImp;

import com.club.Dao.AdminDao;
import com.club.Po.Admin;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * Created by Administrator on 2019-05-15.
 */
public class AdminDaoImp implements AdminDao {
    private static SqlSessionFactory sqlSessionFactory;
    static{
        String resource = "SqlMapConfig.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Admin selectAdminById(int adminId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Admin admin = sqlSession.selectOne("admin.selectAdminById",adminId);
        sqlSession.commit();
        sqlSession.close();
        return admin;
    }

    @Override
    public void updateAdmin(Admin admin) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("admin.updateAdmin",admin);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Admin selectAdminByPhone(String adminPhone) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Admin admin = sqlSession.selectOne("admin.selectAdminByPhone",adminPhone);
        sqlSession.commit();
        sqlSession.close();
        return admin;
    }
}
