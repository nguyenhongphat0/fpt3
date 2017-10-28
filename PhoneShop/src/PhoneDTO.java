
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
public class PhoneDTO {
    String id, name, os, description, picture;
    float price;

    public PhoneDTO() {
    }

    public PhoneDTO(String id, String name, String os, String description, String image, float price) {
        this.id = id;
        this.name = name;
        this.os = os;
        this.description = description;
        this.picture = image;
        this.price = price;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" + "id=" + id + ", name=" + name + ", description=" + description + ", image=" + picture + ", price=" + price + '}';
    }
    
    public Vector toVector() {
        Vector v = new Vector();
        v.add(this.id);
        v.add(this.name);
        v.add(this.price);
        return v;
    }
    
}
