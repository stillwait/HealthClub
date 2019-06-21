package com.club.DaoImp;

import com.club.Dao.EquipmentDao;
import com.club.Po.Equipment;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-02.
 */
public class EquipmentDaoImp implements EquipmentDao {
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
    public List<Equipment> selectAllEquipment() throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Equipment> list = sqlSession.selectList("equipment.selectAllEquipment");
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public String insertEquipment(Equipment equipment) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Equipment equipment1 = sqlSession.selectOne("equipment.selectEquipmentByName",equipment.getEquName());
        if (equipment1 == null){
            sqlSession.insert("equipment.insertEquipment",equipment);
            sqlSession.commit();
            sqlSession.close();
            return "*添加成功";
        }else{
            return "*该设备已存在";
        }
    }

    @Override
    public void deleteEquipment(int equId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("equipment.deleteEquipment",equId);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateEquipment(Equipment equipment) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("equipment.updateEquipment",equipment);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Equipment selectEquipmentByName(String equName) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Equipment equipment = sqlSession.selectOne("equipment.selectEquipmentByName",equName);
        sqlSession.commit();
        sqlSession.close();
        return equipment;
    }

    @Override
    public Equipment selectEquipmentById(int equId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Equipment equipment = sqlSession.selectOne("equipment.selectEquipmentById",equId);
        sqlSession.commit();
        sqlSession.close();
        return equipment;
    }
}
