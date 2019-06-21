package com.club.services;

import com.club.Po.User;
import com.club.Po.UserSalary;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-04-09.
 */
public interface UserServices {
    public void updateUser(User user) throws SQLException;
    public void insertUser(User user) throws SQLException;
    public User selectUserByPhone(String userPhone) throws SQLException;
    public User selectUserById(int userId) throws SQLException;
    public List<User> selectAllUser() throws SQLException;
    public void editUser(User user) throws SQLException;
    public void deleteUser(int userId) throws SQLException;
    public List<UserSalary> selectAllUserSalary() throws SQLException;
    public UserSalary selectUserSalaryById(int id) throws SQLException;
    public String insertUserSalary(UserSalary userSalary) throws SQLException;
    public void editUserSalary(UserSalary userSalary) throws SQLException;
    public void deleteUserSalary(int id) throws SQLException;
    public boolean deleteManyUserSalary(Long[] ibs) throws SQLException;
}
