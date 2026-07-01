Call Taxi Booking System

A Java console-based taxi booking application that simulates a real-world taxi allocation system. The application automatically assigns taxis based on availability, proximity to the pickup location, and driver earnings while maintaining booking history and earnings records.

Overview

This project models the workflow of a taxi booking service where customers can book taxis between predefined pickup and drop locations. The system ensures efficient taxi allocation by selecting the nearest available taxi with the lowest earnings, promoting fair trip distribution among drivers.

Features

- Book taxis between locations A–F
- Automatic taxi allocation based on:
  - Taxi availability
  - Distance from pickup location
  - Minimum earnings
- Fare calculation based on travel distance
- Driver earnings tracking
- Booking history for each taxi
- Custom exception handling for invalid locations and unavailable taxis
- Menu-driven console interface

Technologies Used

- Core Java
- Object-Oriented Programming (OOP)
- Java Collections Framework (`ArrayList`)
- BufferedReader
- Exception Handling

Concepts Demonstrated

- Classes and Objects
- Constructors
- Method Overriding
- Custom Exceptions
- Java Collections
- Business Logic Implementation
- Object-Oriented Design

How It Works

1. Enter the number of taxis available.
2. Select Booking from the menu.
3. Provide:
   - Pickup location
   - Drop location
   - Pickup time
4. The system automatically:
   - Finds the nearest available taxi
   - Chooses the taxi with the lowest earnings if multiple taxis are available
   - Calculates the fare
   - Updates the taxi's earnings and booking history
5. Use Display to view each taxi's earnings and completed trips.

Project Structure


TaxiDriver.java
│
├── NoServiceException
├── Taxi
├── CallTaxiApp
└── TaxiDriver (Main Class)
