package com.club.Dao;

import com.club.Po.EquipmentOrder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-04.
 */
public interface EquipmentOrderDao {
    public List<EquipmentOrder> selectAllEquOrder() throws SQLException;
    public EquipmentOrder selectEquOrder(int orderId) throws SQLException;
    public void insertEquOrder(EquipmentOrder equipmentOrder) throws SQLException;
    public void updateEquOrder(EquipmentOrder equipmentOrder) throws SQLException;
    public void deleteEquOrder(int orderId) throws SQLException;
}
