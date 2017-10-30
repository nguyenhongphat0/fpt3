/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.phatnh_model;

import java.util.Vector;

/**
 *
 * @author nguyenhongphat0
 */
public class PhatNH_RestaurantDTO {
    private String phatnh_id, phatnh_name, phatnh_address, phatnh_district;
    private boolean phatnh_isDelete = false;

    public PhatNH_RestaurantDTO() {
    }

    public PhatNH_RestaurantDTO(String phatnh_id, String phatnh_name, String phatnh_address, String phatnh_district, boolean phatnh_isDelete) {
        this.phatnh_id = phatnh_id;
        this.phatnh_name = phatnh_name;
        this.phatnh_address = phatnh_address;
        this.phatnh_district = phatnh_district;
        this.phatnh_isDelete = phatnh_isDelete;
    }

    public PhatNH_RestaurantDTO(String phatnh_id, String phatnh_name) {
        this.phatnh_id = phatnh_id;
        this.phatnh_name = phatnh_name;
    }

    public PhatNH_RestaurantDTO(String phatnh_id, String phatnh_name, String phatnh_address, String phatnh_district) {
        this.phatnh_id = phatnh_id;
        this.phatnh_name = phatnh_name;
        this.phatnh_address = phatnh_address;
        this.phatnh_district = phatnh_district;
    }

    public String getPhatnh_id() {
        return phatnh_id;
    }

    public void setPhatnh_id(String phatnh_id) {
        this.phatnh_id = phatnh_id;
    }

    public String getPhatnh_name() {
        return phatnh_name;
    }

    public void setPhatnh_name(String phatnh_name) {
        this.phatnh_name = phatnh_name;
    }

    public String getPhatnh_address() {
        return phatnh_address;
    }

    public void setPhatnh_address(String phatnh_address) {
        this.phatnh_address = phatnh_address;
    }

    public String getPhatnh_district() {
        return phatnh_district;
    }

    public void setPhatnh_district(String phatnh_district) {
        this.phatnh_district = phatnh_district;
    }

    public boolean isPhatnh_isDelete() {
        return phatnh_isDelete;
    }

    public void setPhatnh_isDelete(boolean phatnh_isDelete) {
        this.phatnh_isDelete = phatnh_isDelete;
    }
    
    public Vector toVector() {
        Vector phatnh_vector = new Vector();
        phatnh_vector.add(this.phatnh_id);
        phatnh_vector.add(this.phatnh_name);
        return phatnh_vector;
    }
}
