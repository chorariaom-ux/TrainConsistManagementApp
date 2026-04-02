import java.util.*;

public class TrainConsistManagementApp {

    // -------------------------------
    // Bubble Sort Method
    // -------------------------------
    public static void bubbleSort(int[] capacities) {

        int n = capacities.length;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {

            // Inner loop for comparison
            for (int j = 0; j < n - 1 - i; j++) {

                // Compare adjacent elements
                if (capacities[j] > capacities[j + 1]) {

                    // Swap
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
    }

    // -------------------------------
    // Utility Method to Print Array
    // -------------------------------
    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // -------------------------------
    // Main Method
    // -------------------------------
    public static void main(String[] args) {

        System.out.println("=== Passenger Bogie Capacity Sorting (Bubble Sort) ===");

        // Sample Test Case
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.print("\nOriginal Capacities: ");
        printArray(capacities);

        // Perform Bubble Sort
        bubbleSort(capacities);

        System.out.print("Sorted Capacities:   ");
        printArray(capacities);

        // -------------------------------
        // Additional Test Cases
        // -------------------------------

        // Already Sorted
        int[] sorted = {24, 56, 60, 70, 72};
        bubbleSort(sorted);

        // Duplicates
        int[] duplicates = {72, 56, 56, 24};
        bubbleSort(duplicates);

        // Single Element
        int[] single = {50};
        bubbleSort(single);

        // All Equal
        int[] equal = {40, 40, 40};
        bubbleSort(equal);

        System.out.println("\n=== Additional Test Cases Executed Successfully ===");
    }
}