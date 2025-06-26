## 📄 Project Abstract

The **Electricity Bill Management System** is a Java-based console application designed to simulate the generation, management, and reporting of electricity bills for residential and commercial consumers. The system demonstrates the use of key object-oriented programming (OOP) concepts and ensures clean, extensible, and modular code.

### 🔧 Key Highlights

- ✅ **Bill Generation**
  - Calculates electricity charges based on the user type: **Residential** or **Commercial**.
  - Randomizes unit consumption between 50 and 500 units to mimic real-world scenarios.

- ✅ **Object-Oriented Design**
  - Implements core OOP concepts such as:
    - **Inheritance**
    - **Constructor Overloading**
    - **Method Overriding**
    - **Interfaces**
  - Abstract base class `ElectricityBill` is extended by `ResidentialBill` and `CommercialBill`.

- ✅ **Interface Implementation**
  - The `BillCalculator` interface defines overloaded `calculateBill()` methods to support flexible billing logic.

- ✅ **User Interaction**
  - Command-line interface (CLI) allows users to:
    - Enter customer details
    - Select bill type
    - Generate and view bills
    - View all billing records
    - View monthly summaries

- ✅ **Collections & Exception Handling**
  - Uses Java’s `ArrayList` to store bill records.
  - Employs `try-catch` blocks to handle invalid inputs and runtime exceptions gracefully.

### 💡 Use Case
This system can be used as a foundational educational tool or prototype for larger-scale billing systems, helping students and developers understand practical applications of OOP in Java.
