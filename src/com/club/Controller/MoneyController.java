package com.club.Controller;

import com.club.Dao.CoachSalaryDao;
import com.club.Dao.UserSalaryDao;
import com.club.DaoImp.CoachSalaryDaoImp;
import com.club.DaoImp.UserSalaryDaoImp;
import com.club.Po.CoachSalary;
import com.club.Po.SalaryEchart;
import com.club.Po.UserSalary;
import com.club.util.SalaryUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019-05-05.
 */
@Controller
@RequestMapping("money")
public class MoneyController {

    @ResponseBody
    @RequestMapping(value = "selectSalary.do", method = RequestMethod.POST)
    public Map<String, Map<String, Float>> selectAllList(String year) {
        UserSalaryDao userSalaryDao = new UserSalaryDaoImp();
        CoachSalaryDao coachSalaryDao = new CoachSalaryDaoImp();
        try {
            List<UserSalary> userSalaryList = userSalaryDao.selectUserSalaryByYear(year);
            List<CoachSalary> coachSalaryList = coachSalaryDao.selectCoachSalaryByYear(year);
            Map<String, Map<String, Float>> result = SalaryUtil.caculateSalary(userSalaryList, coachSalaryList);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
