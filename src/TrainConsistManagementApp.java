import java.util.*;

// -------------------------------
// Custom Runtime Exception
// -------------------------------
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// -------------------------------
// Goods Bogie Class
// -------------------------------
class GoodsBogie {
    private String type;   // Cylindrical, Rectangular
    private String cargo;  // Petroleum, Coal, etc.

    public GoodsBogie(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    // -------------------------------
    // Cargo Assignment Method
    // -------------------------------
    public void assignCargo(String cargo) {

        try {
            System.out.println("\nAssigning " + cargo + " to " + type + " bogie...");

            // Safety Rule:
            // Rectangular bogie should NOT carry Petroleum
            if (type.equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe assignment: Rectangular bogie cannot carry Petroleum"
                );
            }

            // Safe assignment
            this.cargo = cargo;
            System.out.println("✅ Cargo assigned successfully.");

        } catch (CargoSafetyException e) {
            System.out.println("❌ Error: " + e.getMessage());

        } finally {
            System.out.println("🔄 Assignment attempt completed (logged in system).");
        }
    }

    @Override
    public String toString() {
        return "Type: " + type + ", Cargo: " + (cargo != null ? cargo : "Not Assigned");
    }
}

// -------------------------------
// Main Application
// -------------------------------
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Cargo Assignment Simulation ===");

        // Create bogies
        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        // -------------------------------
        // Safe Assignment
        // -------------------------------
        b1.assignCargo("Petroleum");   // ✅ Allowed

        // -------------------------------
        // Unsafe Assignment
        // -------------------------------
        b2.assignCargo("Petroleum");   // ❌ Should trigger exception

        // -------------------------------
        // Continue Execution
        // -------------------------------
        b2.assignCargo("Coal");        // ✅ Allowed

        // -------------------------------
        // Final State
        // -------------------------------
        System.out.println("\n=== Final Bogie Status ===");
        System.out.println(b1);
        System.out.println(b2);
    }
}