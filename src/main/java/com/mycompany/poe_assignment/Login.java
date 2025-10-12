/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_assignment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
    private String username;
    private String password;
    private String cellPhone;
    private String firstName;
    private String lastName;

    // Getters and Setters 
    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Constructor
    public Login() {}

    // 1. Check Username
    public boolean checkUserName(String username) {
        if (username.contains("_") && username.length() <= 5) {
            this.username = username;
            return true;
        }
        return false;
    }

    // 2. Check Password Complexity
    public boolean checkPasswordComplexity(String password) {
        boolean length = password.length() >= 8;
        boolean capital = password.matches(".*[A-Z].*");
        boolean number = password.matches(".*[0-9].*");
        boolean special = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

        if (length && capital && number && special) {
            this.password = password;
            return true;
        }
        return false;
    }

    // 3. Check Cell Phone Number (using regex)
    public boolean checkCellPhoneNumber(String cellPhone) {
        // Regex: starts with +27, followed by max 10 digits
        String regex = "^\\+27[0-9]{9,10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cellPhone);

        if (matcher.matches()) {
            this.cellPhone = cellPhone;
            return true;
        }
        return false;
    }

    // 4. Register User
    public String registerUser(String username, String password, String cellPhone, String firstname,String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        else if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        else if (!checkCellPhoneNumber(cellPhone)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        
        // Store the user details using setter methods
        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;
        this.firstName = firstname;
        this.lastName = lastName;
        return "User registered successfully.";
        
      
        
    }

    // 5. Login User
    public boolean loginUser(String username, String password) {
        return username.equals(this.username) && password.equals(this.password);
    }

    // 6. Return Login Status
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + firstName + " " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    
     // Getters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getCellNumber() { return cellPhone; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}
