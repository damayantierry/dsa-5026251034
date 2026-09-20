package lw01.Prelab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<PrintJob> jobs = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("jobs.txt"));

            while (scanner.hasNext()) {
                String type = scanner.next();
                String id = scanner.next();
                int pages = scanner.nextInt();

                if (type.equals("MONO")) {
                    jobs.add(new MonoPrint(id, pages));
                } else if (type.equals("COLOUR")) {
                    jobs.add(new ColourPrint(id, pages));
                }
            }

            scanner.close();

            for (PrintJob job : jobs) {
                System.out.println(job.summary());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File jobs.txt not found.");
        }
    }
}
