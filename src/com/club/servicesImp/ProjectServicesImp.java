package com.club.servicesImp;

import com.club.Dao.ProjectDao;
import com.club.DaoImp.ProjectDaoImp;
import com.club.Po.ProPrice;
import com.club.Po.Project;
import com.club.Po.ProjectPrice;
import com.club.services.ProjectServices;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-04-24.
 */
public class ProjectServicesImp implements ProjectServices {
    @Override
    public List<Project> selectAllProject() throws SQLException {
        ProjectDao projectDao = new ProjectDaoImp();
        List<Project> list = projectDao.selectAllProject();
        return list;
    }

    @Override
    public List<ProjectPrice> selectProPriceInfo(int proId) throws SQLException {
        ProjectDao projectDao = new ProjectDaoImp();
        List<ProjectPrice> list = projectDao.selectProPriceInfo(proId);
        return list;
    }

    @Override
    public void deleteProject(int proId) throws SQLException {
        ProjectDao projectDao = new ProjectDaoImp();
        projectDao.deleteProject(proId);
    }

    @Override
    public boolean deleteManyProject(Long[] ids) throws SQLException {
        ProjectDao projectDao = new ProjectDaoImp();
        for (int i = 0;i < ids.length; i++){
            projectDao.deleteProject(ids[i].intValue());
        }
        return true;
    }

    @Override
    public void insertProject(Project project) throws SQLException {
        ProjectDao projectDao = new ProjectDaoImp();
        projectDao.insertProject(project);
    }

    @Override
    public void insertProjectPrice(ProPrice proPrice) throws SQLException {
        ProjectDao projectDao = new ProjectDaoImp();
        projectDao.insertProjectPrice(proPrice);
    }

    @Override
    public Project selectProjectByName(String proName) throws SQLException {
        ProjectDao projectDao = new ProjectDaoImp();
        Project project = projectDao.selectProjectByName(proName);
        return project;
    }

    @Override
    public Project selectProjectById(int proId) throws SQLException {
        ProjectDao projectDao = new ProjectDaoImp();
        Project project = projectDao.selectProjectById(proId);
        return project;
    }

    @Override
    public void updateProject(Project project) throws SQLException {
        ProjectDao projectDao = new ProjectDaoImp();
        projectDao.updateProject(project);
    }

    @Override
    public void updateProjectPrice(ProPrice proPrice) throws SQLException {
        ProjectDao projectDao = new ProjectDaoImp();
        projectDao.updateProjectPrice(proPrice);
    }

    @Override
    public void deletePriceByName(int proId, String priceName) throws SQLException {
        ProjectDao projectDao = new ProjectDaoImp();
        projectDao.deletePriceByName(proId,priceName);
    }

    @Override
    public List<String> selectProCoach(int proId) throws SQLException {
        ProjectDao projectDao = new ProjectDaoImp();
        List<String> list = projectDao.selectProCoach(proId);
        return list;
    }
}
