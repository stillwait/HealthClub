package com.club.servicesImp;

import com.club.Dao.SalaryListDao;
import com.club.Dao.UserDao;
import com.club.Dao.UserSalaryDao;
import com.club.DaoImp.SalaryListDaoImp;
import com.club.DaoImp.UserDaoImp;
import com.club.DaoImp.UserSalaryDaoImp;
import com.club.Po.SalaryList;
import com.club.Po.User;
import com.club.Po.UserRole;
import com.club.Po.UserSalary;
import com.club.services.UserServices;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-04-09.
 */
public class UserServicesImp implements UserServices {
    @Override
    public void updateUser(User user) throws SQLException {
        UserDao userDao = new UserDaoImp();
        userDao.updateUser(user);
    }

    @Override
    public void insertUser(User user) throws SQLException {
        UserDao userDao = new UserDaoImp();
        String userPhone = user.getUserPhone();
        userDao.insertUser(user);
        User user1 = userDao.selectUserByPhone(userPhone);
        UserRole userRole = new UserRole(user1.getUserId(),2);
        userDao.insertUserRole(userRole);
    }

    @Override
    public User selectUserByPhone(String userPhone) throws SQLException {
        UserDao userDao = new UserDaoImp();
        User user = userDao.selectUserByPhone(userPhone);
        return user;
    }

    @Override
    public User selectUserById(int userId) throws SQLException {
        UserDao userDao = new UserDaoImp();
        User user = userDao.selectUserById(userId);
        return user;
    }

    @Override
    public List<User> selectAllUser() throws SQLException {
        UserDao userDao = new UserDaoImp();
        List<User> list = userDao.selectAllUser();
        return list;
    }

    @Override
    public void editUser(User user) throws SQLException {
        UserDao userDao = new UserDaoImp();
        userDao.editUser(user);
    }

    @Override
    public void deleteUser(int userId) throws SQLException {
        UserDao userDao = new UserDaoImp();
        userDao.deleteUser(userId);
        userDao.deleteUserRole(userId);
    }

    @Override
    public List<UserSalary> selectAllUserSalary() throws SQLException {
        UserSalaryDao userSalaryDao = new UserSalaryDaoImp();
        List<UserSalary> list = userSalaryDao.selectAllUserSalary();
        return list;
    }

    @Override
    public UserSalary selectUserSalaryById(int id) throws SQLException {
        UserSalaryDao userSalaryDao = new UserSalaryDaoImp();
        UserSalary userSalary = userSalaryDao.selectUserSalaryById(id);
        return userSalary;
    }

    @Override
    public String insertUserSalary(UserSalary userSalary) throws SQLException {
        UserSalaryDao userSalaryDao = new UserSalaryDaoImp();
        SalaryListDao salaryListDao = new SalaryListDaoImp();
        SalaryList salaryList = new SalaryList(userSalary.getUserId(),userSalary.getUserName(),userSalary.getUserRole(),userSalary.getYear(),userSalary.getMonth(),userSalary.getBaseSalary(),userSalary.getCqts(),userSalary.getQqts(),userSalary.getOverTime(),userSalary.getOverSalary(),userSalary.getJiangJin(),userSalary.getYfSalary());
        UserSalary userSalary1 = userSalaryDao.selectUserSalaryByTime(userSalary.getUserId(),userSalary.getYear(),userSalary.getMonth());
        if (userSalary1 == null){
            userSalaryDao.insertUserSalary(userSalary);
            salaryListDao.insertSalaryList(salaryList);
            return "添加成功";
        }else{
            return "*该信息已存在";
        }

    }

    @Override
    public void editUserSalary(UserSalary userSalary) throws SQLException {
        UserSalaryDao userSalaryDao = new UserSalaryDaoImp();
        userSalaryDao.editUserSalary(userSalary);
    }

    @Override
    public void deleteUserSalary(int id) throws SQLException {
        UserSalaryDao userSalaryDao = new UserSalaryDaoImp();
        userSalaryDao.deleteUserSalary(id);
    }

    @Override
    public boolean deleteManyUserSalary(Long[] ibs) throws SQLException {
        UserSalaryDao userSalaryDao = new UserSalaryDaoImp();
        for (int i = 0;i < ibs.length; i++){
            userSalaryDao.deleteUserSalary(ibs[i].intValue());
        }
        return true;
    }

}
