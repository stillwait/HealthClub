package com.club.Dao;

import com.club.Po.AddProjectList;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-05.
 */
public interface AddProjectListDao {
    public List<AddProjectList> selectAllList() throws SQLException;
    public void insertProjectList(AddProjectList addProjectList) throws SQLException;
    public void deleteProjectList(int id) throws SQLException;
}
