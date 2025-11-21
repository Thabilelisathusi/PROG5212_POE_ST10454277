/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe_assignment;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    
    public LoginTest() {
    }

    /**
     * Test of checkUserName method, of class Login.
     */
    @org.junit.jupiter.api.Test
    public void testCheckUserName_Correct() {
        System.out.println("checkUserName");
        String username = "kyl_1";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkUserName(username);
        assertEquals(expResult, result);
    }

        @org.junit.jupiter.api.Test
    public void testCheckUserName_Incorrect() {
        System.out.println("checkUserName");
        String username = "kyle!!!!!!!!!!";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkUserName(username);
        assertEquals(expResult, result);
    }
    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @org.junit.jupiter.api.Test
    public void testCheckPasswordComplexity_Correct() {
        System.out.println("checkPasswordComplexity");
        String password = "Ch&&sec@ke99!";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
    }

       @org.junit.jupiter.api.Test
    public void testCheckPasswordComplexity_Incorrect() {
        System.out.println("checkPasswordComplexity");
        String password = "password";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
    }
    /**
     * Test of checkCellPhoneNumber method, of class Login.
     */
    @org.junit.jupiter.api.Test
    public void testCheckCellPhoneNumber_Correct() {
        System.out.println("checkCellPhoneNumber");
        String cellPhone = "+27838968976";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkCellPhoneNumber(cellPhone);
        assertEquals(expResult, result);
    }
    
     @org.junit.jupiter.api.Test
    public void testCheckCellPhoneNumber_Incorrect() {
        System.out.println("checkCellPhoneNumber");
        String cellPhone = "0838968976";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkCellPhoneNumber(cellPhone);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerUser method, of class Login.
     */
    @org.junit.jupiter.api.Test
    public void testRegisterUser_Correct() {
        System.out.println("registerUser");
        String firstName = "Kyle";
        String lastName = "Cooper";
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String cellPhone = "+27838968976"; 
        Login instance = new Login();
        String expResult = "User registered successfully.";
        String result = instance.registerUser(username, password, cellPhone,firstName,lastName);
        assertEquals(expResult, result);
    }
    
    @org.junit.jupiter.api.Test
    public void testRegisterUser_UsernameIncorrect() {
        System.out.println("registerUser");
        String firstName = "Kyle";
        String lastName = "Cooper";
        String username = "kyle!!!!!!!!";
        String password = "Ch&&sec@ke99!";
        String cellPhone = "+27838968976"; 
        Login instance = new Login();
        String expResult = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        String result = instance.registerUser(username, password, cellPhone,firstName,lastName);
        assertEquals(expResult, result);
    }
    
    @org.junit.jupiter.api.Test
    public void testRegisterUser_PasswordIncorrect() {
        System.out.println("registerUser");
        String firstName = "Kyle";
        String lastName = "Cooper";
        String username = "kyl_1";
        String password = "password";
        String cellPhone = "+27838968976"; 
        Login instance = new Login();
        String expResult = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        String result = instance.registerUser(username, password, cellPhone,firstName,lastName);
        assertEquals(expResult, result);
    }
    
    @org.junit.jupiter.api.Test
    public void testRegisterUser_CellPhoneIncorrect() {
        System.out.println("registerUser");
        String firstName = "Kyle";
        String lastName = "Cooper";
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String cellPhone = "0838968976"; 
        Login instance = new Login();
        String expResult = "Cell phone number incorrectly formatted or does not contain international code.";
        String result = instance.registerUser(username, password, cellPhone,firstName,lastName);
        assertEquals(expResult, result);
    }
    /**
     * Test of loginUser method, of class Login.
     */
    @org.junit.jupiter.api.Test
    public void testLoginUser_Correct() {
        System.out.println("loginUser");
        String firstName = "Kyle";
        String lastName = "Cooper";
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String cellphone = "+27838968976";
        Login instance = new Login();
        instance.registerUser(username, password,cellphone,firstName,lastName);
        boolean expResult = true;
        boolean result = instance.loginUser(username, password);
        assertEquals(expResult, result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLoginUser_Incorrect() {
        System.out.println("loginUser");
        String firstName = "Kyle";
        String lastName = "Cooper";
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String cellphone = "+27838968976";
        Login instance = new Login();
        instance.registerUser(username, password,cellphone,firstName,lastName);
        boolean expResult = false;
        boolean result = instance.loginUser("wrong", "wrong");
        assertEquals(expResult, result);
    }
    /**
     * Test of returnLoginStatus method, of class Login.
     */
    @org.junit.jupiter.api.Test
    public void testReturnLoginStatus_Success() {
        System.out.println("returnLoginStatus");
        String firstName = "Kyle";
        String lastName = "Smith";
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String cellphone = "+27838968976";
        Login instance = new Login();
        instance.registerUser(username, password, cellphone,firstName,lastName);
        String expResult = "Welcome Kyle Smith it is great to see you again.";
        String result = instance.returnLoginStatus(username, password);
        assertEquals(expResult, result);
        
    }
    
    @org.junit.jupiter.api.Test
    public void testReturnLoginStatus_Unsuccessful() {
        System.out.println("returnLoginStatus");
        String firstName = "Kyle";
        String lastName = "Smith";
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String cellphone = "+27838968976";
        Login instance = new Login();
        instance.registerUser(username, password, cellphone,firstName,lastName);
        String expResult = "Username or password incorrect, please try again.";
        String result = instance.returnLoginStatus("wrong", "wrong");
        assertEquals(expResult, result);
        
    }
    
}
