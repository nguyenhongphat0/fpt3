
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyenhongphat0
 */
public class OrderDetailDTO {
    private String orderId, productID;
    private int quantity;
    private float price;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String orderId, String productID, int quantity, float price) {
        this.orderId = orderId;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" + "orderId=" + orderId + ", productID=" + productID + ", quantity=" + quantity + ", price=" + price + '}';
    }
    
    public Vector toVector() {
        Vector v = new Vector();
        v.add(productID);
        v.add(quantity);
        v.add(price);
        return v;
    }
    
}
