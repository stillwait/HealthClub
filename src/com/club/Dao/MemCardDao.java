package com.club.Dao;

import com.club.Po.MemCard;

import java.sql.SQLException;

/**
 * Created by Administrator on 2019-04-23.
 */
public interface MemCardDao {
    public void insertMemCard(MemCard memCard) throws SQLException;
}
