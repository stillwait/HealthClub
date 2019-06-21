package com.club.servicesImp;

import com.club.Dao.AddProjectListDao;
import com.club.DaoImp.AddProjectListDaoImp;
import com.club.Po.AddMoneyList;
import com.club.Po.AddProjectList;
import com.club.services.AddMoneyListServices;
import com.club.services.AddProjectListServices;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-05.
 */
public class AddProjectListServicesImp implements AddProjectListServices {
    @Override
    public List<AddProjectList> selectAllList() throws SQLException {
        AddProjectListDao addProjectListDao = new AddProjectListDaoImp();
        List<AddProjectList> lists = addProjectListDao.selectAllList();
        return lists;
    }

    @Override
    public void insertProjectList(AddProjectList addProjectList) throws SQLException {
        AddProjectListDao addProjectListDao = new AddProjectListDaoImp();
        addProjectListDao.insertProjectList(addProjectList);
    }

    @Override
    public void deleteProjectList(int id) throws SQLException {
        AddProjectListDao addProjectListDao = new AddProjectListDaoImp();
        addProjectListDao.deleteProjectList(id);
    }

    @Override
    public boolean deleteManyList(Long[] ibs) throws SQLException {
        AddProjectListDao addProjectListDao = new AddProjectListDaoImp();
        for (int i = 0;i < ibs.length; i++){
            addProjectListDao.deleteProjectList(ibs[i].intValue());
        }
        return true;
    }
}
