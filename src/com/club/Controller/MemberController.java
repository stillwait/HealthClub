package com.club.Controller;

import com.club.Po.*;
import com.club.services.*;
import com.club.servicesImp.*;
import com.club.util.JSONResult;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019-04-18.
 */
@Controller
@RequestMapping("member")
public class MemberController {

    @ResponseBody
    @RequestMapping(value="selectAllMember.do",method= RequestMethod.POST)
    public Map<String, List<Member>> selectAllMember(){
        MemberServices memberServices = new MemberServicesImp();
        List<Member> list = null;
        try {
            list = memberServices.selectAllMember();
            Map<String, List<Member>> map2Json = new HashMap<String, List<Member>>();
            map2Json.put("data", list);
            return map2Json;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("toAddMember.do")
    public String toAddMember(HttpServletRequest request, HttpServletResponse response){
        CardServices cardServices = new CardServicesImp();
        try {
            List<Card> cardList = cardServices.selectCardName();
            request.setAttribute("cardList",cardList);
            return "addMember";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("addMember.do")
    public String addMember(HttpServletRequest request, HttpServletResponse response){
        String memName = request.getParameter("memName");
        String memPwd = request.getParameter("memPwd");
        String memSex = request.getParameter("memSex");
        int memAge = Integer.parseInt(request.getParameter("memAge"));
        String memPhone = request.getParameter("memPhone");
        String date = request.getParameter("memDate");
        int cardId = Integer.parseInt(request.getParameter("cardType"));
        try {
            MemberServices memberServices = new MemberServicesImp();
            MemberListServices memberListServices = new MemberListServicesImp();
            Card card = memberServices.selectCardById(cardId);
//                插入会员表
            Date memDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            Member member = new Member(memName,memPwd,memSex,memAge,memPhone,memDate,card.getCardPrice());
            String msg = memberServices.insertMember(member);
            if (msg.equals("添加成功")){
                int memId = memberServices.selectMemIdByPhone(memPhone);
//                    插入会员记录
                MemberList memberList = new MemberList(memId,memName,card.getCardName(),card.getCardPrice(),memDate);
                System.out.println(memberList);
                memberListServices.insertMemberList(memberList);
//                    插入会员与会员卡关联表
                MemCard memCard = new MemCard(memId,cardId);
                memberServices.insertMemCard(memCard);
                return "memberInfo";
            }else{
                CardServices cardServices = new CardServicesImp();
                request.setAttribute("msg",msg);
                List<Card> cardList = cardServices.selectCardName();
                request.setAttribute("cardList",cardList);
                return "addMember";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("deleteMember.do")
    public String deleteMember(HttpServletRequest request, HttpServletResponse response){
        int memId = Integer.parseInt(request.getParameter("id"));
        MemberServices memberServices = new MemberServicesImp();
        try {
            memberServices.deleteMember(memId);
            return "memberInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("toTheMemberInfo.do")
    public String theMemberInfo(HttpServletRequest request, HttpServletResponse response){
        int memId = Integer.parseInt(request.getParameter("id"));
        MemberServices memberServices = new MemberServicesImp();
        try {
            List<MemberCardPro> list = memberServices.selectTheMemberInfo(memId);
//            System.out.println(list);
            request.setAttribute("memberList",list);
            return "theMemberInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("toEditMember.do")
    public String toEditMember(HttpServletRequest request, HttpServletResponse response){
        int memId = Integer.parseInt(request.getParameter("id"));
        MemberServices memberServices = new MemberServicesImp();
        CardServices cardServices = new CardServicesImp();
        try {
            List<MemberCardPro> list = memberServices.selectTheMemberInfo(memId);
            List<Card> cardList = cardServices.selectCardName();
            request.setAttribute("memberList",list);
            request.setAttribute("cardList",cardList);
            return "editMember";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("editMember.do")
    public String editMember(HttpServletRequest request, HttpServletResponse response){
        int memId = Integer.parseInt(request.getParameter("id"));
        String memName = request.getParameter("memName");
        String memPwd = request.getParameter("memPwd");
        String memSex = request.getParameter("memSex");
        int memAge = Integer.parseInt(request.getParameter("memAge"));
        String memPhone = request.getParameter("memPhone");
        String date = request.getParameter("memDate");
        MemberServices memberServices = new MemberServicesImp();
//        System.out.println(cardId);
        try {
            Date memDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            Member member = new Member(memId,memName,memPwd,memSex,memAge,memPhone,memDate);
            memberServices.updateMember(member);
            return "memberInfo";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("deleteManyMember.do")
    public boolean deleteManyMember(Long[] ids){
        MemberServices memberServices = new MemberServicesImp();
        boolean flag = false;
        try {
            flag = memberServices.deleteManyMember(ids);
            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
            return flag;
        }
    }

    //管理员页面
    @RequestMapping("toAddProject.do")
    public String toAddProject(HttpServletRequest request, HttpServletResponse response){
        int memId = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("memId",memId);
        return "addProject";
    }

    //会员页面
    @RequestMapping("toAddProject2.do")
    public String toAddProject2(){
        return "addProject2";
    }

    @ResponseBody
    @RequestMapping(value="addProject.do",method= RequestMethod.GET)
    public Map<String, Object> addProject(HttpServletRequest request, HttpServletResponse response){
        int memId = Integer.parseInt(request.getParameter("id"));
        MemberServices memberServices = new MemberServicesImp();
        List<MemProRecord> list = null;
        try {
            list = memberServices.selectMemberProInfo(memId);
            Map<String, Object> map2Json = new HashMap<String, Object>();
            map2Json.put("data", list);
            return map2Json;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("toUpdateMemCard.do")
    public String toUpdateMemCard(HttpServletRequest request){
        int memId =Integer.parseInt(request.getParameter("id"));
        MemberServices memberServices = new MemberServicesImp();
        CardServices cardServices = new CardServicesImp();
        try {
            Member member = memberServices.selectMemberById(memId);
            List<Card> cardList = cardServices.selectCardName();
            request.setAttribute("member",member);
            request.setAttribute("cardList",cardList);
            return "updateMemCard";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("updateMemCard.do")
    public String updateMemCard(HttpServletRequest request){
        int memId =Integer.parseInt(request.getParameter("memId"));
        float memMoney = Float.parseFloat(request.getParameter("memMoney"));
        int cardId = Integer.parseInt(request.getParameter("cardId"));
        CardServices cardServices = new CardServicesImp();
        MemberServices memberServices = new MemberServicesImp();
        try {
            //修改余额
            Member member = new Member(memId,memMoney);
            memberServices.updateMemMoney(member);
            //修改会员卡
            MemCard memCard = new MemCard(memId,cardId);
            memberServices.updateMemberCard(memCard);
            request.setAttribute("memId",memId);
            return "addProject";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @RequestMapping("toAddMemProject.do")
    public String toAddMemProject(HttpServletRequest request){
        int memId = Integer.parseInt(request.getParameter("id"));
        ProjectServices projectServices = new ProjectServicesImp();
        PriceServices priceServices = new PriceServicesImp();
        MemberServices memberServices = new MemberServicesImp();
        try {
            List<Project> projectList = projectServices.selectAllProject();
            List<MemberCardPro> memberCardProList = memberServices.selectTheMemberInfo(memId);
            request.setAttribute("memberCardProList",memberCardProList);
            request.setAttribute("projectList",projectList);
            return "addMemProject";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("addMemProject.do")
    public String addMemProject(HttpServletRequest request){
        MemberServices memberServices = new MemberServicesImp();
        AddProjectListServices addProjectListServices = new AddProjectListServicesImp();
        ProjectServices projectServices = new ProjectServicesImp();
        PriceServices priceServices = new PriceServicesImp();
        int memId = Integer.parseInt(request.getParameter("memId"));
        int proId = Integer.parseInt(request.getParameter("proId"));
        int priceId = Integer.parseInt(request.getParameter("priceId"));
        String date = request.getParameter("proDate");
        float realMoney = Float.parseFloat(request.getParameter("realMoney"));

        float memMoney = Float.parseFloat(request.getParameter("memMoney"));
        float sumMoney = memMoney - realMoney;
        try {
            Date proDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
//            插入会员健身关联表
            MemProject memProject = new MemProject(memId,proId,priceId,proDate,realMoney);
            Member member = new Member(memId,sumMoney);
            memberServices.insertMemProject(memProject);
//            会员卡减钱
            memberServices.updateMemMoney(member);
//            插入办理健身表
            Member member1 = memberServices.selectMemberById(memId);
            Project project = projectServices.selectProjectById(proId);
            Price price = priceServices.selectPriceById(priceId);
            AddProjectList addProjectList = new AddProjectList(memId,member1.getMemName(),project.getProName(),price.getPriceName(),price.getPriceMoney(),proDate);
            addProjectListServices.insertProjectList(addProjectList);
            request.setAttribute("memId",memId);
            return "addProject";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("deleteMemProject.do")
    public String deleteMemProject(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        int memId = Integer.parseInt(request.getParameter("memId"));
        MemberServices memberServices = new MemberServicesImp();
        try {
            memberServices.deleteMemProject(id);
            request.setAttribute("memId",memId);
            return "addProject";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //管理员给会员充值
    @RequestMapping("toAdminAddMemMoney.do")
    public String toAdminAddMemMoney(HttpServletRequest request){
        MemberServices memberServices = new MemberServicesImp();
        int memId = Integer.parseInt(request.getParameter("id"));
        try {
            Member member = memberServices.selectMemberById(memId);
            request.setAttribute("member",member);
            return "adminAddMoney";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("adminAddMemMoney.do")
    public String adminAddMemMoney(HttpServletRequest request){
        MemberServices memberServices = new MemberServicesImp();
        AddMoneyListServices addMoneyListServices = new AddMoneyListServicesImp();
        int memId = Integer.parseInt(request.getParameter("memId"));
        float addMoney = Float.parseFloat(request.getParameter("addMoney"));
        String moneyDate = request.getParameter("date");
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(moneyDate);
            Member member = memberServices.selectMemberById(memId);
            AddMoneyList addMoneyList = new AddMoneyList(memId,member.getMemName(),addMoney,member.getMemMoney(),date);
            float sumMoney = member.getMemMoney() + addMoney;
            Member member1 = new Member(memId,sumMoney);
            memberServices.updateMemMoney(member1); //更新余额
            addMoneyListServices.insertMoneyList(addMoneyList);  //插入充值记录
            request.setAttribute("memId",memId);
            return "addProject";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //会员自己充值
    @RequestMapping("toShowMemMoney.do")
    public String toShowMemMoney(){
        return "showMoney";
    }

    @RequestMapping("toAddMemMoney.do")
    public String toAddMemMoney(){
        return "addMoney";
    }

    @RequestMapping("addMemMoney.do")
    public String addMemMoney(HttpServletRequest request){
        MemberServices memberServices = new MemberServicesImp();
        AddMoneyListServices addMoneyListServices = new AddMoneyListServicesImp();
        int memId = Integer.parseInt(request.getParameter("memId"));
        float addMoney = Float.parseFloat(request.getParameter("addMoney"));
        String moneyDate = request.getParameter("date");
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(moneyDate);
            Member member = memberServices.selectMemberById(memId);
            AddMoneyList addMoneyList = new AddMoneyList(memId,member.getMemName(),addMoney,member.getMemMoney(),date);
            float sumMoney = member.getMemMoney() + addMoney;
            Member member1 = new Member(memId,sumMoney);
            memberServices.updateMemMoney(member1); //更新余额
            addMoneyListServices.insertMoneyList(addMoneyList);  //插入充值记录
            Member member2 = memberServices.selectMemberById(memId);
            request.getSession().setAttribute("member",member2); //更新session;
            return "showMoney";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //会员办理健身
    @RequestMapping("toAddMemProject2.do")
    public String toAddMemProject2(HttpServletRequest request){
        int memId = Integer.parseInt(request.getParameter("id"));
        ProjectServices projectServices = new ProjectServicesImp();
        PriceServices priceServices = new PriceServicesImp();
        MemberServices memberServices = new MemberServicesImp();
        try {
            List<Project> projectList = projectServices.selectAllProject();
            List<MemberCardPro> memberCardProList = memberServices.selectTheMemberInfo(memId);
            request.setAttribute("memberCardProList",memberCardProList);
            request.setAttribute("projectList",projectList);
            return "addMemProject2";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("addMemProject2.do")
    public String addMemProject2(HttpServletRequest request){
        MemberServices memberServices = new MemberServicesImp();
        AddProjectListServices addProjectListServices = new AddProjectListServicesImp();
        ProjectServices projectServices = new ProjectServicesImp();
        PriceServices priceServices = new PriceServicesImp();
        int memId = Integer.parseInt(request.getParameter("memId"));
        int proId = Integer.parseInt(request.getParameter("proId"));
        int priceId = Integer.parseInt(request.getParameter("priceId"));
        String date = request.getParameter("proDate");
        float realMoney = Float.parseFloat(request.getParameter("realMoney"));

        float memMoney = Float.parseFloat(request.getParameter("memMoney"));
        float sumMoney = memMoney - realMoney;
        try {
            Date proDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
//            插入会员健身关联表
            MemProject memProject = new MemProject(memId,proId,priceId,proDate,realMoney);
            Member member = new Member(memId,sumMoney);
            memberServices.insertMemProject(memProject);
//            会员卡减钱
            memberServices.updateMemMoney(member);
//            插入办理健身表
            Member member1 = memberServices.selectMemberById(memId);
            Project project = projectServices.selectProjectById(proId);
            Price price = priceServices.selectPriceById(priceId);
            AddProjectList addProjectList = new AddProjectList(memId,member1.getMemName(),project.getProName(),price.getPriceName(),price.getPriceMoney(),proDate);
            addProjectListServices.insertProjectList(addProjectList);
            request.setAttribute("memId",memId);
            return "addProject2";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //办理健身项目时选择健身项目然后查询价格
    @ResponseBody
    @RequestMapping(value="selectPrice.do",method= RequestMethod.POST)
    public List<ProjectPrice> selectPrice(int proId){
        ProjectServices projectServices = new ProjectServicesImp();
        List<ProjectPrice> list = null;
        try {
            list = projectServices.selectProPriceInfo(proId);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
