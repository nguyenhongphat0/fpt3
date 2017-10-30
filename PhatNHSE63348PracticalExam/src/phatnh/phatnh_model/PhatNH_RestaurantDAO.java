/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.phatnh_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import phatnh.phatnh_controller.PhatNH_Connection;

/**
 *
 * @author nguyenhongphat0
 */
public class PhatNH_RestaurantDAO {
    
    public ArrayList<PhatNH_RestaurantDTO> getRestaurantByDistrict(String phatnh_district) {
        Connection phatnh_conn = null;
        PreparedStatement phatnh_pre = null;
        ResultSet phatnh_res = null;
        ArrayList<PhatNH_RestaurantDTO> phatnh_list = new ArrayList<>();
        try {
            phatnh_conn = PhatNH_Connection.getConnection();
            phatnh_pre = phatnh_conn.prepareStatement("SELECT RestaurantID, RestaurantName, Address, District FROM tbl_Restaurant WHERE District = ? AND isDelete = 0");
            phatnh_pre.setString(1, phatnh_district);
            phatnh_res = phatnh_pre.executeQuery();
            while (phatnh_res.next()) {     
                String id = phatnh_res.getString("RestaurantID");
                String name = phatnh_res.getString("RestaurantName");
                String address = phatnh_res.getString("Address");
                phatnh_list.add(new PhatNH_RestaurantDTO(id, name, address, phatnh_district));
            }
        } catch (Exception phatnh_e) {
            phatnh_e.printStackTrace();
        }
        return phatnh_list;
    }
    
    public boolean updateRestaurant(PhatNH_RestaurantDTO phatnh_restaurant) {
        Connection phatnh_conn = null;
        PreparedStatement phatnh_pre = null;
        int phatnh_res = 0;
        try {
            phatnh_conn = PhatNH_Connection.getConnection();
            phatnh_pre = phatnh_conn.prepareStatement("UPDATE tbl_Restaurant SET RestaurantName = ?, Address = ?, District = ?, isDelete = ? WHERE RestaurantID = ?");
            phatnh_pre.setString(1, phatnh_restaurant.getPhatnh_name());
            phatnh_pre.setString(2, phatnh_restaurant.getPhatnh_address());
            phatnh_pre.setString(3, phatnh_restaurant.getPhatnh_district());
            phatnh_pre.setInt(4, 0);
            phatnh_pre.setString(5, phatnh_restaurant.getPhatnh_id());
            phatnh_res = phatnh_pre.executeUpdate();
        } catch (Exception phatnh_e) {
            phatnh_e.printStackTrace();
        }
        return phatnh_res > 0;
    }
    
    public Vector<String> getAllDistrict() {
        Connection phatnh_conn = null;
        PreparedStatement phatnh_pre = null;
        ResultSet phatnh_res = null;
        Vector<String> phatnh_list = new Vector<>();
        try {
            phatnh_conn = PhatNH_Connection.getConnection();
            phatnh_pre = phatnh_conn.prepareStatement("SELECT DISTINCT District FROM tbl_Restaurant");
            phatnh_res = phatnh_pre.executeQuery();
            while (phatnh_res.next()) {
                phatnh_list.add(phatnh_res.getString("District"));
            }
        } catch (Exception phatnh_e) {
            phatnh_e.printStackTrace();
        }
        return phatnh_list;
    }
    
    
}
