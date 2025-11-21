
package com.mycompany.poe_assignment;
import javax.swing.JOptionPane;

public class POE_Assignment {
    private static Login user = new Login(); // Using default constructor
    private static boolean isLoggedIn = false;
    
    public static void main(String[] args) {
<<<<<<< HEAD
          // Load stored messages and populate test data for Part 3
       // Message.readStoredMessagesFromJSON();
       // Message.populateTestData();
=======
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
        
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
<<<<<<< HEAD
        String[] options = {"1. Send Messages", "2. Show recently sent messages","3.Quit"};
        //int choice = JOptionPane.showOptionDialog(null, "Welcome " + user.getFirstName() + "! Please select an option:", 
               // "QuickChat Main Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
       
        
           int choice = Integer.parseInt(JOptionPane.showInputDialog(null, options,"QuickChat Main Menu" ,JOptionPane.PLAIN_MESSAGE));
        
           switch (choice) {
            case 1: // Send Messages
                    sendMessages();
                    break;
                case 2: // Show recently sent messages
                    showReportsMenu();
                    break;
                case 3: // Quit
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                    break;
        }
    }
    
    private static void showReportsMenu() {
        String menuText = "MESSAGE REPORTS\nPlease select an option:\n"
                + "1. Show Sent Messages with Recipients\n"
                + "2. Show Longest Message\n"
                + "3. Search by Message ID\n"
                + "4. Search by Recipient\n"
                + "5. Delete Message by Hash\n"
                + "6. Display Full Report\n"
                + "7. Back to Main Menu";

        String choiceStr = JOptionPane.showInputDialog(null, menuText, "Message Reports", JOptionPane.PLAIN_MESSAGE);

        if (choiceStr == null) {
            return;
        }

        try {
            int choice = Integer.parseInt(choiceStr);

            switch (choice) {
                case 1: // Show Sent Messages with Recipients
                    String sentMessages = Message.displaySentMessagesWithRecipients();
                    JOptionPane.showMessageDialog(null, sentMessages);
                    break;

                case 2: // Show Longest Message
                    String longestMessage = Message.displayLongestMessage();
                    JOptionPane.showMessageDialog(null, longestMessage);
                    break;

                case 3: // Search by Message ID
                    String searchID = JOptionPane.showInputDialog("Enter Message ID to search:");
                    if (searchID != null && !searchID.trim().isEmpty()) {
                        String result = Message.searchByMessageID(searchID.trim());
                        JOptionPane.showMessageDialog(null, result);
                    }
                    break;

                case 4: // Search by Recipient
                    String recipient = JOptionPane.showInputDialog("Enter recipient number to search:");
                    if (recipient != null && !recipient.trim().isEmpty()) {
                        String result = Message.searchByRecipient(recipient.trim());
                        JOptionPane.showMessageDialog(null, result);
                    }
                    break;

                case 5: // Delete Message by Hash
                    String hash = JOptionPane.showInputDialog("Enter Message Hash to delete:");
                    if (hash != null && !hash.trim().isEmpty()) {
                        String result = Message.deleteByMessageHash(hash.trim());
                        JOptionPane.showMessageDialog(null, result);
                    }
                    break;

                case 6: // Display Full Report
                    String fullReport = Message.displayFullReport();
                    JOptionPane.showMessageDialog(null, fullReport);
                    break;

                case 7: // Back to Main Menu
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                    break;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number (1-7).");
=======
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
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
    }
}
//    private static void showRecentMessages() {
//        String recentMessages = Message.printMessages();
//        JOptionPane.showMessageDialog(null, recentMessages.isEmpty() ? 
//            "No messages sent yet." : recentMessages);
//    }
    
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
            Message msg = new Message(recipient, messageText);
            
            // Validate message length
            if (!msg.checkMessageLength()) {
                JOptionPane.showMessageDialog(null, msg.getMessageLengthValidation());
                continue;
            }
            
            // Validate recipient number
            if (!msg.checkRecipientCell()) {
                JOptionPane.showMessageDialog(null, msg.getRecipientValidation());
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
