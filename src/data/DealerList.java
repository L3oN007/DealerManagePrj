package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import tools.MyTool;

public class DealerList extends ArrayList<Dealer> {
    private String dataFile = "";
    boolean changed = false;

    public void loadDealerFromFile() {
        try {
            FileReader fr = new FileReader(dataFile);
            BufferedReader br = new BufferedReader(fr);
            String info;
            while ((info = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(info, ",");
                String ID = st.nextToken();
                String name = st.nextToken();
                String addr = st.nextToken();
                String phone = st.nextToken();
                boolean continuing = Boolean.parseBoolean(st.nextToken());
                this.add(new Dealer(ID, name, addr, phone, continuing));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void initWithFile() {
        Config cR = new Config();
        dataFile = cR.getDealerFile();
    }

    public DealerList() {
        super();
    }

    // TODO: Menu Functions
    public int checkID(String id) {
        if (this.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getID().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public void addDealer() {
        int index;
        String ID;
        do {
            ID = MyTool.getStringWithRegex("ID of new dealer(Dxxx):", "Wrong ID format. Please try again.",
                    "^[D]\\d{3}$");
            index = checkID(ID);
            if (index >= 0) {
                System.out.println("ID is duplicated.Input again.");
            }
        } while (index >= 0);
        String name = MyTool.getString("Name of new dealer");
        String addr = MyTool.getString("Address of new dealer");
        String phone = MyTool.getStringWithRegex("Phone of new dealer", "Phone is 9 or 11 digit.", "\\d{9}|\\d{11}");
        boolean continuing = true;
        this.add(new Dealer(ID, name, addr, phone, continuing));
        System.out.println("New dealer added successfully");
        changed = true;
    }

    public void seachDealer() {
        String ID = MyTool.getString("Enter ID dealer to search:");
        int index = checkID(ID);
        if (index >= 0) {
            System.out.println("|    ID    |   NAME   |      ADDRESS       |     PHONE     |CONTINUING|");
            this.get(index).printInfo();
        } else {
            System.out.println("Dealer" + ID + " is not found.");
        }
    }
}
