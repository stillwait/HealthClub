package com.club.Dao;

import com.club.Po.SalaryList;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-04.
 */
public interface SalaryListDao {
    public void insertSalaryList(SalaryList salaryList) throws SQLException;
    public List<SalaryList> selectAllSalaryList() throws SQLException;
    public void deleteSalaryList(int id) throws SQLException;
}
