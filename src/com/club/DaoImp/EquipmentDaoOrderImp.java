package com.club.DaoImp;

import com.club.Dao.EquipmentOrderDao;
import com.club.Po.EquipmentOrder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-04.
 */
public class EquipmentDaoOrderImp implements EquipmentOrderDao {
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
    public List<EquipmentOrder> selectAllEquOrder() throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<EquipmentOrder> list = sqlSession.selectList("equipmentOrder.selectEquipmentOrder");
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public EquipmentOrder selectEquOrder(int orderId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EquipmentOrder equipmentOrder = sqlSession.selectOne("equipmentOrder.selectEquipmentOrderById",orderId);
        sqlSession.commit();
        sqlSession.close();
        return equipmentOrder;
    }

    @Override
    public void insertEquOrder(EquipmentOrder equipmentOrder) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("equipmentOrder.insertEquipmentOrder",equipmentOrder);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateEquOrder(EquipmentOrder equipmentOrder) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("equipmentOrder.updateEquipmentOrder",equipmentOrder);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteEquOrder(int orderId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("equipmentOrder.deleteEquipmentOrder",orderId);
        sqlSession.commit();
        sqlSession.close();
    }
}
