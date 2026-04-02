import java.util.*;

// -------------------------------
// Custom Exception Class
// -------------------------------
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// -------------------------------
// Passenger Bogie Class
// -------------------------------
class PassengerBogie {
    private String type;     // Sleeper, AC Chair, First Class
    private int capacity;

    // Constructor with validation
    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return type + " | Capacity: " + capacity;
    }
}

// -------------------------------
// Main Application
// -------------------------------
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        List<PassengerBogie> train = new ArrayList<>();

        System.out.println("=== Train Consist Creation ===");

        // Test cases
        try {
            // Valid bogie
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            train.add(b1);
            System.out.println("Added: " + b1);

            // Valid bogie
            PassengerBogie b2 = new PassengerBogie("AC Chair", 60);
            train.add(b2);
            System.out.println("Added: " + b2);

            // Invalid bogie (ZERO capacity)
            PassengerBogie b3 = new PassengerBogie("First Class", 0);
            train.add(b3); // Will not execute
        } catch (InvalidCapacityException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            // Invalid bogie (NEGATIVE capacity)
            PassengerBogie b4 = new PassengerBogie("Sleeper", -10);
            train.add(b4);
        } catch (InvalidCapacityException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // -------------------------------
        // Final Train State
        // -------------------------------
        System.out.println("\n=== Final Train Bogies ===");
        for (PassengerBogie b : train) {
            System.out.println(b);
        }
    }
}