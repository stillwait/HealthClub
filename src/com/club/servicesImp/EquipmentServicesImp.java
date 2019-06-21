package com.club.servicesImp;

import com.club.Dao.EquipmentDao;
import com.club.Dao.EquipmentOrderDao;
import com.club.DaoImp.EquipmentDaoImp;
import com.club.DaoImp.EquipmentDaoOrderImp;
import com.club.Po.Equipment;
import com.club.Po.EquipmentOrder;
import com.club.services.EquipmentServices;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019-05-02.
 */
public class EquipmentServicesImp implements EquipmentServices {
    @Override
    public List<Equipment> selectAllEquipment() throws SQLException {
        EquipmentDao equipmentDao = new EquipmentDaoImp();
        List<Equipment> list = equipmentDao.selectAllEquipment();
        return list;
    }

    @Override
    public String insertEquipment(Equipment equipment) throws SQLException {
        EquipmentDao equipmentDao = new EquipmentDaoImp();
        String msg = equipmentDao.insertEquipment(equipment);
        return msg;
    }

    @Override
    public void deleteEquipment(int equId) throws SQLException {
        EquipmentDao equipmentDao = new EquipmentDaoImp();
        equipmentDao.deleteEquipment(equId);
    }

    @Override
    public void updateEquipment(Equipment equipment) throws SQLException {
        EquipmentDao equipmentDao = new EquipmentDaoImp();
        equipmentDao.updateEquipment(equipment);
    }

    @Override
    public Equipment selectEquipmentByName(String equName) throws SQLException {
        EquipmentDao equipmentDao = new EquipmentDaoImp();
        Equipment equipment = equipmentDao.selectEquipmentByName(equName);
        return equipment;
    }

    @Override
    public Equipment selectEquipmentById(int equId) throws SQLException {
        EquipmentDao equipmentDao = new EquipmentDaoImp();
        Equipment equipment = equipmentDao.selectEquipmentById(equId);
        return equipment;
    }

    @Override
    public boolean deleteManyEquipment(Long[] ibs) throws SQLException {
        EquipmentDao equipmentDao = new EquipmentDaoImp();
        for (int i = 0;i < ibs.length; i++){
            equipmentDao.deleteEquipment(ibs[i].intValue());
        }
        return true;
    }

    @Override
    public List<EquipmentOrder> selectAllEquOrder() throws SQLException {
        EquipmentOrderDao equipmentOrderDao = new EquipmentDaoOrderImp();
        List<EquipmentOrder> list = equipmentOrderDao.selectAllEquOrder();
        return list;
    }

    @Override
    public EquipmentOrder selectEquOrder(int orderId) throws SQLException {
        EquipmentOrderDao equipmentOrderDao = new EquipmentDaoOrderImp();
        EquipmentOrder equipmentOrder = equipmentOrderDao.selectEquOrder(orderId);
        return equipmentOrder;
    }

    @Override
    public void insertEquOrder(EquipmentOrder equipmentOrder) throws SQLException {
        EquipmentOrderDao equipmentOrderDao = new EquipmentDaoOrderImp();
        equipmentOrderDao.insertEquOrder(equipmentOrder);
    }

    @Override
    public void updateEquOrder(EquipmentOrder equipmentOrder) throws SQLException {
        EquipmentOrderDao equipmentOrderDao = new EquipmentDaoOrderImp();
        equipmentOrderDao.updateEquOrder(equipmentOrder);
    }

    @Override
    public void deleteEquOrder(int orderId) throws SQLException {
        EquipmentOrderDao equipmentOrderDao = new EquipmentDaoOrderImp();
        equipmentOrderDao.deleteEquOrder(orderId);
    }

    @Override
    public boolean deleteManyEquOrder(Long[] ibs) throws SQLException {
        EquipmentOrderDao equipmentOrderDao = new EquipmentDaoOrderImp();
        for (int i = 0;i < ibs.length; i++){
            equipmentOrderDao.deleteEquOrder(ibs[i].intValue());
        }
        return true;
    }
}
