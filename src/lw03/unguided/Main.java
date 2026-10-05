package lw03.unguided;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Enrollment Checks =====");

        Map<String, Integer> record = new LinkedHashMap<>();
        int rejectedOperations = 0;

        Scanner scannermaya = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));

        while (scannermaya.hasNextLine()) {
            String line = scannermaya.nextLine();

            String[] data = line.split(" ", 2);
            String operation = data[0];
            String code = data[1];

            if (operation.equals("REGISTER")) {
                String[] insertData = code.split(" ", 2);
                String insertcode = insertData[0];
                int count = Integer.parseInt(insertData[1]);

                if (count <= 0) {
                    rejectedOperations++;
                    continue;
                }
                if (record.containsKey(insertcode)) {
                    record.put(insertcode, count+record.get(insertcode));
                } else {
                    record.put(insertcode, count);
                }

            } else if (operation.equals("WITHDRAW")) {
                String[] withdrawData = code.split(" ", 2);
                String withdrawcode = withdrawData[0];
                int count = Integer.parseInt(withdrawData[1]);
                if (record.containsKey(withdrawcode)) {
                    int currentCount = record.get(withdrawcode);
                    if (count <= currentCount) {
                        record.put(withdrawcode, currentCount - count);
                    } else {
                        rejectedOperations++;
                    }
                } else {
                    rejectedOperations++;
                }

            } else if (operation.equals("CHECK")) {
                if (record.containsKey(code)) {
                    System.out.println(code + ": " + record.get(code));
                } else {
                    System.out.println(code + ": Not found");
                }
            }
        }

        scannermaya.close();

        System.out.println("===== Final Enrollment =====");
        for (String course : record.keySet()) {
            System.out.println(course + ": " + record.get(course));
        }
        System.out.println("Rejected operations: " + rejectedOperations);
    }
    
}
