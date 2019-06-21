package com.club.Controller;

import com.club.Po.Price;
import com.club.services.PriceServices;
import com.club.servicesImp.PriceServicesImp;
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
@RequestMapping("price")
public class ProjectPriceController {
    @ResponseBody
    @RequestMapping(value = "selectAllPrice.do", method = RequestMethod.POST)
    public Map<String, Object> selectAllList() {
        PriceServices priceServices = new PriceServicesImp();
        List<Price> list = null;
        try {
            list = priceServices.selectAllPrice();
            Map<String, Object> map2Json = new HashMap<String, Object>();
            map2Json.put("data", list);
            return map2Json;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("deletePrice.do")
    public String deleteList(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        PriceServices priceServices = new PriceServicesImp();
        try {
            priceServices.deletePrice(id);
            return "projectPriceInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("toEditPrice.do")
    public String toEditCard(HttpServletRequest request) {
        PriceServices priceServices = new PriceServicesImp();
        int priceId = Integer.parseInt(request.getParameter("id"));
        try {
            Price price = priceServices.selectPriceById(priceId);
            request.setAttribute("price", price);
            return "editPrice";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("editPrice.do")
    public String editCard(Price price){
        PriceServices priceServices = new PriceServicesImp();
        try {
            priceServices.updatePrice(price);
            return "projectPriceInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("toAddPrice.do")
    public String toAddPrice(){return "addPrice";}

    @RequestMapping("addPrice.do")
    public String addCard(HttpServletRequest request){
        String priceName = request.getParameter("priceName");
        float priceMoney = Float.parseFloat(request.getParameter("priceMoney"));
        Price price = new Price(priceName,priceMoney);
        PriceServices priceServices = new PriceServicesImp();
        try {
            String msg = priceServices.insertPrice(price);
            if (msg.equals("*添加成功")){
                return "projectPriceInfo";
            }else{
                request.setAttribute("msg",msg);
                return "addPrice";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
