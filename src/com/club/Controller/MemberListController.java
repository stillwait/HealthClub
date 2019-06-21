package com.club.Controller;

import com.club.Po.MemberList;
import com.club.services.MemberListServices;
import com.club.servicesImp.MemberListServicesImp;
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
@RequestMapping("memberList")
public class MemberListController {

    @ResponseBody
    @RequestMapping(value="selectAllList.do",method= RequestMethod.POST)
    public Map<String, Object> selectAllUser(){
        MemberListServices memberListServices = new MemberListServicesImp();
        List<MemberList> list = null;
        try {
            list = memberListServices.selectAllList();
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
        MemberListServices memberListServices = new MemberListServicesImp();
        try {
            memberListServices.deleteMemberList(id);
            return "memberListInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("deleteManyList.do")
    public boolean deleteManyList(Long[] ids){
        MemberListServices memberListServices = new MemberListServicesImp();
        boolean flag = false;
        try {
            flag = memberListServices.deleteManyList(ids);
            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
            return flag;
        }
    }
}
