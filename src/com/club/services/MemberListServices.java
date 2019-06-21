package com.club.services;

import com.club.Po.MemberList;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-04.
 */
public interface MemberListServices {

    public List<MemberList> selectAllList() throws SQLException;
    public void insertMemberList(MemberList memberList) throws SQLException;
    public void deleteMemberList(int id) throws SQLException;
    public boolean deleteManyList(Long[] ibs) throws SQLException;
}
