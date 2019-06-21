package com.club.Dao;

import com.club.Po.Price;
import com.club.Po.ProPrice;
import com.club.Po.Project;
import com.club.Po.ProjectPrice;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-04-24.
 */
public interface ProjectDao {
    public List<Project> selectAllProject() throws SQLException;
    public List<Price> selectAllPriceById(int proId) throws SQLException;
    public List<ProjectPrice> selectProPriceInfo(int proId) throws SQLException;
    public void deleteProject(int proId) throws SQLException;
    public void deletePriceByName(int proId, String priceName) throws SQLException;
    public void insertProject(Project project) throws SQLException;
    public void insertProjectPrice(ProPrice proPrice) throws SQLException;
    public Project selectProjectByName(String proName) throws SQLException;
    public Project selectProjectById(int proId) throws SQLException;
    public void updateProject(Project project) throws SQLException;
    public void updateProjectPrice(ProPrice proPrice) throws SQLException;
    public List<String> selectProCoach(int proId) throws SQLException;
}
