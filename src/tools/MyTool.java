package tools;

import java.util.Scanner;

/**
 *
 * @author Vu Minh Nhat
 */
public class MyTool {

    public static Scanner sc = new Scanner(System.in);

    public static int getInt(String mess) {
        while (true) {
            try {
                System.out.print(mess);
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input a number!!!");
            }
        }
    }

    public static String getString(String mess, String remindMess) {
        String id;
        while (true) {
            System.out.print(mess);
            id = sc.nextLine().trim();
            if (id.isEmpty() || id.length() == 0) {
                System.out.println(remindMess);
            } else {
                return id;
            }
        }
    }

    public static String getStringWithRegex(String mess, String remindMess, String regex) {
        System.out.print(mess);
        while (true) {
            String id = sc.nextLine();
            if (!id.matches(regex)) {
                System.out.print(remindMess);
                continue;
            }
            return id;
        }
    }

    public static boolean confirmYesNo() {
        while (true) {
            System.out.println("Do you want to try again(Y/N): ");
            String result = sc.nextLine();
            // check user input y/Y or n/N
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

}
