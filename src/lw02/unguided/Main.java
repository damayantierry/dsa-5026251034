package lw02.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scannermaya = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));
        LinkedList<String[]> requests = new LinkedList<>();
        LinkedList<String[]> books = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();

        Queue<String[]> queue = new LinkedList<>(); //antrian first in first out
        Stack<String[]> failed = new Stack<>(); //tumpukan last in first out

        books.add(new String[]{"Kalkulus", "2"});
        books.add(new String[]{"Fisika", "1"});
        books.add(new String[]{"Statistika", "2"});

        while(scannermaya.hasNext()){
            String[] request = new String[2];
            request[0] = scannermaya.next();
            request[1] = scannermaya.next();
            requests.add(request);
        }
        scannermaya.close();

        LinkedList<String[]> success = new LinkedList<>();

        queue.addAll(requests);
        while(!queue.isEmpty()){ 
                String[] request = queue.poll(); //ambil data paling depan dari antrian
                String name = request[0];
                String book = request[1];

        String[] member = null;
            for (String[] data : members) {
                if (data[0].equals(name)) {
                    member = data;
                    break;
                }
            }
                if (member == null) {
                member = new String[]{name, "0"};
                members.add(member);
            }
            
            if (book.equals("Kalkulus") && Integer.parseInt(member[1]) < 2 && Integer.parseInt(books.get(0)[1]) > 0) {
                books.get(0)[1] = String.valueOf(Integer.parseInt(books.get(0)[1]) - 1);
                member[1] = String.valueOf(Integer.parseInt(member[1]) + 1);
                success.add(new String[]{name, book});
            } else if (book.equals("Fisika") && Integer.parseInt(member[1]) < 2 && Integer.parseInt(books.get(1)[1]) > 0) {
                books.get(1)[1] = String.valueOf(Integer.parseInt(books.get(1)[1]) - 1);
                member[1] = String.valueOf(Integer.parseInt(member[1]) + 1);
                success.add(new String[]{name, book});
            } else if (book.equals("Statistika") && Integer.parseInt(member[1]) < 2 && Integer.parseInt(books.get(2)[1]) > 0) {
                books.get(2)[1] = String.valueOf(Integer.parseInt(books.get(2)[1]) - 1);
                member[1] = String.valueOf(Integer.parseInt(member[1]) + 1);
                success.add(new String[]{name, book});
            } else {
                    failed.push(request); 
            }
            
        }

    System.out.println("\n=== Successfully Processed Requests ===");
    for (String [] request : success){
        System.out.println(request[0] + " " + request[1]);
    }
    System.out.println("\n=== Remaining Book Stock ===");
    System.out.println("Kalkulus : " + books.get(0)[1]);
    System.out.println("Fisika : " + books.get(1)[1]);
    System.out.println("Statistika : " + books.get(2)[1]);

    System.out.println("\n=== Failed Transactions ===");
    while(!failed.isEmpty()){
        String [] fail = failed.pop(); 
        System.out.println(fail[0] + " " + fail[1]);
    }
}
}