package com.club.DaoImp;

import com.club.Dao.MemberListDao;
import com.club.Po.MemberList;
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
public class MemberListDaoImp implements MemberListDao {
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
    public List<MemberList> selectAllList() throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<MemberList> lists = sqlSession.selectList("memberList.selectAllList");
        sqlSession.commit();
        sqlSession.close();
        return lists;
    }

    @Override
    public void insertMemberList(MemberList memberList) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("memberList.insertMemberList",memberList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteMemberList(int id) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("memberList.deleteMemberList",id);
        sqlSession.commit();
        sqlSession.close();
    }
}
