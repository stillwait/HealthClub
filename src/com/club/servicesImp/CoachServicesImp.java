package com.club.servicesImp;

import com.club.Dao.CoachDao;
import com.club.Dao.CoachSalaryDao;
import com.club.Dao.SalaryListDao;
import com.club.DaoImp.CoachDaoImp;
import com.club.DaoImp.CoachSalaryDaoImp;
import com.club.DaoImp.SalaryListDaoImp;
import com.club.Po.Coach;
import com.club.Po.CoachSalary;
import com.club.Po.SalaryList;
import com.club.services.CoachServices;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-02.
 */
public class CoachServicesImp implements CoachServices {
    @Override
    public List<Coach> selectAllCoach() throws SQLException {
        CoachDao coachDao = new CoachDaoImp();
        List<Coach> list = coachDao.selectAllCoach();
        return list;
    }

    @Override
    public Coach selectCoachById(int coachId) throws SQLException {
        CoachDao coachDao = new CoachDaoImp();
        Coach coach = coachDao.selectCoachById(coachId);
        return coach;
    }

    @Override
    public void updateCoach(Coach coach) throws SQLException {
        CoachDao coachDao = new CoachDaoImp();
        coachDao.updateCoach(coach);
    }

    @Override
    public void deleteCoach(int coachId) throws SQLException {
        CoachDao coachDao = new CoachDaoImp();
        coachDao.deleteCoach(coachId);
    }

    @Override
    public String insertCoach(Coach coach) throws SQLException {
        CoachDao coachDao = new CoachDaoImp();
        String s = coachDao.insertCoach(coach);
        return s;
    }

    @Override
    public List<CoachSalary> selectAllCoachSalary() throws SQLException {
        CoachSalaryDao coachSalaryDao = new CoachSalaryDaoImp();
        List<CoachSalary> list = coachSalaryDao.selectAllCoachSalary();
        return list;
    }

    @Override
    public CoachSalary selectCoachSalaryById(int id) throws SQLException {
        CoachSalaryDao coachSalaryDao = new CoachSalaryDaoImp();
        CoachSalary coachSalary = coachSalaryDao.selectCoachSalaryById(id);
        return coachSalary;
    }

    @Override
    public String insertCoachSalary(CoachSalary coachSalary) throws SQLException {
        CoachSalaryDao coachSalaryDao = new CoachSalaryDaoImp();
        SalaryListDao salaryListDao = new SalaryListDaoImp();
        SalaryList salaryList = new SalaryList(coachSalary.getCoachId(),coachSalary.getCoachName(),coachSalary.getUserRole(),coachSalary.getYear(),coachSalary.getMonth(),coachSalary.getBaseSalary(),coachSalary.getCqts(),coachSalary.getQqts(),coachSalary.getOverTime(),coachSalary.getOverSalary(),coachSalary.getJiangJin(),coachSalary.getYfSalary());
        CoachSalary coachSalary1 = coachSalaryDao.selectCoachSalaryByTime(coachSalary.getCoachId(),coachSalary.getYear(),coachSalary.getMonth());
        if (coachSalary1 == null){
            coachSalaryDao.insertCoachSalary(coachSalary);
            salaryListDao.insertSalaryList(salaryList);
            return "添加成功";
        }else{
            return "*该信息已存在";
        }
    }

    @Override
    public void editCoachSalary(CoachSalary coachSalary) throws SQLException {
        CoachSalaryDao coachSalaryDao = new CoachSalaryDaoImp();
        coachSalaryDao.editCoachSalary(coachSalary);
    }

    @Override
    public void deleteCoachSalary(int id) throws SQLException {
        CoachSalaryDao coachSalaryDao = new CoachSalaryDaoImp();
        coachSalaryDao.deleteCoachSalary(id);
    }

    @Override
    public boolean deleteManyCoachSalary(Long[] ibs) throws SQLException {
        CoachSalaryDao coachSalaryDao = new CoachSalaryDaoImp();
        for (int i = 0;i < ibs.length; i++){
            coachSalaryDao.deleteCoachSalary(ibs[i].intValue());
        }
        return true;
    }
}
