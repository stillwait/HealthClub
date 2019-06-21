package com.club.Dao;

import com.club.Po.CoachSalary;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-04.
 */
public interface CoachSalaryDao {
    public List<CoachSalary> selectAllCoachSalary() throws SQLException;
    public List<CoachSalary> selectCoachSalaryByYear(String year) throws SQLException;
    public CoachSalary selectCoachSalaryById(int id) throws SQLException;
    public CoachSalary selectCoachSalaryByTime(int coachId, String year, String month) throws SQLException;
    public void insertCoachSalary(CoachSalary coachSalary) throws SQLException;
    public void editCoachSalary(CoachSalary coachSalary) throws SQLException;
    public void deleteCoachSalary(int id) throws SQLException;
    public List<Integer> selectNumber() throws SQLException;
}
