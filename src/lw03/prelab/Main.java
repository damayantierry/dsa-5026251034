package lw03.prelab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // ==================== PROBLEM 1 ====================
        System.out.println("===== Problem 1 =====");

        List<String> playlist = new ArrayList<>();

        Scanner scannermaya = new Scanner(new File("src/lw03/prelab/playlist.txt"));

        while (scannermaya.hasNextLine()) {
            String line = scannermaya.nextLine();

            String[] data = line.split(" ", 2);
            String operation = data[0];

            if (operation.equals("ADD")) {
                String song = data[1];
                playlist.add(song);

            } else if (operation.equals("INSERT")) {
                String[] insertData = line.split(" ", 3);
                int index = Integer.parseInt(insertData[1]);
                String song = insertData[2];

                playlist.add(index, song);

            } else if (operation.equals("REMOVE")) {
                String song = data[1];

                if (playlist.contains(song)) {
                    playlist.remove(song);
                }
            }
        }

        scannermaya.close();

        System.out.println("Total songs: " + playlist.size());

        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }


        // ==================== PROBLEM 2 ====================
        System.out.println("===== Problem 2 =====");

        Set<String> participants = new LinkedHashSet<>();
        int duplicateRegistrations = 0;

        scannermaya = new Scanner(new File("src/lw03/prelab/participants.txt"));

        while (scannermaya.hasNextLine()) {
            String name = scannermaya.nextLine();

            if (participants.contains(name)) {
                duplicateRegistrations++;
            } else {
                participants.add(name);
            }
        }

        scannermaya.close();

        System.out.println("Unique participants: " + participants.size());

        int number = 1;
        for (String name : participants) {
            System.out.println(number + ". " + name);
            number++;
        }

        System.out.println("Duplicate registrations: " + duplicateRegistrations);


        // ==================== PROBLEM 3 ====================
        System.out.println("===== Problem 3 =====");

        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failedSales = 0;

        scannermaya = new Scanner(new File("src/lw03/prelab/inventory.txt"));

        while (scannermaya.hasNextLine()) {
            String line = scannermaya.nextLine();

            String[] data = line.split(" ");

            String type = data[0];
            String product = data[1];
            int quantity = Integer.parseInt(data[2]);

            if (type.equals("ADD")) {

                if (inventory.containsKey(product)) {
                    int currentStock = inventory.get(product);
                    inventory.put(product, currentStock + quantity);
                } else {
                    inventory.put(product, quantity);
                }

            } else if (type.equals("SELL")) {

                if (inventory.containsKey(product)
                        && inventory.get(product) >= quantity) {

                    int currentStock = inventory.get(product);
                    inventory.put(product, currentStock - quantity);

                } else {
                    failedSales++;
                }
            }
        }

        scannermaya.close();

        for (String product : inventory.keySet()) {
            System.out.println(product + ": " + inventory.get(product));
        }

        System.out.println("Failed sales: " + failedSales);
    }
}
