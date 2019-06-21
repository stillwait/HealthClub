package com.club.Test;

import com.club.Dao.MemCardDao;
import com.club.Dao.MemberDao;
import com.club.DaoImp.MemCardDaoImp;
import com.club.DaoImp.MemberDaoImp;
import com.club.Po.MemCard;
import com.club.Po.MemProRecord;
import com.club.Po.Member;
import com.club.Po.MemberCardPro;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019-04-18.
 */
public class MemberTest {
    @Test
    public void selectAllMember() throws IOException, SQLException {
        System.out.println("测试成功");
        MemberDao memberDao = new MemberDaoImp();
        List<Member> memberList = memberDao.selectAllMember();
        System.out.println(memberList);
    }
    @Test
    public void insertMember() throws IOException, SQLException{
        Member member = new Member();
        member.setMemName("111");
        member.setMemSex("男");
        member.setMemAge(21);
        String date = "2019-04-25";
        Date memDate = null;
        try {
             memDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        member.setMemDate(memDate);
        member.setMemPhone("15886322225");
        MemberDao memberDao = new MemberDaoImp();
        System.out.println(member);
        memberDao.insertMember(member);
    }
    @Test
    public void deleteMember() throws IOException,SQLException{
        MemberDao memberDao = new MemberDaoImp();
        memberDao.deleteMember(1024);
    }
    @Test
    public void selectTheMemberInfo() throws IOException,SQLException{
        MemberDao memberDao = new MemberDaoImp();
        List<MemberCardPro> list = memberDao.selectTheMemberInfo(100001);
        System.out.println(list);
    }
    @Test
    public void insertMemCard()throws IOException,SQLException{
        MemCardDao memCardDao = new MemCardDaoImp();
        MemCard memCard = new MemCard(1021,1005);
        memCardDao.insertMemCard(memCard);
    }

    @Test
    public void selectMemberProInfo() throws IOException,SQLException{
        MemberDao memberDao = new MemberDaoImp();
        List<MemProRecord> list = memberDao.selectMemberProInfo(1001);
        System.out.println(list);
    }
}
