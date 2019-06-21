package com.club.Controller;

import com.club.Dao.AdminDao;
import com.club.Dao.MemberDao;
import com.club.Dao.UserSalaryDao;
import com.club.DaoImp.AdminDaoImp;
import com.club.DaoImp.MemberDaoImp;
import com.club.DaoImp.UserSalaryDaoImp;
import com.club.Po.*;
import com.club.services.CoachServices;
import com.club.services.UserServices;
import com.club.servicesImp.CoachServicesImp;
import com.club.servicesImp.UserServicesImp;
import com.club.util.JSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019-04-08.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("toUpdateUserInfo.do")
    public String toUpdateUserInfo(){return "updateUserInfo";}

    @RequestMapping("updateUserInfo.do")
    public String updateUserInfo(Admin admin, HttpServletRequest request, HttpServletResponse response){
        AdminDao adminDao = new AdminDaoImp();
        try {
            adminDao.updateAdmin(admin);
            request.getSession().setAttribute("admin",admin);
            request.setAttribute("reload", "true");
            return "updateUserInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("toUpdateMemInfo.do")
    public String toUpdateMemInfo(){
        return "updateMemInfo";
    }

    @RequestMapping("updateMemInfo.do")
    public String updateMemInfo(Member member, HttpServletRequest request){
        MemberDao memberDao = new MemberDaoImp();
        try {
            memberDao.updateMemberInfo(member);
            request.getSession().setAttribute("member",member);
            request.setAttribute("reload", "true");
            return "updateMemInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("toUpdateUserPic.do")
    public String toUpdateUserPic(){
        return "updateUserPic";
    }

    @RequestMapping("toMemberInfo.do")
    public String toMemberInfo(){return "memberInfo";}

    @RequestMapping("toEquipmentInfo.do")
    public String toEquipmentInfo(){return "equipmentInfo";}

    @RequestMapping("toEquipmentInfo2.do")
    public String toEquipmentInfo2(){return "equipmentInfo2";}

    @RequestMapping("toCoachInfo.do")
    public String toCoachInfo(HttpServletRequest request, HttpServletResponse response){
        CoachServices coachServices = new CoachServicesImp();
        try {
            List<Coach> list = coachServices.selectAllCoach();
            System.out.println(list);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setCoachPic("https://www.programan.cn" + list.get(i).getCoachPic());
            }
            System.out.println(list.get(0).getCoachPic());
            request.setAttribute("coachList",list);
            return "coachInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("toCoachInfo2.do")
    public String toCoachInfo2(HttpServletRequest request, HttpServletResponse response){
        CoachServices coachServices = new CoachServicesImp();
        try {
            List<Coach> list = coachServices.selectAllCoach();
            System.out.println(list);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setCoachPic("https://www.programan.cn" + list.get(i).getCoachPic());
            }
            System.out.println(list.get(0).getCoachPic());
            request.setAttribute("coachList",list);
            return "coachInfo2";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("toUserInfo.do")
    public String toUserInfo(){return "userInfo";}

    @RequestMapping("toUserSalaryInfo.do")
    public String toUserSalaryInfo(){return "userSalaryInfo";}

    @RequestMapping("toCoachSalaryInfo.do")
    public String toCoachSalaryInfo(){return "coachSalaryInfo";}

    @RequestMapping("toSalaryListInfo.do")
    public String toSalaryListInfo(){return "salaryListInfo";}

    @RequestMapping("toEquipmentOrderInfo.do")
    public String toEquipmentOrderInfo(){return "equipmentOrderInfo";}

    @RequestMapping("toMemberListInfo.do")
    public String toMemberListInfo(){return "memberListInfo";}

    @RequestMapping("toAddMoneyListInfo.do")
    public String toAddMoneyListInfo(){return "addMoneyListInfo";}

    @RequestMapping("toAddProjectListInfo.do")
    public String toAddProjectListInfo(){return "addProjectListInfo";}

    @RequestMapping("toCardPriceInfo.do")
    public String toCardPriceInfo(){return "cardPriceInfo";}

    @RequestMapping("toProjectPriceInfo.do")
    public String toProjectPriceInfo(){return "projectPriceInfo";}

    @RequestMapping("toMoneyInfo.do")
    public String toMoneyInfo(HttpServletRequest request){
        UserSalaryDao userSalaryDao = new UserSalaryDaoImp();
        try {
            List<String> year = userSalaryDao.selectYear();
//            System.out.println(year);
            request.setAttribute("year",year);
            return "moneyInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


//    --------------------------------------------------------------------------------------------------------------

    @ResponseBody
    @RequestMapping(value="selectAllUser.do",method= RequestMethod.POST)
    public Map<String, Object> selectAllUser(){
        UserServices userServices = new UserServicesImp();
        List<User> list = null;
        try {
            list = userServices.selectAllUser();
            Map<String, Object> map2Json = new HashMap<String, Object>();
            map2Json.put("data", list);
            return map2Json;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("toEditUser.do")
    public String toEditUser(HttpServletRequest request){
        int userId = Integer.parseInt(request.getParameter("id"));
        UserServices userServices = new UserServicesImp();
        try {
            User user = userServices.selectUserById(userId);
            request.setAttribute("user",user);
            return "editUser";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("editUser.do")
    public String editUser(HttpServletRequest request){
        int userId = Integer.parseInt(request.getParameter("userId"));
        String userName = request.getParameter("userName");
        String userSex = request.getParameter("userSex");
        int userAge = Integer.parseInt(request.getParameter("userAge"));
        String userPhone = request.getParameter("userPhone");
        User user = new User(userId,userName,userSex,userAge,userPhone);
        UserServices userServices = new UserServicesImp();
        try {
            userServices.editUser(user);
            return "userInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("toAddUser.do")
    public String toAddUser(){
        return "addUser";
    }

    @RequestMapping("addUser.do")
    public String addUser(HttpServletRequest request){
        String userName = request.getParameter("userName");
        String userSex = request.getParameter("userSex");
        int userAge = Integer.parseInt(request.getParameter("userAge"));
        String userPhone = request.getParameter("userPhone");
        User user = new User(userName,userSex,userAge,userPhone);
        UserServices userServices = new UserServicesImp();
        try {
            User user1 = userServices.selectUserByPhone(userPhone);
            if (user1 == null){
                userServices.insertUser(user);
                return "userInfo";
            }else {
                String msg = "*该用户已存在";
                request.setAttribute("msg",msg);
                return "addUser";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("deleteUser.do")
    public String deleteUser(HttpServletRequest request){
        int userId = Integer.parseInt(request.getParameter("id"));
        UserServices userServices = new UserServicesImp();
        try {
            userServices.deleteUser(userId);
            return "userInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }




    @ResponseBody
    @RequestMapping(value="selectAllUserSalary.do",method= RequestMethod.POST)
    public Map<String, Object> selectAllUserSalary(){
        UserServices userServices = new UserServicesImp();
        List<UserSalary> list = null;
        try {
            list = userServices.selectAllUserSalary();
            Map<String, Object> map2Json = new HashMap<String, Object>();
            map2Json.put("data", list);
            return map2Json;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("toAddUserSalary.do")
    public String toAddUserSalary(){
        return "addUserSalary";
    }
    @RequestMapping("addUserSalary.do")
    public String addUserSalary(UserSalary userSalary, HttpServletRequest request){
        UserServices userServices = new UserServicesImp();
        try {
            String msg = userServices.insertUserSalary(userSalary);
            if (msg.equals("添加成功")){
                return "userSalaryInfo";
            }else{
                request.setAttribute("msg",msg);
                return "addUserSalary";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("toEditUserSalary.do")
    public String toEditUserSalary(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        UserServices userServices = new UserServicesImp();
        try {
            UserSalary userSalary = userServices.selectUserSalaryById(id);
            request.setAttribute("userSalary",userSalary);
            return "editUserSalary";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("editUserSalary.do")
    public String editUserSalary(UserSalary userSalary){
        UserServices userServices = new UserServicesImp();
        try {
            userServices.editUserSalary(userSalary);
            return "userSalaryInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("deleteUserSalary.do")
    public String deleteUserSalary(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        UserServices userServices = new UserServicesImp();
        try {
            userServices.deleteUserSalary(id);
            return "userSalaryInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("deleteManyUserSalary.do")
    public boolean deleteManyUserSalary(Long[] ids){
        UserServices userServices = new UserServicesImp();
        boolean flag = false;
        try {
            flag = userServices.deleteManyUserSalary(ids);
            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
            return flag;
        }
    }

    @ResponseBody
    @RequestMapping(value="selectNameById.do",method= RequestMethod.POST)
    public User selectNameById(int userId){
        UserServices userServices = new UserServicesImp();
        try {
            User user = userServices.selectUserById(userId);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
