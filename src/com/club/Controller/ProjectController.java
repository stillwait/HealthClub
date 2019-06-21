package com.club.Controller;

import com.club.Po.Price;
import com.club.Po.ProPrice;
import com.club.Po.Project;
import com.club.Po.ProjectPrice;
import com.club.services.PriceServices;
import com.club.services.ProjectServices;
import com.club.servicesImp.PriceServicesImp;
import com.club.servicesImp.ProjectServicesImp;
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
 * Created by Administrator on 2019-04-24.
 */
@Controller
@RequestMapping("project")
public class ProjectController {
    @RequestMapping("toProjectInfo")
    public String toProjectInfo(){
        return "projectInfo";
    }

    @RequestMapping("toProjectInfo2")
    public String toProjectInfo2(){
        return "projectInfo2";
    }

    @ResponseBody
    @RequestMapping(value="selectAllProject.do",method= RequestMethod.POST)
    public Map<String, Object> selectAllProject(){
        ProjectServices projectServices = new ProjectServicesImp();
        try {
            List<Project> list = projectServices.selectAllProject();
            Map<String, Object> map2Json = new HashMap<String, Object>();
            map2Json.put("data", list);
            return map2Json;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("toTheProjectInfo.do")
    public String toTheProjectInfo(HttpServletRequest request, HttpServletResponse response){
        int proId = Integer.parseInt(request.getParameter("id"));
        ProjectServices projectServices = new ProjectServicesImp();
        try {
            List<ProjectPrice> priceList = projectServices.selectProPriceInfo(proId);
            List<String> coachList = projectServices.selectProCoach(proId);
            request.setAttribute("projectPriceList",priceList);
            request.setAttribute("coachList",coachList);
            return "theProjectInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("deleteProject.do")
    public String deleteProject(HttpServletRequest request, HttpServletResponse response){
        int proId = Integer.parseInt(request.getParameter("id"));
        ProjectServices projectServices = new ProjectServicesImp();
        try {
            projectServices.deleteProject(proId);
            return "projectInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("deleteManyProject.do")
    public boolean deleteManyProject(Long[] ids){
        ProjectServices projectServices = new ProjectServicesImp();
        boolean flag = false;
        try {
            flag = projectServices.deleteManyProject(ids);
            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
            return flag;
        }
    }

    @RequestMapping("toAddProject.do")
    public String toAddProject(HttpServletRequest request, HttpServletResponse response){
        PriceServices priceServices = new PriceServicesImp();
        try {
            List<Price> list = priceServices.selectAllPrice();
            request.setAttribute("priceList",list);
            return "addNewProject";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("addProject.do")
    public String addProject(HttpServletRequest request, HttpServletResponse response){
        String proName = request.getParameter("proName");
        String proDescribe = request.getParameter("proDescribe");
        String proDate = request.getParameter("proDate");
        Project project = new Project(proName,proDescribe,proDate);
        ProPrice proPrice;
        ProjectServices projectServices = new ProjectServicesImp();
        try{
            projectServices.insertProject(project);
            if (request.getParameter("priceMoney1") != null){
                int priceMoney1 = Integer.parseInt(request.getParameter("priceMoney1"));
                Project project1 = projectServices.selectProjectByName(proName);
                proPrice = new ProPrice(project1.getProId(),priceMoney1);
                projectServices.insertProjectPrice(proPrice);
            }
            if (request.getParameter("priceMoney1") != null){
                int priceMoney2 = Integer.parseInt(request.getParameter("priceMoney2"));
                Project project1 = projectServices.selectProjectByName(proName);
                proPrice = new ProPrice(project1.getProId(),priceMoney2);
                projectServices.insertProjectPrice(proPrice);
            }
            if (request.getParameter("priceMoney1") != null){
                int priceMoney3 = Integer.parseInt(request.getParameter("priceMoney3"));
                Project project1 = projectServices.selectProjectByName(proName);
                proPrice = new ProPrice(project1.getProId(),priceMoney3);
                projectServices.insertProjectPrice(proPrice);
            }
            return "projectInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("toEditProject.do")
    public String toEditProject(HttpServletRequest request, HttpServletResponse response){
        int proId = Integer.parseInt(request.getParameter("id"));
        ProjectServices projectServices = new ProjectServicesImp();
        PriceServices priceServices = new PriceServicesImp();
        try {
            List<ProjectPrice> list = projectServices.selectProPriceInfo(proId);
            List<Price> priceList = priceServices.selectAllPrice();
            request.setAttribute("priceList",priceList);
            request.setAttribute("list",list);
            return "editProject";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("editProject.do")
    public String editProject(HttpServletRequest request, HttpServletResponse response){
        int proId = Integer.parseInt(request.getParameter("proId"));
        String proName = request.getParameter("proName");
        String proDescribe = request.getParameter("proDescribe");
        String proDate = request.getParameter("proDate");
        int priceMoney1 = Integer.parseInt(request.getParameter("priceMoney1"));
        int priceMoney2 = Integer.parseInt(request.getParameter("priceMoney2"));
        int priceMoney3 = Integer.parseInt(request.getParameter("priceMoney3"));
//        System.out.println(priceMoney1+ "," + priceMoney2 + "," + priceMoney3);
        Project project = new Project(proId,proName,proDescribe,proDate);
        ProjectServices projectServices = new ProjectServicesImp();
        ProPrice proPrice;
        try{
            //更新项目
            projectServices.updateProject(project);
            //更新项目价格
            if (priceMoney1 != 0){
                proPrice = new ProPrice(proId,priceMoney1);
                projectServices.updateProjectPrice(proPrice);
            }else{
                projectServices.deletePriceByName(proId,"三个月");
            }
            if (priceMoney2 != 0){
                proPrice = new ProPrice(proId,priceMoney2);
                projectServices.updateProjectPrice(proPrice);
            }else{
                projectServices.deletePriceByName(proId,"半年");
            }
            if (priceMoney3 != 0){
                proPrice = new ProPrice(proId,priceMoney3);
                projectServices.updateProjectPrice(proPrice);
            }else{
                projectServices.deletePriceByName(proId,"一年");
            }
            return "projectInfo";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
