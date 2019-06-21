package com.club.Controller;

import com.club.Po.AddMoneyList;
import com.club.services.AddMoneyListServices;
import com.club.services.UserServices;
import com.club.servicesImp.AddMoneyListServicesImp;
import com.club.servicesImp.UserServicesImp;
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
@RequestMapping("addMoneyList")
public class AddMoneyListController {

    @ResponseBody
    @RequestMapping(value="selectAllList.do",method= RequestMethod.POST)
    public Map<String, Object> selectAllUser(){
        AddMoneyListServices addMoneyListServices = new AddMoneyListServicesImp();
        List<AddMoneyList> list = null;
        try {
            list = addMoneyListServices.selectAllList();
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
        AddMoneyListServices addMoneyListServices = new AddMoneyListServicesImp();
        try {
            addMoneyListServices.deleteMoneyList(id);
            return "addMoneyListInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("deleteManyList.do")
    public boolean deleteManyList(Long[] ids){
        AddMoneyListServices addMoneyListServices = new AddMoneyListServicesImp();
        boolean flag = false;
        try {
            flag = addMoneyListServices.deleteManyList(ids);
            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
            return flag;
        }
    }
}
