package com.club.Test;

import com.club.Dao.PriceDao;
import com.club.Dao.ProjectDao;
import com.club.DaoImp.PriceDaoImp;
import com.club.DaoImp.ProjectDaoImp;
import com.club.Po.Price;
import com.club.Po.Project;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-04-24.
 */
public class ProjectTest {
    @Test
    public void selectAllProject(){
        ProjectDao projectDao = new ProjectDaoImp();
        try {
            List<Project> list = projectDao.selectAllProject();
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void selectPriceById(){
        PriceDao priceDao = new PriceDaoImp();
        try {
            Price price = priceDao.selectPriceById(1001);
            System.out.println(price.getPriceName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectProCoach(){
        ProjectDao projectDao = new ProjectDaoImp();
        try {
            List<String> list = projectDao.selectProCoach(1003);
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
