/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salemanagementsystem;

/**
 *
 * @author DuongPTH
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Menu gui = new Menu();
        gui.addOption("Product");
        gui.addOption("Customer");
        gui.addOption("Order");
        gui.addOption("Exit");
        int guiOp = -1;

        Menu pGUI = new Menu();
        pGUI.addOption("Load data from file");
        pGUI.addOption("Input & add to the end");
        pGUI.addOption("Display data");
        pGUI.addOption("Save product list to file");
        pGUI.addOption("Search by pcodee");
        pGUI.addOption("Delete by pcode");
        pGUI.addOption("Sort by pcode");
        pGUI.addOption("Add after position  k");
        pGUI.addOption("Delete the node after the node having code = xCode");
        pGUI.addOption("Exit");
        int pOp = -1;
        ProductList pList = new ProductList();

        Menu cGUI = new Menu();
        cGUI.addOption("Load data from file");
        cGUI.addOption("Input & add to the end");
        cGUI.addOption("Display data");
        cGUI.addOption("Save customer list to file");
        cGUI.addOption("Search by ccode");
        cGUI.addOption("Delete by ccode");
        cGUI.addOption("Exit");
        int cOp = -1;
        CustomerList cList = new CustomerList();

        Menu oGUI = new Menu();
        oGUI.addOption("Input data");
        oGUI.addOption("Display odering data");
        oGUI.addOption("Sort by pcode + ccode");
        oGUI.addOption("Exit");
        int oOp = -1;
        
        do {
            System.out.println("---------------------------Program---------------------------");
            guiOp = gui.chooseOption();
            switch (guiOp + 1) {
                case 1: {
                    do {
                        System.out.println("=================Product====================");
                        pOp = pGUI.chooseOption();
                        switch (pOp + 1) {
                            case 1:
                                pList.addFromFile();
                                break;
                            case 2:
                                pList.addNew();
                                break;
                            case 3:
                                pList.display();
                                break;
                            case 4:
                                pList.saveToFile();
                                break;
                            case 5:
                                pList.searchByCode();
                                break;
                            case 6:
                                pList.deleteByCode();
                                break;
                            case 7:
                                pList.arsSort();
                                break;
                            case 8:
                                pList.addAfterPos();
                                break;
                            case 9:
                                pList.deleteAfterCode();
                                break;
                        }
                        System.out.println("==================Done=================");
                    } while (pOp != pGUI.getIndex() - 1);
                }
                break;
                case 2: {
                    do {
                        System.out.println("=================Customer====================");
                        cOp = cGUI.chooseOption();
                        switch (cOp + 1) {
                            case 1:
                                cList.addFromFile();
                                break;
                            case 2:
                                cList.addNew();
                                break;
                            case 3:
                                cList.display();
                                break;
                            case 4:
                                cList.saveToFile();
                                break;
                            case 5:
                                cList.searchByCode();
                                break;
                            case 6:
                                cList.deleteByCode();
                                break;
                            case 7:
                                break;
                        }
                        System.out.println("==================Done=================");
                    } while (cOp != cGUI.getIndex() - 1);
                }
                break;
                case 3: {
                    do {
                        System.out.println("=================Order====================");
                        oOp = oGUI.chooseOption();
                        switch (oOp + 1) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                        }
                        System.out.println("==================Done=================");
                    } while (oOp != oGUI.getIndex() - 1);
                }
                break;
            }
        } while (guiOp != gui.getIndex() - 1);

    }

}
