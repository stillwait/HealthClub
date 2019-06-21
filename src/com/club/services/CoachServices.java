package com.club.services;

import com.club.Po.Coach;
import com.club.Po.CoachSalary;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-02.
 */
public interface CoachServices {

    public List<Coach> selectAllCoach() throws SQLException;
    public Coach selectCoachById(int coachId) throws SQLException;
    public void updateCoach(Coach coach) throws SQLException;
    public void deleteCoach(int coachId) throws SQLException;
    public String insertCoach(Coach coach) throws SQLException;

    public List<CoachSalary> selectAllCoachSalary() throws SQLException;
    public CoachSalary selectCoachSalaryById(int id) throws SQLException;
    public String insertCoachSalary(CoachSalary coachSalary) throws SQLException;
    public void editCoachSalary(CoachSalary coachSalary) throws SQLException;
    public void deleteCoachSalary(int id) throws SQLException;
    public boolean deleteManyCoachSalary(Long[] ibs) throws SQLException;
}
