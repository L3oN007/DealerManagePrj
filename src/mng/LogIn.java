/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mng;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import data.Account;
import data.Config;
import tools.MyTool;

/**
 *
 * @author Vu Minh Nhat
 */
public class LogIn {

    private String accFile;
    private static final ArrayList<Account> listAcc = new ArrayList();

    public LogIn() {
        setupAccFile();
        readData();
    }

    public void setupAccFile() {
        Config cR = new Config();
        accFile = cR.getAccountFile();
    }

    public void readData() {
        try {
            FileReader fr = new FileReader(accFile);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                String accName = stk.nextToken();
                String password = stk.nextToken();
                String role = stk.nextToken();
                listAcc.add(new Account(accName, password, role));
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Account inputAccount() {
        System.out.println("Please login to System");
        String name = MyTool.getString("Your account name: ", "Not blank or empty.Input again.");
        String password = MyTool.getString("Your password: ", "Not blank or empty.Input again.");
        String role = MyTool.getString("Your role: ", "Not blank or empty.Input again.");
        Account acc = new Account(name, password, role);
        return acc;
    }

    public boolean checkLogin(Account acc) {
        if (listAcc.isEmpty()) {
            return false;
        }
        for (int i = 0; i < listAcc.size(); i++) {
            if (listAcc.get(i).getAccName().equalsIgnoreCase(acc.getAccName())
                    && listAcc.get(i).getPwd().equals(acc.getPwd())
                    && listAcc.get(i).getRole().equalsIgnoreCase(acc.getRole())) {
                return true;
            }
        }
        return false;
    }
}
