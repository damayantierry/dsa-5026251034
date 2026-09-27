package lw02.prelab;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customers = new LinkedList<>();

         Queue<String[]> q = new LinkedList<>();
         Stack<String[]> fails = new Stack<>();

        Scanner scannermaya = new Scanner(Main.class.getResourceAsStream("transactions.txt"));{

        while(scannermaya.hasNext()){
            String[] transaction = new String[3];
            transaction[0] = scannermaya.next();
            transaction[1] = scannermaya.next();
            transaction[2] = scannermaya.next();
            transactions.add(transaction);
        }
        scannermaya.close();
        q.addAll(transactions);
            
        while(!q.isEmpty()){ 
                String[] transaction = q.poll();
                String name = transaction[0];
                String type = transaction[1];
                int amount = Integer.parseInt(transaction[2]);

        String[] customer = null;

            for (String[] data : customers) {
                if (data[0].equals(name)) {
                    customer = data;
                    break;
                }
            }
                if (customer == null) {
                customer = new String[]{name, "0"};
                customers.add(customer);
            }

            int balance = Integer.parseInt(customer[1]);
            
            if (type.equals("DEPOSIT")){
                balance += amount;
                customer[1] = String.valueOf(balance);
            } else if (balance >= amount) {
                balance -= amount;
                customer[1] = String.valueOf(balance);
            } else {
                    fails.push(transaction); 
            }
            
        }

    System.out.println("=== Final Balances ===");
    for (String [] helo: customers){
        System.out.println(helo[0] + ":" + helo[1]);
    }
    System.out.println("=== Failed Transactions ===");
    while(!fails.isEmpty()){
        String [] fail = fails.pop(); 
        System.out.println(fail[0] + " " + fail[1] + " " + fail[2]);
    }

}
}