package com.club.servicesImp;

import com.club.Dao.PriceDao;
import com.club.DaoImp.PriceDaoImp;
import com.club.Po.Price;
import com.club.services.PriceServices;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-04-26.
 */
public class PriceServicesImp implements PriceServices {
    @Override
    public List<Price> selectAllPrice() throws SQLException {
        PriceDao priceDao = new PriceDaoImp();
        List<Price> list = priceDao.selectAllPrice();
        return list;
    }

    @Override
    public Price selectPriceById(int priceId) throws SQLException {
        PriceDao priceDao = new PriceDaoImp();
        Price price = priceDao.selectPriceById(priceId);
        return price;
    }

    @Override
    public void updatePrice(Price price) throws SQLException {
        PriceDao priceDao = new PriceDaoImp();
        priceDao.updatePrice(price);
    }

    @Override
    public void deletePrice(int priceId) throws SQLException {
        PriceDao priceDao = new PriceDaoImp();
        priceDao.deletePrice(priceId);
    }

    @Override
    public String insertPrice(Price price) throws SQLException {
        PriceDao priceDao = new PriceDaoImp();
        String msg = priceDao.insertPrice(price);
        return msg;
    }
}
