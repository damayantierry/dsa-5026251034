package lw04.unguided;

import java.io.File;
import java.util.*;

public class Main{
    public static void sortCards(int[] arr, int passes){
        int n = arr.length;
        for (int i=0; i<passes && i<n-1; i++){
            int idx = i;
            for (int j=i+1; j<n; j++){
                if (arr[j] < arr[idx]){
                    idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
    }

    public static int findCard(int[] arr, int target){
        for (int i=0; i<arr.length; i++){
            if (arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception{
        Scanner scMaya = new Scanner(Main.class.getResourceAsStream("cards.txt"));
        int n = scMaya.nextInt();
        int[] cards = new int[n];
        for (int i=0; i<n; i++){
            cards[i] = scMaya.nextInt();
        }
        int m = scMaya.nextInt();
        int[] targets = new int[m];
        for (int i=0; i<m; i++){
            targets[i] = scMaya.nextInt();
        }
        scMaya.close();

        sortCards(cards, 2);

        for (int i=0; i<n; i++){
            System.out.print(cards[i] + (i<n-1? " " : " "));
        }
        System.out.println();

        for (int target : targets){
            int index = findCard(cards, target);
            if (index != -1){
                System.out.println(target + ": FOUND at index " + index);
            } else {
                System.out.println(target + ": NOT FOUND");
            }
        }
    }
}