package com.club.Dao;

import com.club.Po.Coach;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-02.
 */
public interface CoachDao {

    public List<Coach> selectAllCoach() throws SQLException;
    public Coach selectCoachById(int coachId) throws SQLException;
    public Coach selectCoachByPhone(String coachPhone) throws SQLException;
    public void updateCoach(Coach coach) throws SQLException;
    public void deleteCoach(int coachId) throws SQLException;
    public String insertCoach(Coach coach) throws SQLException;
}
