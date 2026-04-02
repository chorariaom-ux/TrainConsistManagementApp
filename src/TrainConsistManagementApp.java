import java.util.*;
import java.util.stream.*;

class GoodsBogie {
    private String type;   // Cylindrical, Open, Box
    private String cargo;  // Petroleum, Coal, Grain, etc.

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "Bogie Type: " + type + ", Cargo: " + cargo;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Sample Goods Bogie List (Modify for testing different cases)
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );

        // Display bogies
        System.out.println("=== Goods Bogies in Train ===");
        bogies.forEach(System.out::println);

        // ✅ Safety Validation using Streams
        boolean isSafe = bogies.stream()
                .allMatch(bogie ->
                        // Rule: If cylindrical → must carry Petroleum
                        !bogie.getType().equalsIgnoreCase("Cylindrical")
                                || bogie.getCargo().equalsIgnoreCase("Petroleum")
                );

        // Result Output
        System.out.println("\n=== Safety Compliance Check ===");
        if (isSafe) {
            System.out.println("Train is SAFE for operation ✅");
        } else {
            System.out.println("Train is UNSAFE for operation ❌");
        }
    }
}