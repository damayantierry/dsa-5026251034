package lw04.prelab;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("branches.txt"));

        // Membaca jumlah branches
        int N = input.nextInt();

        // Membaca data stability
        int[] branches = new int[N];

        for (int i = 0; i < N; i++) {
            branches[i] = input.nextInt();
        }

        // Membaca jumlah target
        int M = input.nextInt();

        // Membaca target pencarian
        int[] targets = new int[M];

        for (int i = 0; i < M; i++) {
            targets[i] = input.nextInt();
        }

        input.close();

        // Sorting dengan Insertion Sort selama 3 pass
        insertionSort(branches, 3);

        // Menampilkan array setelah sorting
        for (int i = 0; i < N; i++) {
            System.out.print(branches[i]);

            if (i < N - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        // Searching setiap target
        for (int i = 0; i < M; i++) {
            int index = linearSearch(branches, targets[i]);

            if (index != -1) {
                System.out.println(
                    targets[i] + ": FOUND at index " + index
                );
            } else {
                System.out.println(targets[i] + ": NOT FOUND");
            }
        }
    }

    // Insertion Sort Descending
    public static void insertionSort(int[] data, int passes) {
        for (int i = 1; i <= passes; i++) {
            int key = data[i];
            int j = i - 1;

            while (j >= 0 && data[j] < key) {
                data[j + 1] = data[j];
                j--;
            }

            data[j + 1] = key;
        }
    }

    // Linear Search
    public static int linearSearch(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }

        return -1;
    }
}

