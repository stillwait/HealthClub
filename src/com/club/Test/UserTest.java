package com.club.Test;

import com.club.Dao.CoachSalaryDao;
import com.club.Dao.UserDao;
import com.club.Dao.UserSalaryDao;
import com.club.DaoImp.CoachSalaryDaoImp;
import com.club.DaoImp.UserDaoImp;
import com.club.DaoImp.UserSalaryDaoImp;
import com.club.Po.User;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-03-25.
 */
public class UserTest {

    @Test
    public void selectAllUser() throws IOException, SQLException {
        System.out.println("测试成功");
        UserDao userDao  = new UserDaoImp();
        List<User> userList = userDao.selectAllUser();
        System.out.println(userList);
    }
    @Test
    public void selectUserById() throws IOException, SQLException {
        System.out.println("测试成功");
        UserDao userDao  = new UserDaoImp();
        User user = userDao.selectUserById(100001);
        System.out.println(user);
    }
    @Test
    public void updateUser() throws IOException, SQLException {
        UserDao userDao = new UserDaoImp();
        User user = new User(100001,"111111","王乾峰","男",22,"18240857018","http://localhost:7777/images/gakki.jpg");
        userDao.updateUser(user);
        System.out.println("测试成功");
    }

    @Test
    public void selectUserByPhone()throws IOException, SQLException{
        UserDao userDao = new UserDaoImp();
        User user = userDao.selectUserByPhone("18242057858");
        System.out.println(user);
    }

    @Test
    public void deleteUser() throws IOException, SQLException{
        UserDao userDao = new UserDaoImp();
        userDao.deleteUser(100003);

//        System.out.println(userDao.selectAllUser());
    }

    @Test
    public void selectYear() throws IOException, SQLException{
        UserSalaryDao userSalaryDao = new UserSalaryDaoImp();
        List<String> s = userSalaryDao.selectYear();
        System.out.println(s);
    }

    @Test
    public void selectNumber() throws IOException, SQLException{
        UserSalaryDao userSalaryDao = new UserSalaryDaoImp();
        CoachSalaryDao coachSalaryDao = new CoachSalaryDaoImp();
        List<Integer> s = coachSalaryDao.selectNumber();
        System.out.println(s);
    }
}
