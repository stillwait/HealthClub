package com.club.Dao;

import com.club.Po.Price;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-04-26.
 */
public interface PriceDao {
    public List<Price> selectAllPrice() throws SQLException;
    public Price selectPriceById(int priceId) throws SQLException;

    public void updatePrice(Price price) throws SQLException;
    public void deletePrice(int priceId) throws SQLException;
    public String insertPrice(Price price) throws SQLException;
}
