package com.club.Controller;

import com.club.Po.Equipment;
import com.club.Po.EquipmentOrder;
import com.club.services.EquipmentServices;
import com.club.servicesImp.EquipmentServicesImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019-05-01.
 */
@Controller
@RequestMapping("equipment")
public class EquipmentController {

    @ResponseBody
    @RequestMapping(value="selectAllEquipment.do",method= RequestMethod.POST)
    public Map<String, Object> selectAllEquipment(){
        EquipmentServices equipmentServices = new EquipmentServicesImp();
        List<Equipment> list = null;
        try {
            list = equipmentServices.selectAllEquipment();
            Map<String, Object> map2Json = new HashMap<String, Object>();
            map2Json.put("data", list);
            return map2Json;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("toAddEquipment.do")
    public String toAddEquipment(HttpServletRequest request, HttpServletResponse response){
        return "addEquipment";
    }

    @RequestMapping("addEquipment.do")
    public String addEquipment(HttpServletRequest request, HttpServletResponse response){
        EquipmentServices equipmentServices = new EquipmentServicesImp();
        String equName = request.getParameter("equName");
        int equNumber = Integer.parseInt(request.getParameter("equNumber"));
        String equType = request.getParameter("equType");
        Equipment equipment = new Equipment(equName,equNumber,equType);
        try {
            equipmentServices.insertEquipment(equipment);
            return "equipmentInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    @RequestMapping("deleteEquipment.do")
    public String deleteEquipment(HttpServletRequest request, HttpServletResponse response){
        int equId = Integer.parseInt(request.getParameter("id"));
        EquipmentServices equipmentServices = new EquipmentServicesImp();
        try {
            equipmentServices.deleteEquipment(equId);
            return "equipmentInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("deleteManyEquipment.do")
    public boolean deleteManyEquipment(Long[] ids){
        EquipmentServices equipmentServices = new EquipmentServicesImp();
        boolean flag = false;
        try {
            flag = equipmentServices.deleteManyEquipment(ids);
            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
            return flag;
        }
    }



    @ResponseBody
    @RequestMapping(value="selectAllEquOrder.do",method= RequestMethod.POST)
    public Map<String, Object> selectAllEquOrder(){
        EquipmentServices equipmentServices = new EquipmentServicesImp();
        List<EquipmentOrder> list = null;
        try {
            list = equipmentServices.selectAllEquOrder();
            Map<String, Object> map2Json = new HashMap<String, Object>();
            map2Json.put("data", list);
            return map2Json;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("toEditEquOrder.do")
    public String toEditEquOrder(HttpServletRequest request){
        int orderId = Integer.parseInt(request.getParameter("id"));
        EquipmentServices equipmentServices = new EquipmentServicesImp();
        try {
            EquipmentOrder equipmentOrder = equipmentServices.selectEquOrder(orderId);
            request.setAttribute("equipmentOrder",equipmentOrder);
            return "editEquOrder";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("toAddEquOrder.do")
    public String toAddEquOrder(HttpServletRequest request, HttpServletResponse response){
        return "addEquOrder";
    }

    @RequestMapping("addEquOrder.do")
    public String addEquOrder(HttpServletRequest request, HttpServletResponse response){
        EquipmentServices equipmentServices = new EquipmentServicesImp();
        int equId = Integer.parseInt(request.getParameter("equId"));
        String equName = request.getParameter("equName");
        int equNumber = Integer.parseInt(request.getParameter("equNumber"));
        float equPrice = Float.parseFloat(request.getParameter("equPrice"));
        float equMoney = Float.parseFloat(request.getParameter("equMoney"));
        String date = request.getParameter("equDate");
        try {
            Date equDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            EquipmentOrder equipmentOrder = new EquipmentOrder(equId,equName,equNumber,equPrice,equMoney,equDate);
            equipmentServices.insertEquOrder(equipmentOrder);
            return "equipmentOrderInfo";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    @RequestMapping("deleteEquOrder.do")
    public String deleteEquOrder(HttpServletRequest request, HttpServletResponse response){
        int orderId = Integer.parseInt(request.getParameter("id"));
        EquipmentServices equipmentServices = new EquipmentServicesImp();
        try {
            equipmentServices.deleteEquOrder(orderId);
            return "equipmentOrderInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("deleteManyEquOrder.do")
    public boolean deleteManyEquOrder(Long[] ids){
        EquipmentServices equipmentServices = new EquipmentServicesImp();
        boolean flag = false;
        try {
            flag = equipmentServices.deleteManyEquOrder(ids);
            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
            return flag;
        }
    }

}
