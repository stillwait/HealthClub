package com.club.DaoImp;

import com.club.Dao.UserDao;
import com.club.Po.User;
import com.club.Po.UserRole;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-03-25.
 */
public class UserDaoImp implements UserDao {

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
    public void deleteUser(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("user.deleteUser",id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteUserRole(int userId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("user.deleteUserRole",userId);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateUser(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();    //获取session对话
        try {
            sqlSession.update("user.updateUser",user);
            sqlSession.commit();
            sqlSession.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insertUser(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();    //获取session对话
        try {
            sqlSession.insert("user.insertUser",user);
            sqlSession.commit();
            sqlSession.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insertUserRole(UserRole userRole) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("user.insertUserRole",userRole);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public User selectUserByPhone(String userPhone) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("user.selectUserByPhone",userPhone);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }

    @Override
    public String selectRoleByUserId(int userId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String roleName = sqlSession.selectOne("user.selectRoleByUserId",userId);
        sqlSession.commit();
        sqlSession.close();
        return roleName;
    }

    @Override
    public List<User> selectUserByName(String username) {
        return null;
    }

    @Override
    public User selectUserById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        try{
            user = sqlSession.selectOne("user.selectUserById",id);
            sqlSession.commit();
            sqlSession.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAllUser() throws SQLException{
        SqlSession sqlSession = sqlSessionFactory.openSession();    //获取session对话
        List<User> list = sqlSession.selectList("user.selectAllUser"); //user.selectAllUser是UserMapper中的方法
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public void editUser(User user) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();    //获取session对话
        sqlSession.update("user.editUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

}
