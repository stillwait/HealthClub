package com.club.DaoImp;

import com.club.Dao.PriceDao;
import com.club.Dao.ProjectDao;
import com.club.Po.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019-04-24.
 */
public class ProjectDaoImp implements ProjectDao {
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
    public List<Project> selectAllProject() throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Project> list = sqlSession.selectList("project.selectAllProject");
        sqlSession.commit();
        sqlSession.close();
        return list;
    }



    @Override
    public List<ProjectPrice> selectProPriceInfo(int proId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<ProjectPrice> list = sqlSession.selectList("project.selectProPriceInfo",proId);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public void deleteProject(int proId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("project.deleteProject",proId);
        sqlSession.commit();
        sqlSession.close();
    }


    @Override
    public void insertProject(Project project) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("project.insertProject",project);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void insertProjectPrice(ProPrice proPrice) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("project.insertProjectPrice",proPrice);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Project selectProjectByName(String proName) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Project project = sqlSession.selectOne("project.selectProjectByName",proName);
        sqlSession.commit();
        sqlSession.close();
        return project;
    }

    @Override
    public Project selectProjectById(int proId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Project project = sqlSession.selectOne("project.selectProjectById",proId);
        sqlSession.commit();
        sqlSession.close();
        return project;
    }

    @Override
    public void updateProject(Project project) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("project.updateProject",project);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateProjectPrice(ProPrice proPrice) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map<String, Object> param=new HashMap<String, Object>();
        param.put("proId", proPrice.getProId());
        param.put("priceId", proPrice.getPriceId());
        ProjectDao projectDao = new ProjectDaoImp();
        PriceDao priceDao = new PriceDaoImp();
        List<ProjectPrice> list = projectDao.selectProPriceInfo(proPrice.getProId());//查询该项目所有价格
        if (list == null){
            //若是该项目没有定价格，则插入
            sqlSession.insert("project.insertProjectPrice",proPrice);
        }else{
            //若是该项目有价格
            //判断表中是否有此数据
            ProPrice proPrice1 = sqlSession.selectOne("project.selectProPriceByTwoId",param);
            if (proPrice1 == null){
                //若是关联表没有
                Price price = priceDao.selectPriceById(proPrice.getPriceId());//通过前台选择的价格查询对应的priceName
//                System.out.println(price.getPriceName() + "/" + list.get(0).getPrice().get(0).getPriceName());
//                System.out.println(list.get(0).getPrice().size());
                //遍历项目所有价格，如果priceName对应的话，则删掉再插入
                for (int i = 0; i < list.get(0).getPrice().size(); i++) {
//                    System.out.println("进入循环");
                    if (price.getPriceName().equals(list.get(0).getPrice().get(i).getPriceName())){
                        Map<String, Object> param1=new HashMap<String, Object>();
                        param1.put("proId", proPrice.getProId());
                        param1.put("priceId", list.get(0).getPrice().get(i).getPriceId());
//                        System.out.println("删除");
                        sqlSession.delete("project.deletePriceById",param1);
                    }
                }
//                System.out.println("插入");
                sqlSession.insert("project.insertProjectPrice",proPrice);
            }

        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<String> selectProCoach(int proId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<String> list = sqlSession.selectList("project.selectProCoach",proId);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public List<Price> selectAllPriceById(int proId) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Price> list = sqlSession.selectList("project.selectAllPriceById",proId);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public void deletePriceByName(int proId, String priceName) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProjectDao projectDao = new ProjectDaoImp();
        List<ProjectPrice> list = projectDao.selectProPriceInfo(proId);//查询该项目所有价格
        for (int i = 0; i < list.get(0).getPrice().size(); i++) {
            if (list.get(0).getPrice().get(i).getPriceName().equals(priceName)){
                Map<String, Object> param1=new HashMap<String, Object>();
                param1.put("proId", proId);
                param1.put("priceId", list.get(0).getPrice().get(i).getPriceId());
                sqlSession.delete("project.deletePriceById",param1);
            }
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
