package com.club.servicesImp;

import com.club.Dao.AdminDao;
import com.club.Dao.MemberDao;
import com.club.Dao.UserDao;
import com.club.DaoImp.AdminDaoImp;
import com.club.DaoImp.MemberDaoImp;
import com.club.DaoImp.UserDaoImp;
import com.club.Po.Admin;
import com.club.Po.Member;
import com.club.Po.User;
import com.club.services.LoginServices;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-03-25.
 */
public class LoginServicesImp implements LoginServices {
    @Override
    public String loginCheck(String userPhone,String password,String userJob) throws SQLException {
        AdminDao adminDao = new AdminDaoImp();
        MemberDao memberDao = new MemberDaoImp();
        String message = null;
        Admin admin;
        Member member;
        if (userJob.equals("管理员")){
            if (userPhone.length() == 6){
                int adminId = Integer.parseInt(userPhone);
                admin = adminDao.selectAdminById(adminId);
            }else{
                admin = adminDao.selectAdminByPhone(userPhone);
            }
            if (admin != null){
                if (admin.getAdminPwd().equals(password)){
                    message = "管理员";
                }else{
                    message = "*密码错误";
                }
            }else{
                message = "*用户不存在或角色错误";
            }
        }else{
            if (userPhone.length() == 6){
                int memId = Integer.parseInt(userPhone);
                member = memberDao.selectMemberById(memId);
            }else{
                member = memberDao.selectMemberByPhone(userPhone);
            }
            if (member != null){
                if (member.getMemPwd().equals(password)){
                    message = "会员";
                }else{
                    message = "*密码错误";
                }
            }else{
                message = "*用户不存在或角色错误";
            }
        }
        return message;
    }

    @Override
    public Admin selectAdminById(int adminId) throws SQLException {
        AdminDao adminDao = new AdminDaoImp();
        Admin admin = adminDao.selectAdminById(adminId);
        return admin;
    }

    @Override
    public Admin selectAdminByPhone(String adminPhone) throws SQLException {
        AdminDao adminDao = new AdminDaoImp();
        Admin admin = adminDao.selectAdminByPhone(adminPhone);
        return admin;
    }

    @Override
    public Member selectMemberById(int memId) throws SQLException {
        MemberDao memberDao = new MemberDaoImp();
        Member member = memberDao.selectMemberById(memId);
        return member;
    }

    @Override
    public Member selectMemberByPhone(String memPhone) throws SQLException {
        MemberDao memberDao = new MemberDaoImp();
        Member member = memberDao.selectMemberByPhone(memPhone);
        return member;
    }


}
