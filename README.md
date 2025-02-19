# Travel Management System

## Overview
The **Travel Management System** is a comprehensive application designed to streamline travel planning and management. This system allows users to book trips, manage itineraries, and keep track of travel expenses efficiently. It is built using **Java Swing, AWT, and MySQL** for a robust user experience.

## Features
- User authentication (Login/Signup)
- Travel package browsing and booking
- Itinerary management
- Payment processing and invoice generation
- Admin panel for managing users, packages, and bookings
- Database integration using MySQL

## Technologies Used
- **Frontend:** Java Swing, AWT
- **Backend:** Java
- **Database:** MySQL

## Installation & Setup
### Prerequisites
Ensure you have the following installed:
- Java JDK 8 or later
- MySQL Server
- Any Java IDE (Eclipse, IntelliJ, or NetBeans)

### Steps to Run the Project
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/travel-management-system.git
   ```
2. Import the project into your Java IDE.
3. Configure MySQL database:
   - Create a database named `travel_db`.
   - Execute the provided `travel_db.sql` file to set up tables.
4. Update database connection settings in the Java code:
   ```java
   String url = "jdbc:mysql://localhost:3306/travel_db";
   String user = "root";
   String password = "yourpassword";
   ```
5. Compile and run the project:
   ```sh
   javac Splash.java
   java Splash
   ```

## Usage
1. **User Registration/Login:** Users must sign up or log in to access the system.
2. **Browse Packages:** View available travel packages and details.
3. **Book Travel:** Select and confirm bookings with payment.
4. **Manage Itinerary:** View and update travel plans.
5. **Admin Management:** Add/edit travel packages, manage users, and monitor bookings.

## Future Enhancements
- Integration of payment gateways (PayPal, Stripe, etc.)
- Mobile application version
- AI-based travel recommendations
- Multi-language support

## Contributors
- **Ashish Wayachal** - Developer


---
Feel free to reach out if you have any questions or suggestions!

