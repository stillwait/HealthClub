package com.club.services;

import com.club.Po.Admin;
import com.club.Po.Member;
import com.club.Po.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-03-25.
 */
public interface LoginServices {
    public String loginCheck(String userName,String password,String userJob) throws SQLException;

    public Admin selectAdminById(int adminId) throws SQLException;

    public Admin selectAdminByPhone(String adminPhone) throws SQLException;

    public Member selectMemberById(int memId) throws SQLException;

    public Member selectMemberByPhone(String memPhone) throws SQLException;

}
