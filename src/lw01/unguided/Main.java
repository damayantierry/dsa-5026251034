package lw01.unguided;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannermaya = new Scanner(Main.class.getResourceAsStream("rentals.txt"));
        int n = scannermaya.nextInt();
        Rental[] rentalArray = new Rental[n];
        int[] unitsArray = new int[n];

            for (int i = 0; i < n; i++) {
                String type = scannermaya.next();
                String id = scannermaya.next();
                int days = scannermaya.nextInt();
                int units = scannermaya.nextInt();

                Rental rental;
                if (type.equals("LAPTOP")) {
                    rental = new LaptopRental(id, days);
                } else {
                    rental = new ProjectorRental(id, days);
                }
                rentalArray[i] = rental;
                unitsArray[i] = units;
            }

            scannermaya.close();

            for (int i = 0; i < n; i++) {
                System.out.println(rentalArray[i].getId() + " | " + rentalArray[i].label() + " | " + rentalArray[i].calculateCharge(unitsArray[i]));
            }
        }
    }

