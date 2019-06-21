package com.club.servicesImp;

import com.club.Dao.SalaryListDao;
import com.club.DaoImp.SalaryListDaoImp;
import com.club.Po.SalaryList;
import com.club.services.SalaryListServices;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-04.
 */
public class SalaryListServicesImp implements SalaryListServices {
    @Override
    public void insertSalaryList(SalaryList salaryList) throws SQLException {
        SalaryListDao salaryListDao = new SalaryListDaoImp();
        salaryListDao.insertSalaryList(salaryList);

    }

    @Override
    public List<SalaryList> selectAllSalaryList() throws SQLException {
        SalaryListDao salaryListDao = new SalaryListDaoImp();
        List<SalaryList> lists = salaryListDao.selectAllSalaryList();
        return lists;
    }

    @Override
    public void deleteSalaryList(int id) throws SQLException {
        SalaryListDao salaryListDao = new SalaryListDaoImp();
        salaryListDao.deleteSalaryList(id);
    }

    @Override
    public boolean deleteManyList(Long[] ibs) throws SQLException {
        SalaryListDao salaryListDao = new SalaryListDaoImp();
        for (int i = 0;i < ibs.length; i++){
            salaryListDao.deleteSalaryList(ibs[i].intValue());
        }
        return true;
    }
}
