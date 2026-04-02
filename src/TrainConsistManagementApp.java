import java.util.*;

// Validator class
class Validator {
    // Train ID format: TRN-1234
    public static boolean isValidTrainId(String trainId) {
        return trainId.matches("^TRN-\\d{4}$");
    }

    // Cargo Code format: PET-AB
    public static boolean isValidCargoCode(String cargoCode) {
        return cargoCode.matches("^[A-Z]{3}-[A-Z]{2}$");
    }
}

// Train class
class Train {
    private String trainId;
    private String cargoCode;

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getCargoCode() {
        return cargoCode;
    }

    public void setCargoCode(String cargoCode) {
        this.cargoCode = cargoCode;
    }
}

// Main Application
public class TrainConsistManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Train object
        Train train = new Train();

        // Input Train ID with validation
        System.out.print("Enter Train ID: ");
        String trainId = scanner.nextLine();

        if (Validator.isValidTrainId(trainId)) {
            train.setTrainId(trainId);
            System.out.println("Train ID accepted.");
        } else {
            System.out.println("Invalid Train ID! Expected format: TRN-1234");
        }

        // Input Cargo Code with validation
        System.out.print("Enter Cargo Code: ");
        String cargoCode = scanner.nextLine();

        if (Validator.isValidCargoCode(cargoCode)) {
            train.setCargoCode(cargoCode);
            System.out.println("Cargo Code accepted.");
        } else {
            System.out.println("Invalid Cargo Code! Expected format: PET-AB");
        }

        // Display Train Info
        System.out.println("\n--- Train Summary ---");
        System.out.println("Train ID: " + train.getTrainId());
        System.out.println("Cargo Code: " + train.getCargoCode());

        System.out.println("\nProgram continues with consist operations...");

        scanner.close();
    }
}