package com.club.DaoImp;

import com.club.Dao.MemberDao;
import com.club.Po.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-04-18.
 */
public class MemberDaoImp implements MemberDao {
    private static SqlSessionFactory sqlSessionFactory; //生成sql会话工厂类对象
    static{
        String resource = "SqlMapConfig.xml";      //加载mybatis配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);    //返回io流
            //生成sql会话工厂类对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Member> selectAllMember() throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Member> list =  sqlSession.selectList("member.selectAllMember");
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public String insertMember(Member member) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Member> list = sqlSession.selectList("member.selectMemberByPhone",member.getMemPhone());
        if(list.size() == 0){
            sqlSession.insert("member.insertMember",member);
            sqlSession.commit();
            sqlSession.close();
            return "添加成功";
        }else{
            return "该会员已存在";
        }
    }

    @Override
    public void deleteMember(int memId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("member.deleteMember",memId);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<MemberCardPro> selectTheMemberInfo(int memId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<MemberCardPro> list = sqlSession.selectList("member.selectTheMemberInfo",memId);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public void updateMember(Member member) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("member.updateMember",member);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateMemberInfo(Member member) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("member.updateMemberInfo",member);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateMemberCard(MemCard memCard) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("member.updateMemberCard",memCard);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Member selectMemberByPhone(String memPhone) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Member member = sqlSession.selectOne("member.selectMemberByPhone",memPhone);
        sqlSession.commit();
        sqlSession.close();
        return member;
    }

    @Override
    public int selectMemIdByPhone(String memPhone) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int memId = sqlSession.selectOne("member.selectMemIdByPhone",memPhone);
        sqlSession.commit();
        sqlSession.close();
        return memId;
    }

    @Override
    public Card selectCardById(int cardId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Card card = sqlSession.selectOne("card.selectCardById",cardId);
        sqlSession.commit();
        sqlSession.close();
        return card;
    }

    @Override
    public List<MemProRecord> selectMemberProInfo(int memId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<MemProRecord> list = sqlSession.selectList("member.selectMemberProInfo",memId);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public float selectMoneyById(int memId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        float memMoney = sqlSession.selectOne("member.selectMoneyById",memId);
        sqlSession.commit();
        sqlSession.close();
        return memMoney;
    }

    @Override
    public void updateMemMoney(Member member) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("member.updateMemMoney",member);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void insertMemProject(MemProject memProject) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("member.insertMemProject",memProject);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteMemProject(int id) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("member.deleteMemProject",id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Member selectMemberById(int memId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Member member = sqlSession.selectOne("member.selectMemberById",memId);
        sqlSession.commit();
        sqlSession.close();
        return member;
    }


}
