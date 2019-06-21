package com.club.Dao;

import com.club.Po.User;
import com.club.Po.UserRole;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-03-25.
 */
public interface UserDao {
    public void deleteUser(int userId) throws SQLException;

    public void deleteUserRole(int userId) throws SQLException;

    public void updateUser(User user) throws SQLException;

    public void insertUser(User user) throws SQLException;

    public void insertUserRole(UserRole userRole) throws SQLException;

    public User selectUserByPhone(String userPhone) throws SQLException;

    public String selectRoleByUserId(int userId) throws SQLException;

    public List<User> selectUserByName(String username) throws SQLException;

    public User selectUserById(int id) throws SQLException;

    public List<User> selectAllUser() throws SQLException;

    public void editUser(User user) throws SQLException;

}
