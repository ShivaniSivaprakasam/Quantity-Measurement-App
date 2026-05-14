# Quantity Measurement App

## Overview

The **Quantity Measurement App** is a use-case-driven application built using **Core Java** and **Maven**. It implements quantity measurement operations step by step, covering length, weight, volume, and temperature — all with unit conversion and arithmetic support.

The project is designed following:
- ✅ **Clean Coding Principles**
- ✅ **Object-Oriented Design (OOD)**
- ✅ **Test-Driven Development (TDD)**
- ✅ **GitFlow Branching Strategy**

Each feature is implemented as a distinct **Use Case (UC)** to ensure modular development and easy tracking of progress.

---

## Technologies Used

| Technology     | Purpose                          |
|----------------|----------------------------------|
| Java           | Core programming language        |
| Maven          | Build and dependency management  |
| JUnit 5        | Unit testing framework           |
| Git & GitFlow  | Version control and branching    |
| IntelliJ IDEA  | IDE                              |

---

## Project Structure

```
src
└── main
    └── java
        └── com.bridgelabz
            ├── Quantity.java
            ├── LengthUnit.java
            ├── WeightUnit.java
            ├── VolumeUnit.java
            ├── TemperatureUnit.java
            ├── IMeasurable.java
            └── QuantityMeasurementApp.java
```
---

## Use Cases

### 📘 Introduction & Setup

| UC | Title | Description |
|----|-------|-------------|
| 01 | Quantity Measurement App Intro | Introduction to the project, its purpose, goals, and the overall architecture. |
| 02 | Quantity Measurement App GIT Workflow | Walkthrough of the GitFlow branching strategy — feature branches, merging, and commit conventions. |
| 03 | Quantity Measurement App Development Methodology | Overview of the TDD methodology and clean coding practices applied across all use cases. |

---

### 📏 Length Measurement

#### UC1 — Feet Measurement Equality
Implements equality comparison between two measurements in **feet**.
- Create a `Quantity` class to hold a numeric value and unit.
- Two `Quantity` objects with the same feet value must be considered equal.
- Handles null checks and type checks.

#### UC2 — Feet and Inches Measurement Equality
Extends equality comparison to support both **feet** and **inches**.
- `1 foot` must equal `12 inches`.
- Introduces unit-aware equality so different units can be compared correctly.

#### UC3 — Generic Quantity Class for DRY Principle
Refactors the codebase to apply the **DRY (Don't Repeat Yourself)** principle.
- Introduces a generic `Quantity` class that works across measurement types.
- Reduces code duplication between length, weight, and volume classes.

#### UC4 — Extended Unit Support
Adds support for additional length units: **yards** and **centimetres**.
- `1 yard = 3 feet`
- `1 inch = 2.5 cm`
- All new units participate in equality and conversion.

#### UC5 — Unit-to-Unit Conversion (Same Measurement)
Implements conversion between any two units within the **same measurement category**.
- Convert feet ↔ inches ↔ yards ↔ centimetres.
- Conversion is driven by a base unit factor defined in the unit enum.

#### UC6 — Addition of Two Length Units (Same Category)
Supports **addition** of two length quantities from the same category.
- `2 inches + 2 inches = 4 inches`
- `1 foot + 1 foot = 24 inches`
- Result is always returned in inches.

#### UC7 — Addition with Target Unit Specification
Extends addition to allow specifying the **target unit** for the result.
- `1 foot + 1 inch` → result in inches or feet.
- Flexible result unit makes the API more expressive.

---

### ⚖️ Weight Measurement

#### UC9 — Weight Measurement Equality, Conversion & Addition
Introduces **weight** as a new measurement category.
- Supported units: **Grams (g)** and **Kilograms (kg)**.
- `1 kg = 1000 g`
- Implements equality, conversion, and addition for weight quantities.

---

### 🧪 Volume Measurement

#### UC11 — Volume Measurement Equality, Conversion & Addition
Introduces **volume** as a new measurement category.
- Supported units: **Litres (L)** and **Millilitres (mL)**.
- `1 litre = 1000 mL`
- Implements equality, conversion, and addition for volume quantities.

---

### 🌡️ Temperature Measurement

#### UC14 — Temperature Measurement with Selective Arithmetic
Introduces **temperature** as a special measurement category.
- Supported units: **Celsius (°C)** and **Fahrenheit (°F)**.
- Conversion formula: `°F = (°C × 9/5) + 32`
- Note: Temperature does **not** support addition (physically meaningless), only equality and conversion.

---

### 🔧 Refactoring & Architecture

#### UC8 — Refactoring Unit Enum to Standalone with Conversion
Extracts unit definitions into **standalone enum classes** with built-in conversion factors.
- `LengthUnit`, `WeightUnit`, `VolumeUnit` each hold their own conversion logic.
- Improves separation of concerns and testability.

#### UC10 — Generic Quantity Class with Unit Interface
Introduces the `IMeasurable` interface to allow the generic `Quantity<T>` class to work with any unit type.
- Enforces a common contract: all units must provide a base conversion factor.
- Makes the system extensible for new measurement types.

#### UC12 — Subtraction and Division Operations on Quantities
Adds **subtraction** and **division** support to `Quantity`.
- `5 feet - 1 foot = 4 feet`
- `10 inches / 2 = 5 inches`
- Validates edge cases such as division by zero.

#### UC13 — Centralized Arithmetic Logic to Enforce DRY Principle
Moves all arithmetic operations into a single centralized method in the `Quantity` class.
- Eliminates duplicated arithmetic logic scattered across the codebase.
- All arithmetic operations share a common internal implementation.

#### UC15 — N-Tier Architecture Refactoring for Quantity
Restructures the project to follow an **N-Tier architecture**.
- Separates: Model layer, Service layer, Repository layer.
- Makes the codebase ready for database and REST API integration.

---

### 🗄️ Database & Integration

#### UC16 — Database Integration with JDBC for Quantity
Integrates **JDBC** to persist quantity measurements in a relational database.
- Stores and retrieves quantity objects using raw SQL.
- Introduces the DAO (Data Access Object) pattern.

#### UC17 — Spring Framework Integration — REST Services
Migrates the project to the **Spring Framework**.
- Exposes quantity measurement operations as **RESTful APIs**.
- Uses Spring Boot for endpoint management.

#### UC18 — Google Authentication and User Management
Adds **Google OAuth 2.0** for user authentication.
- Users can sign in with their Google account.
- Each user's measurements are scoped to their session/account.

#### UC19 — Spring Boot Microservices
Decomposes the monolithic application into **Spring Boot Microservices**.
- Each measurement category (length, weight, volume, temperature) runs as an independent service.
- Services communicate via REST.

---

## Git Workflow

This project follows the **GitFlow** branching strategy. Each use case is developed in its own feature branch and merged into `develop` upon completion.
feature/<UC-number>-<short-description>

---

## Getting Started

### Prerequisites
- Java 11+
- Maven 3.6+
- Git

### Clone the Repository
```bash
git clone https://github.com/<your-username>/quantity-measurement-app.git
cd quantity-measurement-app
```

### Build the Project
```bash
mvn clean install
```

### Run Tests
```bash
mvn test
```

---

## Features Summary

| Category    | Equality | Conversion | Addition | Subtraction | Division |
|-------------|----------|------------|----------|-------------|----------|
| Length      | ✅       | ✅         | ✅       | ✅          | ✅       |
| Weight      | ✅       | ✅         | ✅       | ✅          | ✅       |
| Volume      | ✅       | ✅         | ✅       | ✅          | ✅       |
| Temperature | ✅       | ✅         | ❌       | ❌          | ❌       |

---

## Author

**Shivani S**
