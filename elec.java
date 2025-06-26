package electricitybillmanagementsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Interface to calculate the bill based on units consumed
interface BillCalculator {
    double calculateBill(int units); // Function Overloading
}

// Abstract class representing an electricity bill
abstract class ElectricityBill implements BillCalculator { // Inheritance: Parent class
    protected String customerId; // Class property
    protected String customerName;
    protected String address;
    protected int unitsConsumed;
    protected String billMonth;

    // Constructor Overloading: Multiple constructors
    public ElectricityBill(String customerId, String customerName, String address, int unitsConsumed, String billMonth) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.unitsConsumed = unitsConsumed;
        this.billMonth = billMonth;
    }

    public ElectricityBill(String customerId, String customerName, String address) {
        this(customerId, customerName, address, 0, "Unknown Month");
    }

    // Abstract method to be implemented by subclasses (Method Overriding)
    public abstract double calculateBill();

    public void displayBill() { // Method
        System.out.printf("Customer ID: %s\nCustomer Name: %s\nAddress: %s\nUnits Consumed: %d\nBill Amount: ₹%.2f\n",
                customerId, customerName, address, unitsConsumed, calculateBill());
    }

    public int getUnitsConsumed() {
        return unitsConsumed;
    }
}

// Residential Bill class
// Residential Bill class
class ResidentialBill extends ElectricityBill {
    private static final double RESIDENTIAL_RATE = 1.5;

    public ResidentialBill(String customerId, String customerName, String address, int unitsConsumed, String billMonth) {
        super(customerId, customerName, address, unitsConsumed, billMonth);
    }

    @Override
    public double calculateBill() {
        return unitsConsumed * RESIDENTIAL_RATE;
    }

    @Override
    public double calculateBill(int units) {
        return units * RESIDENTIAL_RATE;
    }
}

// Commercial Bill class
class CommercialBill extends ElectricityBill {
    private static final double COMMERCIAL_RATE = 2.5;

    public CommercialBill(String customerId, String customerName, String address, int unitsConsumed, String billMonth) {
        super(customerId, customerName, address, unitsConsumed, billMonth);
    }

    @Override
    public double calculateBill() {
        return unitsConsumed * COMMERCIAL_RATE;
    }

    @Override
    public double calculateBill(int units) {
        return units * COMMERCIAL_RATE;
    }
}


// Main class
public class Electricitybillmanagementsystem {
    private static final List<ElectricityBill> bills = new ArrayList<>(); // Collection Class (ArrayList)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try { // Exception Handling
                System.out.println("\n=== Online Electricity Billing System ===");
                System.out.println("1. Calculate Bill");
                System.out.println("2. View All Bills");
                System.out.println("3. View Monthly Summary");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> calculateBill(scanner);
                    case 2 -> viewAllBills();
                    case 3 -> viewMonthlySummary();
                    case 4 -> {
                        System.out.println("Exiting the system. Goodbye!");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine(); // Clear input buffer
            }
        }
    }

    private static void calculateBill(Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Bill Month: ");
        String billMonth = scanner.nextLine();
        System.out.print("Enter Bill Type (Residential/Commercial): ");
        String billType = scanner.nextLine();

        Random rand = new Random();
        int unitsConsumed = rand.nextInt(451) + 50; // Random units consumed

        ElectricityBill bill = switch (billType.toLowerCase()) {
            case "residential" -> new ResidentialBill(customerId, customerName, address, unitsConsumed, billMonth);
            case "commercial" -> new CommercialBill(customerId, customerName, address, unitsConsumed, billMonth);
            default -> {
                System.out.println("Invalid bill type. Bill not created.");
                yield null;
            }
        };

        if (bill != null) {
            bills.add(bill);
            bill.displayBill();
        }
    }

    private static void viewAllBills() {
        if (bills.isEmpty()) {
            System.out.println("No bills generated yet.");
        } else {
            System.out.println("\n=== All Bills ===");
            for (ElectricityBill bill : bills) {
                System.out.printf("Customer ID: %s | Units: %d | Amount: ₹%.2f\n",
                        bill.customerId, bill.getUnitsConsumed(), bill.calculateBill());
            }
        }
    }

    private static void viewMonthlySummary() {
        if (bills.isEmpty()) {
            System.out.println("No bills generated yet.");
        } else {
            System.out.println("\n=== Monthly Summary ===");
            for (ElectricityBill bill : bills) {
                System.out.printf("Month: %s | Customer ID: %s | Units Consumed: %d | Total Bill: ₹%.2f\n",
                        bill.billMonth, bill.customerId, bill.getUnitsConsumed(), bill.calculateBill());
            }
        }
    }
}	



