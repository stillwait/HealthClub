package com.club.servicesImp;

import com.club.Dao.MemberListDao;
import com.club.DaoImp.MemberListDaoImp;
import com.club.Po.MemberList;
import com.club.services.MemberListServices;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-04.
 */
public class MemberListServicesImp implements MemberListServices {
    @Override
    public List<MemberList> selectAllList() throws SQLException {
        MemberListDao memberListDao = new MemberListDaoImp();
        List<MemberList> lists = memberListDao.selectAllList();
        return lists;
    }

    @Override
    public void insertMemberList(MemberList memberList) throws SQLException {
        MemberListDao memberListDao = new MemberListDaoImp();
        memberListDao.insertMemberList(memberList);
    }

    @Override
    public void deleteMemberList(int id) throws SQLException {
        MemberListDao memberListDao = new MemberListDaoImp();
        memberListDao.deleteMemberList(id);
    }

    @Override
    public boolean deleteManyList(Long[] ibs) throws SQLException {
        MemberListDao memberListDao = new MemberListDaoImp();
        for (int i = 0;i < ibs.length; i++){
            memberListDao.deleteMemberList(ibs[i].intValue());
        }
        return true;
    }
}
