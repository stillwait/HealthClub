package com.club.Controller;

import com.club.Po.Coach;
import com.club.Po.CoachSalary;
import com.club.services.CoachServices;
import com.club.servicesImp.CoachServicesImp;
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
 * Created by Administrator on 2019-05-02.
 */
@Controller
@RequestMapping("coach")
public class CoachController {

    @RequestMapping("toAddCoach.do")
    public String toAddCoach(HttpServletRequest request){
        return "addCoach";
    }

    @RequestMapping("addCoach.do")
    public String addCoach(Coach coach, HttpServletRequest request){
        CoachServices coachServices = new CoachServicesImp();
        try {
            String msg = coachServices.insertCoach(coach);
            List<Coach> list = coachServices.selectAllCoach();
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setCoachPic("https://www.programan.cn" + list.get(i).getCoachPic());
            }
            request.setAttribute("coachList",list);
            request.setAttribute("msg",msg);
            return "coachInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("toEditCoach.do")
    public String toEditCoach(HttpServletRequest request){
        int coachId = Integer.parseInt(request.getParameter("id"));
        CoachServices coachServices = new CoachServicesImp();
        try {
            Coach coach = coachServices.selectCoachById(coachId);
            coach.setCoachPic("https://www.programan.cn" + coach.getCoachPic());
            request.setAttribute("coach",coach);
            return "editCoach";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("toEditCoach2.do")
    public String toEditCoach2(HttpServletRequest request){
        int coachId = Integer.parseInt(request.getParameter("id"));
        CoachServices coachServices = new CoachServicesImp();
        try {
            Coach coach = coachServices.selectCoachById(coachId);
            coach.setCoachPic("https://www.programan.cn" + coach.getCoachPic());
            request.setAttribute("coach",coach);
            return "editCoach2";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("editCoach.do")
    public String editCoach(Coach coach, HttpServletRequest request){
        CoachServices coachServices = new CoachServicesImp();
        try {
            coachServices.updateCoach(coach);
            List<Coach> list = coachServices.selectAllCoach();
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setCoachPic("https://www.programan.cn" + list.get(i).getCoachPic());
            }
            request.setAttribute("coachList",list);
            return "coachInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("deleteCoach.do")
    public String deleteCoach(HttpServletRequest request){
        int coachId = Integer.parseInt(request.getParameter("id"));
        CoachServices coachServices = new CoachServicesImp();
        try {
            coachServices.deleteCoach(coachId);
            List<Coach> list = coachServices.selectAllCoach();
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setCoachPic("https://www.programan.cn" + list.get(i).getCoachPic());
            }
            request.setAttribute("coachList",list);
            return "coachInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @ResponseBody
    @RequestMapping(value="selectNameById.do",method= RequestMethod.POST)
    public Coach selectNameById(int coachId){
        CoachServices coachServices = new CoachServicesImp();
        try {
            Coach coach = coachServices.selectCoachById(coachId);
            return coach;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


//    ------------------------------------------------------------------------------------------

    @ResponseBody
    @RequestMapping(value="selectAllCoachSalary.do",method= RequestMethod.POST)
    public Map<String, Object> selectAllUserSalary(){
        CoachServices coachServices = new CoachServicesImp();
        List<CoachSalary> list = null;
        try {
            list = coachServices.selectAllCoachSalary();
            Map<String, Object> map2Json = new HashMap<String, Object>();
            map2Json.put("data", list);
            return map2Json;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("toAddCoachSalary.do")
    public String toAddCoachSalary(){
        return "addCoachSalary";
    }
    @RequestMapping("addCoachSalary.do")
    public String addUserSalary(CoachSalary coachSalary, HttpServletRequest request){
        CoachServices coachServices = new CoachServicesImp();
        try {
            String msg = coachServices.insertCoachSalary(coachSalary);
            if (msg.equals("添加成功")){
                return "coachSalaryInfo";
            }else{
                request.setAttribute("msg",msg);
                return "addCoachSalary";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("toEditCoachSalary.do")
    public String toEditUserSalary(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        CoachServices coachServices = new CoachServicesImp();
        try {
            CoachSalary coachSalary = coachServices.selectCoachSalaryById(id);
            request.setAttribute("coachSalary",coachSalary);
            return "editCoachSalary";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("editUserSalary.do")
    public String editUserSalary(CoachSalary coachSalary){
        CoachServices coachServices = new CoachServicesImp();
        try {
            coachServices.editCoachSalary(coachSalary);
            return "coachSalaryInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("deleteCoachSalary.do")
    public String deleteUserSalary(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        CoachServices coachServices = new CoachServicesImp();
        try {
            coachServices.deleteCoachSalary(id);
            return "coachSalaryInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("deleteManyCoachSalary.do")
    public boolean deleteManyCoachSalary(Long[] ids){
        CoachServices coachServices = new CoachServicesImp();
        boolean flag = false;
        try {
            flag = coachServices.deleteManyCoachSalary(ids);
            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
            return flag;
        }
    }
}
