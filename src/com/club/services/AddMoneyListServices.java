package com.club.services;

import com.club.Po.AddMoneyList;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-04.
 */
public interface AddMoneyListServices {

    public List<AddMoneyList> selectAllList() throws SQLException;
    public void insertMoneyList(AddMoneyList addMoneyList) throws SQLException;
    public void deleteMoneyList(int id) throws SQLException;
    public boolean deleteManyList(Long[] ibs) throws SQLException;
}
