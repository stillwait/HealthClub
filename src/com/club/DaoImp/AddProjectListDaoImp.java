package com.club.DaoImp;

import com.club.Dao.AddProjectListDao;
import com.club.Po.AddProjectList;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-05.
 */
public class AddProjectListDaoImp implements AddProjectListDao {
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
    public List<AddProjectList> selectAllList() throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<AddProjectList> lists = sqlSession.selectList("addProjectList.selectAllList");
        sqlSession.commit();
        sqlSession.close();
        return lists;
    }

    @Override
    public void insertProjectList(AddProjectList addProjectList) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("addProjectList.insertProjectList",addProjectList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteProjectList(int id) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("addProjectList.deleteProjectList",id);
        sqlSession.commit();
        sqlSession.close();
    }
}
