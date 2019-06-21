package com.club.Dao;

import com.club.Po.Admin;

import java.sql.SQLException;

/**
 * Created by Administrator on 2019-05-15.
 */
public interface AdminDao {
    public Admin selectAdminById(int adminId) throws SQLException;
    public void updateAdmin(Admin admin) throws SQLException;
    public Admin selectAdminByPhone(String adminPhone) throws SQLException;

}
