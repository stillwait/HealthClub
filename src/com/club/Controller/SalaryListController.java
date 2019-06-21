package com.club.Controller;

import com.club.Po.SalaryList;
import com.club.services.AddMoneyListServices;
import com.club.services.SalaryListServices;
import com.club.servicesImp.AddMoneyListServicesImp;
import com.club.servicesImp.SalaryListServicesImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019-05-05.
 */
@Controller
@RequestMapping("salaryList")
public class SalaryListController {
    @ResponseBody
    @RequestMapping(value="selectAllList.do",method= RequestMethod.POST)
    public Map<String, Object> selectAllUser(){
        SalaryListServices salaryListServices = new SalaryListServicesImp();
        List<SalaryList> list = null;
        try {
            list = salaryListServices.selectAllSalaryList();
            Map<String, Object> map2Json = new HashMap<String, Object>();
            map2Json.put("data", list);
            return map2Json;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("deleteList.do")
    public String deleteList(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        SalaryListServices salaryListServices = new SalaryListServicesImp();
        try {
            salaryListServices.deleteSalaryList(id);
            return "salaryListInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("deleteManyList.do")
    public boolean deleteManyList(Long[] ids){
        SalaryListServices salaryListServices = new SalaryListServicesImp();
        boolean flag = false;
        try {
            flag = salaryListServices.deleteManyList(ids);
            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
            return flag;
        }
    }
}
