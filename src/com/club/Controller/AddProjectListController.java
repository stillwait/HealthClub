package com.club.Controller;

import com.club.Po.AddProjectList;
import com.club.services.AddProjectListServices;
import com.club.servicesImp.AddProjectListServicesImp;
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
@RequestMapping("addProjectList")
public class AddProjectListController {

    @ResponseBody
    @RequestMapping(value="selectAllList.do",method= RequestMethod.POST)
    public Map<String, Object> selectAllList(){
        AddProjectListServices addProjectListServices = new AddProjectListServicesImp();
        List<AddProjectList> list = null;
        try {
            list = addProjectListServices.selectAllList();
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
        AddProjectListServices addProjectListServices = new AddProjectListServicesImp();
        try {
            addProjectListServices.deleteProjectList(id);
            return "addProjectListInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("deleteManyList.do")
    public boolean deleteManyList(Long[] ids){
        AddProjectListServices addProjectListServices = new AddProjectListServicesImp();
        boolean flag = false;
        try {
            flag = addProjectListServices.deleteManyList(ids);
            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
            return flag;
        }
    }
}
