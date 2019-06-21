package com.club.Controller;

import com.club.Dao.CoachSalaryDao;
import com.club.Dao.UserSalaryDao;
import com.club.DaoImp.CoachSalaryDaoImp;
import com.club.DaoImp.UserSalaryDaoImp;
import com.club.Po.*;
import com.club.services.CardServices;
import com.club.services.LoginServices;
import com.club.services.MemberServices;
import com.club.services.UserServices;
import com.club.servicesImp.CardServicesImp;
import com.club.servicesImp.LoginServicesImp;
import com.club.servicesImp.MemberServicesImp;
import com.club.servicesImp.UserServicesImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019-03-25.
 */
@Controller
public class LoginController {

//  默认首页
    @RequestMapping("login.do")
    public String login(){
        return "login";
    }

//  登录验证
    @RequestMapping("index.do")
    public String toLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String userPhone = request.getParameter("userPhone");
        String userPwd = request.getParameter("userPwd");
        String userJob = request.getParameter("userJob");
        LoginServices loginServices = new LoginServicesImp();
        String message = loginServices.loginCheck(userPhone,userPwd,userJob);
        if (message.equals("管理员")){
            if (userPhone.length() == 6){
                int adminId = Integer.parseInt(userPhone);
                Admin admin = loginServices.selectAdminById(adminId);
                admin.setAdminPic("https://www.programan.cn" + admin.getAdminPic());
                request.getSession().setAttribute("admin",admin);
                return "index";
            }else{
                Admin admin = loginServices.selectAdminByPhone(userPhone);
                admin.setAdminPic("https://www.programan.cn" + admin.getAdminPic());
                request.getSession().setAttribute("admin",admin);
                return "index";
            }
        }else if (message.equals("会员")){
            if (userPhone.length() == 6){
                int memId = Integer.parseInt(userPhone);
                Member member = loginServices.selectMemberById(memId);
                member.setMemPic("https://www.programan.cn" + member.getMemPic());
                request.getSession().setAttribute("member",member);
                return "index2";
            }else{
                Member member = loginServices.selectMemberByPhone(userPhone);
                member.setMemPic("https://www.programan.cn" + member.getMemPic());
                request.getSession().setAttribute("member",member);
                return "index2";
            }
        }else{
            request.setAttribute("Msg",message);
            return "login";
        }

    }

//  主页中显示在右方的页面
    @RequestMapping("toWelcomePage.do")
    public String toWelcomePage(HttpServletRequest request){
        UserSalaryDao userSalaryDao = new UserSalaryDaoImp();
        CoachSalaryDao coachSalaryDao = new CoachSalaryDaoImp();
        try {
            List<Integer> userList = userSalaryDao.selectNumber();
            List<Integer> coachList = coachSalaryDao.selectNumber();

            request.setAttribute("userList",userList);
            request.setAttribute("coachList",coachList);
            return "welcomePage";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("toWelcomePage2.do")
    public String toWelcomePage2(){
        return "welcomePage2";
    }

    @RequestMapping("toIndex.do")
    public String toIndex(){ return "index";}

    @RequestMapping("toIndex2.do")
    public String toIndex2(){ return "index2";}

    @RequestMapping("toLoginOut.do")
    public String toLoginOut(HttpServletRequest request, HttpServletResponse response){
        request.getSession().removeAttribute("user");//清空session信息
        request.getSession().invalidate();//清除 session 中的所有信息
        //退出登录的时候清空cookie信息,cookie需要通过HttpServletRequest，HttpServletResponse获取
        Cookie[] cookie=request.getCookies();
        for(Cookie c:cookie){
            if("autoLogin".equals(c.getName())){
                c.setMaxAge(0);
                response.addCookie(c);
            }
        }
       return "login";
    }

    @RequestMapping("toRegister.do")
    public String toRegister(HttpServletRequest request){
        CardServices cardServices = new CardServicesImp();
        try {
            List<Card> cardList = cardServices.selectAllCard();
            request.setAttribute("cardList",cardList);
            return "register";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("register.do")
    public String register(HttpServletRequest request, HttpServletResponse response){
        String memName = request.getParameter("userName");
        String memSex = request.getParameter("userSex");
        int memAge = Integer.parseInt(request.getParameter("userAge"));
        String memPwd = request.getParameter("userPwd");
        String memPhone = request.getParameter("userPhone");
        String date = request.getParameter("userDate");
        int card = Integer.parseInt(request.getParameter("cardType"));
        try {
            Date memDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            MemberServices memberServices = new MemberServicesImp();
            //判断是否已经注册
            Member member1 = memberServices.selectMemberByPhone(memPhone);
            if (member1 == null){
                //插入会员表
                Member member = new Member(memName,memPwd,memSex,memAge,memPhone,memDate,0);
                memberServices.insertMember(member);
                //插入会员与会员卡关联表
                Member member2 = memberServices.selectMemberByPhone(memPhone);
                MemCard memCard = new MemCard(member2.getMemId(),card);
                memberServices.insertMemCard(memCard);
                return "login";
            }else{
                String msg = "*该用户已存在";
                CardServices cardServices = new CardServicesImp();
                List<Card> cardList = cardServices.selectAllCard();
                request.setAttribute("msg",msg);
                request.setAttribute("cardList",cardList);
                return "register";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


}
