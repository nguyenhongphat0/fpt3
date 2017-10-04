/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salemanagementsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author DuongPTH
 */
public class CustomerList {

    DLLList<Customer> cList;
    private Scanner sc = new Scanner(System.in);

    public CustomerList() {
        cList = new DLLList<>();
    }

    public void addFromFile() {
        File f = new File("customer.txt");
        FileReader fr = null;
        BufferedReader br = null;
        String s = "";
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            while ((s = br.readLine()) != null) {
                StringTokenizer tok = new StringTokenizer(s, "|");
                Customer c = new Customer(tok.nextToken().trim(), tok.nextToken().trim(), tok.nextToken().trim());
                cList.addLast(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void display() {
        System.out.format("%5s|%15s|%15s\n", "cCode", "cName", "phone");
        cList.traveseToLast();
    }

    private Customer createNew() {
        String code = "";
        String name = "";
        String phone = "";

        do {
            try {
                System.out.println("Enter code : ");
                code = sc.nextLine().trim();
                if (!code.matches("C\\d{2}")) {
                    throw new Exception("Wrong format code Cxx ");
                }
                if (!cList.isEmpty()) {
                    for (DLLNode<Customer> p = cList.head; p != null; p = p.next) {
                        if (p.info.getcCode().equals(code)) {
                            throw new Exception("Duppilcate Code");
                        }
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        System.out.println("Enter Name : ");
        name = sc.nextLine();

        do {
            try {
                System.out.println("Enter phone : ");
                phone = sc.nextLine().trim();
                Integer.parseInt(phone);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        return new Customer(code, name, phone);
    }

    public void addNew() {
        Customer customer = createNew();
        cList.addLast(customer);
    }

    public void saveToFile() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("customer.txt");
            for (DLLNode i = cList.head; i != null; i = i.next) {
                pw.println(i.info);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            pw.close();
        }
    }

    private Customer search(String xCode) {
        for (DLLNode<Customer> i = cList.head; i != null; i = i.getNext()) {
            if (i.getInfo().getcCode().equals(xCode)) {
                return i.getInfo();
            }
        }
        return null;
    }

    public void searchByCode() {

        System.out.println("Enter the code for searching");
        String tmp = sc.nextLine();
        Customer p = search(tmp);
        if (p == null) {
            System.out.println("Code not found");
        } else {
            System.out.println(p);
        }
    }

    public void deleteByCode() {
        System.out.println("Enter the code for deleting");
        String tmp = sc.nextLine();
        Customer p = search(tmp);
        try {
            cList.delete(p);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
