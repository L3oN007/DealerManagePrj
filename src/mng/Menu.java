/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mng;

import java.util.ArrayList;

import tools.MyTool;

/**
 *
 * @author admin
 */
public class Menu {
    private ArrayList<String> optionList = new ArrayList();
    private String menuTitle;

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public void addNewOption(String newOption) {
        optionList.add(newOption);
    }

    public void printMenu() {
        if (optionList.isEmpty()) {
            System.out.println("There is no item in the menu");
            return;
        }
        System.out.println(menuTitle);
        for (String x : optionList)
            System.out.println(x);
    }

    public int getChoice() {
        int maxOption = optionList.size();
        String inputMsg = "Choose [1.." + maxOption + "]: ";
        return MyTool.getInt(inputMsg, 1, maxOption);
    }
}