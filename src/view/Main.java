package view;

import data.Account;
import data.DealerList;
import mng.LogIn;
import mng.Menu;
import tools.MyTool;

public class Main {
    public static void main(String[] args) {
        LogIn log = new LogIn();
        boolean confirm;
        do {
            Account acc = log.inputAccount();
            boolean checkLogin = log.checkLogin(acc);
            if (checkLogin) {
                if (acc.getRole().equalsIgnoreCase("ACC-1")) {
                    DealerList dList = new DealerList();
                    int choice;
                    Menu menu = new Menu("Managing dealers: ");
                    menu.addNewOption("   1-Add new dealer.");
                    menu.addNewOption("   2-Search a dealer.");
                    menu.addNewOption("   3-Remove a dealer.");
                    menu.addNewOption("   4-Update a dealer.");
                    menu.addNewOption("   5-Print all dealers.");
                    menu.addNewOption("   6-Print continuing dealers.");
                    menu.addNewOption("   7-Print Un-continuing dealers.");
                    menu.addNewOption("   8-Write to file");
                    menu.addNewOption("   Other number to quit program!!!");
                    do {
                        menu.printMenu();
                        choice = menu.getChoice();
                        switch (choice) {
                            case 1:
                                dList.addDealer();
                                break;
                            case 2:
                                dList.searchDealer();
                                break;
                            case 3:
                                dList.removeDealer();
                                break;
                            case 4:
                                dList.updateDealer();
                                break;
                            case 5:
                                dList.printAllDealers();
                                break;
                            case 6:
                                dList.printContinuingDealers();
                                break;
                            case 7:
                                dList.printUnContinuingDealers();
                                break;
                            case 8:
                                dList.writeDealerToFile();
                                break;
                        }
                    } while (choice <= 8 && choice > 0);
                } else {
                    System.out.println("Developed afterward!!");
                }
            } else {
                System.out.println("Your account does not exist in the system.");
            }
            confirm = MyTool.confirmYesNo();
        } while (confirm);
        System.out.println("Bye.Have a nice day!");
    }
}
