package com.club.servicesImp;

import com.club.Dao.AddMoneyListDao;
import com.club.DaoImp.AddMoneyListDaoImp;
import com.club.Po.AddMoneyList;
import com.club.services.AddMoneyListServices;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-04.
 */
public class AddMoneyListServicesImp implements AddMoneyListServices {

    @Override
    public List<AddMoneyList> selectAllList() throws SQLException {
        AddMoneyListDao addMoneyListDao = new AddMoneyListDaoImp();
        List<AddMoneyList> lists = addMoneyListDao.selectAllList();
        return lists;
    }

    @Override
    public void insertMoneyList(AddMoneyList addMoneyList) throws SQLException {
        AddMoneyListDao addMoneyListDao = new AddMoneyListDaoImp();
        addMoneyListDao.insertMoneyList(addMoneyList);
    }

    @Override
    public void deleteMoneyList(int id) throws SQLException {
        AddMoneyListDao addMoneyListDao = new AddMoneyListDaoImp();
        addMoneyListDao.deleteMoneyList(id);
    }

    @Override
    public boolean deleteManyList(Long[] ibs) throws SQLException {
        AddMoneyListDao addMoneyListDao = new AddMoneyListDaoImp();
        for (int i = 0;i < ibs.length; i++){
            addMoneyListDao.deleteMoneyList(ibs[i].intValue());
        }
        return true;
    }
}
