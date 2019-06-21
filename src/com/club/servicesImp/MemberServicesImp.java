package com.club.servicesImp;

import com.club.Dao.MemCardDao;
import com.club.Dao.MemberDao;
import com.club.DaoImp.MemCardDaoImp;
import com.club.DaoImp.MemberDaoImp;
import com.club.Po.*;
import com.club.services.MemberServices;

import javax.servlet.jsp.jstl.sql.Result;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-04-18.
 */
public class MemberServicesImp implements MemberServices {
    @Override
    public List<Member> selectAllMember() throws SQLException {
        MemberDao memberDao = new MemberDaoImp();
        List<Member> list = memberDao.selectAllMember();
        return list;
    }

    @Override
    public String insertMember(Member member) throws SQLException {
        MemberDao memberDao = new MemberDaoImp();
        String s = memberDao.insertMember(member);
        return s;
    }

    @Override
    public void deleteMember(int memId) throws SQLException {
        MemberDao memberDao = new MemberDaoImp();
        memberDao.deleteMember(memId);
    }

    @Override
    public List<MemberCardPro> selectTheMemberInfo(int memId) throws SQLException {
        MemberDao memberDao = new MemberDaoImp();
        List<MemberCardPro> list = memberDao.selectTheMemberInfo(memId);
        return list;
    }

    @Override
    public void updateMember(Member member) throws SQLException {
        MemberDao memberDao = new MemberDaoImp();
        memberDao.updateMember(member);
    }

    @Override
    public void insertMemCard(MemCard memCard) throws SQLException {
        MemCardDao memCardDao = new MemCardDaoImp();
        memCardDao.insertMemCard(memCard);
    }

    @Override
    public boolean deleteManyMember(Long[] ibs) throws SQLException {
        MemberDao memberDao = new MemberDaoImp();
        for (int i = 0;i < ibs.length; i++){
            memberDao.deleteMember(ibs[i].intValue());
        }
        return true;
    }

    @Override
    public Member selectMemberByPhone(String memPhone) throws SQLException {
        MemberDao memberDao = new MemberDaoImp();
        Member member = memberDao.selectMemberByPhone(memPhone);
        return member;
    }

    @Override
    public int selectMemIdByPhone(String memPhone) throws SQLException {
        MemberDao memberDao = new MemberDaoImp();
        int memId = memberDao.selectMemIdByPhone(memPhone);
        return memId;
    }

    @Override
    public Card selectCardById(int cardId) throws SQLException {
        MemberDao memberDao = new MemberDaoImp();
        Card card = memberDao.selectCardById(cardId);
        return card;
    }

    @Override
    public List<MemProRecord> selectMemberProInfo(int memId) throws SQLException {
        MemberDao memberDao = new MemberDaoImp();
        List<MemProRecord> list = memberDao.selectMemberProInfo(memId);
        return list;
    }

    @Override
    public float selectMoneyById(int memId) throws SQLException {
        MemberDao memberDao = new MemberDaoImp();
        float memMoney = memberDao.selectMoneyById(memId);
        return memMoney;
    }

    @Override
    public Member selectMemberById(int memId) throws SQLException {
        MemberDao memberDao = new MemberDaoImp();
        Member member = memberDao.selectMemberById(memId);
        return member;
    }

    @Override
    public void updateMemMoney(Member member) throws SQLException {
        MemberDao memberDao = new MemberDaoImp();
        memberDao.updateMemMoney(member);
    }

    @Override
    public void updateMemberCard(MemCard memCard) throws SQLException {
        MemberDao memberDao = new MemberDaoImp();
        memberDao.updateMemberCard(memCard);
    }

    @Override
    public void insertMemProject(MemProject memProject) throws SQLException {
        MemberDao memberDao = new MemberDaoImp();
        memberDao.insertMemProject(memProject);
    }

    @Override
    public void deleteMemProject(int id) throws SQLException {
        MemberDao memberDao = new MemberDaoImp();
        memberDao.deleteMemProject(id);
    }
}
