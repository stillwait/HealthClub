package com.club.Controller;

import com.club.Po.Card;
import com.club.services.CardServices;
import com.club.servicesImp.CardServicesImp;
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
@RequestMapping("card")
public class CardController {

    @ResponseBody
    @RequestMapping(value = "selectAllList.do", method = RequestMethod.POST)
    public Map<String, Object> selectAllList() {
        CardServices cardServices = new CardServicesImp();
        List<Card> list = null;
        try {
            list = cardServices.selectAllCard();
            Map<String, Object> map2Json = new HashMap<String, Object>();
            map2Json.put("data", list);
            return map2Json;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("deleteCard.do")
    public String deleteList(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        CardServices cardServices = new CardServicesImp();
        try {
            cardServices.deleteCard(id);
            return "cardPriceInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("toEditCard.do")
    public String toEditCard(HttpServletRequest request) {
        CardServices cardServices = new CardServicesImp();
            int cardId = Integer.parseInt(request.getParameter("id"));
        try {
            Card card = cardServices.selectCardById(cardId);
            request.setAttribute("card", card);
            return "editCard";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("editCard.do")
    public String editCard(Card card){
        CardServices cardServices = new CardServicesImp();
        try {
            cardServices.updateCard(card);
            return "cardPriceInfo";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("toAddCard.do")
    public String toAddCard(){return "addCard";}

    @RequestMapping("addCard.do")
    public String addCard(HttpServletRequest request){
        String cardName = request.getParameter("cardName");
        float cardPrice = Float.parseFloat(request.getParameter("cardPrice"));
        String cardBenefit = request.getParameter("cardBenefit");
        Card card = new Card(cardName,cardPrice,cardBenefit);
        CardServices cardServices = new CardServicesImp();
        try {
            String msg = cardServices.insertCard(card);
            if (msg.equals("*添加成功")){
                return "cardPriceInfo";
            }else{
                request.setAttribute("msg",msg);
                return "addCard";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
