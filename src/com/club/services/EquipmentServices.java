package com.club.services;

import com.club.Po.Equipment;
import com.club.Po.EquipmentOrder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-02.
 */
public interface EquipmentServices {
    public List<Equipment> selectAllEquipment() throws SQLException;
    public String insertEquipment(Equipment equipment) throws SQLException;
    public void deleteEquipment(int equId) throws SQLException;
    public void updateEquipment(Equipment equipment) throws SQLException;
    public Equipment selectEquipmentByName(String equName) throws SQLException;
    public Equipment selectEquipmentById(int equId) throws SQLException;
    public boolean deleteManyEquipment(Long[] ibs) throws SQLException;


    public List<EquipmentOrder> selectAllEquOrder() throws SQLException;
    public EquipmentOrder selectEquOrder(int orderId) throws SQLException;
    public void insertEquOrder(EquipmentOrder equipmentOrder) throws SQLException;
    public void updateEquOrder(EquipmentOrder equipmentOrder) throws SQLException;
    public void deleteEquOrder(int orderId) throws SQLException;
    public boolean deleteManyEquOrder(Long[] ibs) throws SQLException;

}
