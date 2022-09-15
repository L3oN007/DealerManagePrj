package tools;

import java.util.Scanner;

/**
 *
 * @author Vu Minh Nhat
 */
public class MyTool {

    public static Scanner sc = new Scanner(System.in);

    public static int getInt(String mess, int min, int max) {
        System.out.print(mess);
        while (true) {
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.print("Please input an integer number: ");
            }
        }
    }

    public static String getString(String mess) {
        String id;
        while (true) {
            System.out.print(mess);
            id = sc.nextLine().trim();
            if (id.isEmpty() || id.length() == 0) {
                System.out.println("Wrong Input! Please try again.");
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

    public static boolean confirmYesNo(String mess) {
        System.out.println(mess);
        while (true) {
            String result = sc.nextLine();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
        }
    }

}
