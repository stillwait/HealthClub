package com.club.Dao;

import com.club.Po.MemberList;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-04.
 */
public interface MemberListDao {
    public List<MemberList> selectAllList() throws SQLException;
    public void insertMemberList(MemberList memberList) throws SQLException;
    public void deleteMemberList(int id) throws SQLException;
}
