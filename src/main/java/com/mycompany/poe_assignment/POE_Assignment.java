
package com.mycompany.poe_assignment;
import javax.swing.JOptionPane;

public class POE_Assignment {
    private static Login user = new Login(); // Using default constructor
    private static boolean isLoggedIn = false;
    
    public static void main(String[] args) {
        
        // Display welcome message
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat");
        
        // Main menu loop - runs until user selects quit
        while (true) {
            if (!isLoggedIn) {
                showLoginMenu();
            } else {
                showMainMenu();
            }
        }
    }
    
    private static void showLoginMenu() {
        String[] options = {"Register", "Login", "Quit"};
        int choice = JOptionPane.showOptionDialog(null, "Please select an option:", "QuickChat Login",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        
        switch (choice) {
            case 0: // Register
                registerUser();
                break;
            case 1: // Login
                loginUser();
                break;
            case 2: // Quit
            case -1: // Window closed
                System.exit(0);
                break;
        }
    }
    
    private static void showMainMenu() {
        String[] options = {"1. Send Messages", "2. Show recently sent messages", "3. Quit"};
        //int choice = JOptionPane.showOptionDialog(null, "Welcome " + user.getFirstName() + "! Please select an option:", 
               // "QuickChat Main Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        
           int choice = Integer.parseInt(JOptionPane.showInputDialog(null, options,"QuickChat Main Menu" ,JOptionPane.PLAIN_MESSAGE));
        switch (choice) {
            case 1: // Send Messages
                sendMessages();
                break;
            case 2: // Show recently sent messages
                JOptionPane.showMessageDialog(null, "Coming Soon.");
                break;
            case 3: // Quit
            case -1: // Window closed
                System.exit(0);
                break;
        }
    }
    
    private static void registerUser() {
        String firstName = JOptionPane.showInputDialog("Enter your first name:");
        if (firstName == null) return; // User cancelled
        
        String lastName = JOptionPane.showInputDialog("Enter your last name:");
        if (lastName == null) return;
        
        String username = JOptionPane.showInputDialog("Enter username (must contain _ and be ≤5 characters):");
        if (username == null) return;
        
        String password = JOptionPane.showInputDialog("Enter password (≥8 chars, capital, number, special char):");
        if (password == null) return;
        
        String cellNumber = JOptionPane.showInputDialog("Enter cell number (+27 followed by 9 digits):");
        if (cellNumber == null) return;
        
        // Register user with all details at once
        String result = user.registerUser(username, password, cellNumber,firstName,lastName);
        JOptionPane.showMessageDialog(null, result);
    }
    
    private static void loginUser() {
        if (user.getUsername() == null) {
            JOptionPane.showMessageDialog(null, "Please register first.");
            return;
        }
        
        String username = JOptionPane.showInputDialog("Enter username:");
        if (username == null) return;
        
        String password = JOptionPane.showInputDialog("Enter password:");
        if (password == null) return;
        
        boolean loginSuccess = user.loginUser(username, password);
        String message = user.returnLoginStatus(username,password);
        JOptionPane.showMessageDialog(null, message);
        
        isLoggedIn = loginSuccess;
    }
    
    private static void sendMessages() {
        if (!isLoggedIn) {
            JOptionPane.showMessageDialog(null, "Please login first.");
            return;
        }
        
        // Get number of messages using loop counter
        String numMessagesStr = JOptionPane.showInputDialog("How many messages would you like to send?");
        if (numMessagesStr == null) return;
        
        int numMessages;
        try {
            numMessages = Integer.parseInt(numMessagesStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            return;
        }
        
        // For loop to enter specified number of messages
        for (int i = 1; i <= numMessages; i++) {
            JOptionPane.showMessageDialog(null, "Creating message " + i + " of " + numMessages);
            
            String recipient = JOptionPane.showInputDialog("Enter recipient's cell number for message " + i + ":\nFormat: +27 followed by 9 digits");
            if (recipient == null) {
                // User cancelled, skip this message
                continue;
            }
            
            String messageText = JOptionPane.showInputDialog("Enter your message (max 250 characters):");
            if (messageText == null) {
                // User cancelled, skip this message
                continue;
            }
            
            // Create message object
            Message msg = new Message(i, recipient, messageText);
            
            // Validate message length
            if (!msg.checkMessageLength()) {
                JOptionPane.showMessageDialog(null, msg.getMessageLengthValidation());
                i--; // Retry this message
                continue;
            }
            
            // Validate recipient number
            if (!msg.checkRecipientCell()) {
                JOptionPane.showMessageDialog(null, msg.getRecipientValidation());
                i--; // Retry this message
                continue;
            }
            
            // Display message details using JOptionPane
            String details = msg.displayMessageDetails();
            JOptionPane.showMessageDialog(null, details);
            
            // Ask for action with numeric options
            String[] options = {"Send Message", "Disregard Message", "Store Message to send later"};
            int action = JOptionPane.showOptionDialog(null, "What would you like to do with this message?",
                    "Message Action", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            
            if (action == -1) {
                // User closed the dialog, skip
                continue;
            }
            
            String result = msg.sentMessage(action + 1); // +1 to match our method's expected values
            JOptionPane.showMessageDialog(null, result);
        }
        
        // Display total messages sent
        JOptionPane.showMessageDialog(null, "Total messages sent in this session: " + Message.returnTotalMessages());
    }
}
