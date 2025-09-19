/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_assignment;
import java.util.Scanner;

public class POE_Assignment {

    public static void main(String[] args) {
        //Create Scanner object
        Scanner input = new Scanner(System.in);

        // Collect first and last name for personalized login
        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();
        
        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        // Create Login object
        Login loginSystem = new Login();
        
        //Set first and last name
        loginSystem.setFirstname(firstName);
        loginSystem.setLastName(lastName);

        System.out.println("\n=== User Registration ===");
        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter South African cell phone number (with +27): ");
        String cellPhone = input.nextLine();

        // Register User
        String registrationMessage = loginSystem.registerUser(username, password, cellPhone);
        System.out.println(registrationMessage);

        // If registration failed, stop program
        if (!registrationMessage.equals("User registered successfully.")) {
            System.out.println("Registration failed. Please restart and try again.");
            return;
        }

        System.out.println("\n=== User Login ===");
        String loginUsername;
        
        do {
            System.out.println("Please enter your user name: ");
            loginUsername = input.nextLine();
        } while (!loginSystem.checkUserName(loginUsername));
        
        System.out.print("Enter password: ");
        String loginPassword;
        
        do {
            System.out.println("Please enter your password: ");
            loginPassword = input.nextLine();
        } while (!loginSystem.checkPasswordComplexity(loginPassword));
        
        // Login Attempt
        String loginStatus = loginSystem.returnLoginStatus(loginUsername, loginPassword);
        System.out.println(loginStatus);

        input.close();
    }
}
