package lw01.prelab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("jobs.txt"));
        List<PrintJob> jobs = new ArrayList<>();

            while (scanner.hasNext()) {
                String type = scanner.next();
                String id = scanner.next();
                int pages = scanner.nextInt();

                PrintJob job;
                if (type.equals("MONO")) {
                    job = new MonoPrint(id, pages);
                } else {
                    job = new ColourPrint(id, pages);
                } 
                jobs.add(job);
            }

            scanner.close();

            for (PrintJob job : jobs) {
                System.out.println(job.summary());
            }

        } 
    }

