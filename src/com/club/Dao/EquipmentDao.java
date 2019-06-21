package com.club.Dao;

import com.club.Po.Equipment;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-02.
 */
public interface EquipmentDao {

    public List<Equipment> selectAllEquipment() throws SQLException;
    public String insertEquipment(Equipment equipment) throws SQLException;
    public void deleteEquipment(int equId) throws SQLException;
    public void updateEquipment(Equipment equipment) throws SQLException;
    public Equipment selectEquipmentByName(String equName) throws SQLException;
    public Equipment selectEquipmentById(int equId) throws SQLException;
}
