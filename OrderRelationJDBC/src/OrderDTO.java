
import java.sql.Timestamp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyenhongphat0
 */
public class OrderDTO {
    private String orderID, userID, status;
    private float total;
    private Timestamp dateCreate;

    public OrderDTO() {
    }

    public OrderDTO(String orderID, String userID, String status, float total, Timestamp dateCreate) {
        this.orderID = orderID;
        this.userID = userID;
        this.status = status;
        this.total = total;
        this.dateCreate = dateCreate;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "orderID=" + orderID + ", userID=" + userID + ", status=" + status + ", total=" + total + ", dateCreate=" + dateCreate + '}';
    }
    
    
    
}
