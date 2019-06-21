package com.club.DaoImp;

import com.club.Dao.PriceDao;
import com.club.Po.Price;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.test.context.jdbc.Sql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019-04-26.
 */
public class PriceDaoImp implements PriceDao  {
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
    public List<Price> selectAllPrice() throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Price> list = sqlSession.selectList("price.selectAllPrice");
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public Price selectPriceById(int priceId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Price price = sqlSession.selectOne("price.selectPriceById",priceId);
        sqlSession.commit();
        sqlSession.close();
        return price;
    }

    @Override
    public void updatePrice(Price price) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("price.updatePrice",price);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deletePrice(int priceId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("price.deletePrice",priceId);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public String insertPrice(Price price) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map<String, Object> param=new HashMap<String, Object>();
        param.put("priceName", price.getPriceName());
        param.put("priceMoney", price.getPriceMoney());
        Price price1 = sqlSession.selectOne("price.selectPriceByName",param);
        if (price1 == null){
            sqlSession.insert("price.insertPrice",price);
            sqlSession.commit();
            sqlSession.close();
            return "*添加成功";
        }else{
            return "*该价格已存在";
        }
    }
}
