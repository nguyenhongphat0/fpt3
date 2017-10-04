/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salemanagementsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author DuongPTH
 */
public class ProductList {

    DLLList<Product> pList;
    private Scanner sc = new Scanner(System.in);

    public ProductList() {
        pList = new DLLList<Product>();
    }

    public void addFromFile() {
        File f = new File("product.txt");
        FileReader fr = null;
        BufferedReader br = null;
        String s = "";
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            while ((s = br.readLine()) != null) {
                StringTokenizer tok = new StringTokenizer(s, "|");
                Product p = new Product(tok.nextToken().trim(), tok.nextToken().trim(), Integer.parseInt(tok.nextToken().trim()), Integer.parseInt(tok.nextToken().trim()), Double.parseDouble(tok.nextToken().trim()));
                pList.addLast(p);
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
        System.out.format("%5s|%15s|%15s|%5s|%10s\n", "pCode", "pName", "quantity", "saled", "price");
        pList.traveseToLast();
    }

    private Product createNew() {
        String code = "";
        String name = "";
        int saled, quantity;
        double price;

        do {
            try {
                System.out.println("Enter code : ");
                code = sc.nextLine().trim();
                if (!code.matches("P\\d{2}")) {
                    throw new Exception("Wrong format code Pxx ");
                }
                if (!pList.isEmpty()) {
                    for (DLLNode<Product> p = pList.head; p != null; p = p.next) {
                        if (p.info.getpCode().equals(code)) {
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
                System.out.println("Enter Quantity");
                quantity = Integer.parseInt(sc.nextLine().trim());
                if (quantity < 0) {
                    throw new Exception("Please insert positive number");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        do {
            try {
                System.out.println("Enter Saled");
                saled = Integer.parseInt(sc.nextLine().trim());
                if (saled < 0 || saled > quantity) {
                    throw new Exception("Please insert positive number in range[0.." + quantity + ']');
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        do {
            try {
                System.out.println("Enter Price");
                price = Double.parseDouble(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return new Product(code, name, quantity, saled, price);
    }

    public void addNew() {
        Product product = createNew();
        pList.addLast(product);
    }

    public void saveToFile() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("product.txt");
            for (DLLNode i = pList.head; i != null; i = i.next) {
                pw.println(i.info);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            pw.close();
        }
    }

    public void arsSort() {
        pList.ascSort();
    }

    public void addAfterPos() {
        int pos;
        do {
            try {
                System.out.println("Enter Position : ");
                pos = Integer.parseInt(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        Product product = createNew();

        pList.addAfterPos(product, pos);
    }

    private Product search(String xCode) {
        for (DLLNode<Product> i = pList.head; i != null; i = i.getNext()) {
            if (i.getInfo().getpCode().equals(xCode)) {
                return i.getInfo();
            }
        }
        return null;
    }

    private Product searchNext(String xCode) {
        for (DLLNode<Product> i = pList.head; i != null; i = i.getNext()) {
            if (i.getInfo().getpCode().equals(xCode)) {
                if (i.getNext() != null) {
                    return (Product) (i.getNext()).getInfo();
                }
            }
        }
        return null;
    }

    public void searchByCode() {

        System.out.println("Enter the code for searching");
        String tmp = sc.nextLine();
        Product p = search(tmp);
        if (p == null) {
            System.out.println("Code not found");
        } else {
            System.out.println(p);
        }
    }

    public void deleteByCode() {
        System.out.println("Enter the code for deleting");
        String tmp = sc.nextLine();
        Product p = search(tmp);
        try {
            pList.delete(p);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteAfterCode() {
        System.out.println("Enter the code for deleting");
        String tmp = sc.nextLine();
        Product p = searchNext(tmp);
        try {
            pList.delete(p);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
