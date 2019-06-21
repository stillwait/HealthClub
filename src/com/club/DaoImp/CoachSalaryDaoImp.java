package com.club.DaoImp;

import com.club.Dao.CoachSalaryDao;
import com.club.Po.CoachSalary;
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
public class CoachSalaryDaoImp implements CoachSalaryDao {

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
    public List<CoachSalary> selectAllCoachSalary() throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<CoachSalary> list = sqlSession.selectList("coachSalary.selectAllCoachSalary");
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public List<CoachSalary> selectCoachSalaryByYear(String year) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<CoachSalary> list = sqlSession.selectList("coachSalary.selectCoachSalaryByYear",year);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public CoachSalary selectCoachSalaryById(int id) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CoachSalary coachSalary = sqlSession.selectOne("coachSalary.selectCoachSalaryById",id);
        sqlSession.commit();
        sqlSession.close();
        return coachSalary;
    }

    @Override
    public CoachSalary selectCoachSalaryByTime(int coachId, String year, String month) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map<String, Object> param=new HashMap<String, Object>();
        param.put("userId", coachId);
        param.put("year", year);
        param.put("month", month);
        CoachSalary coachSalary = sqlSession.selectOne("coachSalary.selectCoachSalaryByTime",param);
        sqlSession.commit();
        sqlSession.close();
        return coachSalary;
    }

    @Override
    public void insertCoachSalary(CoachSalary coachSalary) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("coachSalary.insertCoachSalary",coachSalary);
        sqlSession.commit();
        sqlSession.close();

    }

    @Override
    public void editCoachSalary(CoachSalary coachSalary) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("coachSalary.editCoachSalary",coachSalary);
        sqlSession.commit();
        sqlSession.close();

    }

    @Override
    public void deleteCoachSalary(int id) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("coachSalary.deleteCoachSalary",id);
        sqlSession.commit();
        sqlSession.close();

    }

    @Override
    public List<Integer> selectNumber() throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Integer> list = sqlSession.selectList("coachSalary.selectNumber");
        sqlSession.commit();
        sqlSession.close();
        return list;
    }
}
