package com.club.Dao;

import com.club.Po.*;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-04-18.
 */
public interface MemberDao {
    public List<Member> selectAllMember()throws SQLException;
    public String insertMember(Member member) throws SQLException;
    public void deleteMember(int memId) throws SQLException;
    public List<MemberCardPro> selectTheMemberInfo(int memId) throws SQLException;
    public void updateMember(Member member) throws SQLException;
    public void updateMemberInfo(Member member) throws SQLException;
    public void updateMemberCard(MemCard memCard) throws SQLException;
    public Member selectMemberByPhone(String memPhone) throws SQLException;
    public int selectMemIdByPhone(String memPhone) throws SQLException;
    public Card selectCardById(int cardId) throws SQLException;
    public List<MemProRecord> selectMemberProInfo(int memId) throws SQLException;
    public float selectMoneyById(int memId) throws SQLException;
    public void updateMemMoney(Member member) throws SQLException;
    public void insertMemProject(MemProject memProject) throws SQLException;
    public void deleteMemProject(int id) throws SQLException;
    public Member selectMemberById(int memId) throws SQLException;
}
