package com.club.Dao;

import com.club.Po.UserSalary;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-04.
 */
public interface UserSalaryDao {
    public List<UserSalary> selectAllUserSalary() throws SQLException;
    public List<UserSalary> selectUserSalaryByYear(String year) throws SQLException;
    public UserSalary selectUserSalaryById(int id) throws SQLException;
    public UserSalary selectUserSalaryByTime(int userId, String year, String month) throws SQLException;
    public void insertUserSalary(UserSalary userSalary) throws SQLException;
    public void editUserSalary(UserSalary userSalary) throws SQLException;
    public void deleteUserSalary(int id) throws SQLException;
    public List<String> selectYear() throws SQLException;
    public List<Integer> selectNumber() throws SQLException;
}
