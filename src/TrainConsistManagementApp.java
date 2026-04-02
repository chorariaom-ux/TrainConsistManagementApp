import java.util.*;
import java.util.stream.*;

class PassengerBogie {
    private String type;     // Sleeper, AC Chair, First Class
    private int capacity;    // Seat capacity

    public PassengerBogie(String type, int capacity) {
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

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Step 1: Create large dataset of bogies
        List<PassengerBogie> bogies = new ArrayList<>();
        String[] types = {"Sleeper", "AC Chair", "First Class"};
        Random random = new Random();

        // Generate 100000 bogies for benchmarking
        for (int i = 0; i < 100000; i++) {
            String type = types[random.nextInt(types.length)];
            int capacity = 30 + random.nextInt(100); // range: 30–129
            bogies.add(new PassengerBogie(type, capacity));
        }

        // -------------------------------
        // LOOP-BASED FILTERING
        // -------------------------------
        long loopStart = System.nanoTime();

        List<PassengerBogie> loopResult = new ArrayList<>();
        for (PassengerBogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopResult.add(b);
            }
        }

        long loopEnd = System.nanoTime();
        long loopTime = loopEnd - loopStart;

        // -------------------------------
        // STREAM-BASED FILTERING
        // -------------------------------
        long streamStart = System.nanoTime();

        List<PassengerBogie> streamResult = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        long streamEnd = System.nanoTime();
        long streamTime = streamEnd - streamStart;

        // -------------------------------
        // OUTPUT RESULTS
        // -------------------------------
        System.out.println("=== PERFORMANCE COMPARISON ===");

        System.out.println("\nLoop Filtering Result Count: " + loopResult.size());
        System.out.println("Loop Execution Time (ns): " + loopTime);

        System.out.println("\nStream Filtering Result Count: " + streamResult.size());
        System.out.println("Stream Execution Time (ns): " + streamTime);

        // -------------------------------
        // VALIDATION CHECK
        // -------------------------------
        System.out.println("\n=== RESULT VALIDATION ===");

        if (loopResult.size() == streamResult.size()) {
            System.out.println("✅ Both approaches produce SAME results");
        } else {
            System.out.println("❌ Results mismatch!");
        }

        // Ensure time is valid
        if (loopTime > 0 && streamTime > 0) {
            System.out.println("✅ Execution time measured correctly");
        }
    }
}