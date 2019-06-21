package com.club.DaoImp;

import com.club.Dao.CoachDao;
import com.club.Po.Coach;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-02.
 */
public class CoachDaoImp implements CoachDao {

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
    public List<Coach> selectAllCoach() throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Coach> list = sqlSession.selectList("coach.selectAllCoach");
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public Coach selectCoachById(int coachId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Coach coach = sqlSession.selectOne("coach.selectCoachById",coachId);
        sqlSession.commit();
        sqlSession.close();
        return coach;
    }

    @Override
    public Coach selectCoachByPhone(String coachPhone) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Coach coach = sqlSession.selectOne("coach.selectCoachByPhone",coachPhone);
        sqlSession.commit();
        sqlSession.close();
        return coach;
    }

    @Override
    public void updateCoach(Coach coach) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("coach.updateCoach",coach);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteCoach(int coachId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("coach.deleteCoach",coachId);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public String insertCoach(Coach coach) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Coach coach1 = sqlSession.selectOne("coach.selectCoachByPhone",coach.getCoachPhone());
        if (coach1 == null){
            sqlSession.insert("coach.insertCoach",coach);
            sqlSession.commit();
            sqlSession.close();
            return "*添加成功";
        }else{
            return "*该教练已存在";
        }
    }
}
