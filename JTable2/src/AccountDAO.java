
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phat
 */
public class AccountDAO {
    ArrayList<AccountDTO> list = new ArrayList<>();

    public AccountDAO() {
    }

    public ArrayList<AccountDTO> getList() {
        return list;
    }

    public void setList(ArrayList<AccountDTO> list) {
        this.list = list;
    }
    
    public void saveData(String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (Exception e) {
            System.out.println("Error happened!");
        }
    }
    
    public void loadData(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<AccountDTO>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error happened!");
        }
    }
}
