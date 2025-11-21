/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_assignment;

<<<<<<< HEAD
=======

>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
import java.util.Random;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Message {
<<<<<<< HEAD

=======
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;
    private String status; // sent, stored, disregarded
<<<<<<< HEAD

    private static int totalMessages = 0;
   
=======
    
    private static int totalMessages = 0;
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
    private static ArrayList<Message> sentMessages = new ArrayList<>();
    private static ArrayList<Message> disregardedMessages = new ArrayList<>();
    private static ArrayList<Message> storedMessages = new ArrayList<>();
    private static ArrayList<String> messageHashes = new ArrayList<>();
    private static ArrayList<String> messageIDs = new ArrayList<>();
<<<<<<< HEAD
    private static ArrayList<String> recipients = new ArrayList<>();
    private static ArrayList<String> messages = new ArrayList<>();
    private static ArrayList<String> flags = new ArrayList<>();

    // Constructor
    public Message(String recipient, String messageText) {
=======
    
    // Constructor
    public Message(int messageNumber, String recipient, String messageText) {
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
        this.messageNumber = messageNumber++;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }
<<<<<<< HEAD

=======
    
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
    // Check message ID length (max 10 characters)
    public boolean checkMessageID() {
        return messageID != null && messageID.length() <= 10;
    }
<<<<<<< HEAD

=======
    
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
    // Check recipient cell number format
    public boolean checkRecipientCell() {
        // Reuse the regex from Login class for phone number validation
        String regex = "^\\+27[0-9]{9}$";
        return recipient != null && recipient.matches(regex);
    }
<<<<<<< HEAD

=======
    
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
    // Create message hash using string manipulation
    public String createMessageHash() {
        if (messageID == null || messageText == null) {
            return "00:0:ERROR";
        }
<<<<<<< HEAD

        // Get first two characters of message ID
        String firstTwo = messageID.length() >= 2 ? messageID.substring(0, 2) : messageID;

=======
        
        // Get first two characters of message ID
        String firstTwo = messageID.length() >= 2 ? messageID.substring(0, 2) : messageID;
        
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
        // Get first and last words from message
        String[] words = messageText.split("\\s+");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 1 ? words[words.length - 1] : firstWord;
<<<<<<< HEAD

        // Format: firstTwoID:messageNumber:firstWordlastWord (all uppercase)
        return (firstTwo + ":" + messageNumber + ":" + firstWord + lastWord).toUpperCase();
    }

=======
        
        
        // Format: firstTwoID:messageNumber:firstWordlastWord (all uppercase)
        return (firstTwo + ":" + messageNumber + ":" + firstWord + lastWord).toUpperCase();
    }
    
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
    // Check if message length is valid (max 250 characters)
    public boolean checkMessageLength() {
        return messageText != null && messageText.length() <= 250;
    }
<<<<<<< HEAD

=======
    
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
    // Get message length validation message
    public String getMessageLengthValidation() {
        if (checkMessageLength()) {
            return "Message sent.";
        } else {
            return "Please enter a message of less than 250 characters";
        }
    }
<<<<<<< HEAD

=======
    
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
    // Get recipient validation message
    public String getRecipientValidation() {
        if (checkRecipientCell()) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }
<<<<<<< HEAD

=======
    
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
    // Send message with options
    public String sentMessage(int option) {
        switch (option) {
            case 1: // Send
                status = "Send Message";
                sentMessages.add(this);
                messageHashes.add(this.messageHash);
                messageIDs.add(this.messageID);
<<<<<<< HEAD
                recipients.add(this.recipient);
                messages.add(this.messageText);
                flags.add("sent");
=======
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
                totalMessages++;
                return "Message successfully sent.";
            case 2: // Disregard
                status = "Disregard Message";
                disregardedMessages.add(this);
<<<<<<< HEAD
                messages.add(this.messageText);
                flags.add("disregarded");
=======
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
                return "Press 0 to delete message.";
            case 3: // Store
                status = "Store Message to send later";
                storedMessages.add(this);
<<<<<<< HEAD
                recipients.add(this.recipient);
                messages.add(this.messageText);
                flags.add("stored");
=======
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
                storeMessage();
                return "Message successfully stored.";
            default:
                return "Invalid option.";
        }
    }
<<<<<<< HEAD

=======
    
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
    // Print all sent messages
    public static String printMessages() {
        if (sentMessages.isEmpty()) {
            return "No messages sent yet.";
        }
<<<<<<< HEAD

        StringBuilder sb = new StringBuilder();
        for (Message msg : sentMessages) {
            sb.append("Message ID: ").append(msg.messageID)
                    .append(", Hash: ").append(msg.messageHash)
                    .append(", Recipient: ").append(msg.recipient)
                    .append(", Message: ").append(msg.messageText)
                    .append("\n");
        }
        return sb.toString();
    }

=======
        
        StringBuilder sb = new StringBuilder();
        for (Message msg : sentMessages) {
            sb.append("Message ID: ").append(msg.messageID)
              .append(", Hash: ").append(msg.messageHash)
              .append(", Recipient: ").append(msg.recipient)
              .append(", Message: ").append(msg.messageText)
              .append("\n");
        }
        return sb.toString();
    }
    
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
    // Return total number of sent messages
    public static int returnTotalMessages() {
        return totalMessages;
    }
<<<<<<< HEAD

=======
    
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
    // Store message in JSON file (using ChatGPT for JSON handling)
    // Reference: JSON handling approach suggested by ChatGPT
    public void storeMessage() {
        try {
            JSONObject messageJson = new JSONObject();
            messageJson.put("messageID", messageID);
            messageJson.put("messageNumber", messageNumber);
            messageJson.put("recipient", recipient);
            messageJson.put("messageText", messageText);
            messageJson.put("messageHash", messageHash);
            messageJson.put("status", status);
<<<<<<< HEAD

            // Read existing file or create new one
            File file = new File("messages.json");
            JSONArray jsonArray;

=======
            
            // Read existing file or create new one
            File file = new File("messages.json");
            JSONArray jsonArray;
            
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
            if (file.exists() && file.length() > 0) {
                String content = new String(Files.readAllBytes(Paths.get("messages.json")));
                jsonArray = new JSONArray(content);
            } else {
                jsonArray = new JSONArray();
            }
<<<<<<< HEAD

            // Add new message
            jsonArray.put(messageJson);

=======
            
            // Add new message
            jsonArray.put(messageJson);
            
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
            // Write back to file
            Files.write(Paths.get("messages.json"), jsonArray.toString().getBytes());
        } catch (IOException e) {
            System.err.println("Error storing message: " + e.getMessage());
        }
    }
<<<<<<< HEAD

    public static String displaySentMessagesWithRecipients() {
        StringBuilder result = new StringBuilder("SENT MESSAGES WITH RECIPIENTS:\n");
        for (int i = 0; i < flags.size(); i++) {
            if (flags.get(i).equalsIgnoreCase("sent")) {
                result.append("To: ").append(recipients.get(i))
                        .append(" | Message: ").append(messages.get(i)).append("\n");
            }
        }
        return result.toString();
    }

    public static String displayLongestMessage() {
        String longestMessage = "";
        for (int i = 0; i < flags.size(); i++) {
            if (flags.get(i).equalsIgnoreCase("sent")
                    && messages.get(i).length() > longestMessage.length()) {
                longestMessage = messages.get(i);
            }
        }
        return "Longest sent message: "
                + (longestMessage.isEmpty() ? "No sent messages" : longestMessage);
    }

    public static String searchByMessageID(String searchID) {
        for (int i = 0; i < messageIDs.size(); i++) {
            if (messageIDs.get(i).equals(searchID)) {
                return "Message ID: " + searchID
                        + "\nRecipient: " + recipients.get(i)
                        + "\nMessage: " + messages.get(i);
            }
        }
        return "Message ID not found: " + searchID;
    }

    public static String searchByRecipient(String searchRecipient) {
        StringBuilder result = new StringBuilder("Messages for " + searchRecipient + ":\n");
        boolean found = false;

        for (int i = 0; i < recipients.size(); i++) {
            if (recipients.get(i).equals(searchRecipient)) {
                result.append("- ").append(messages.get(i))
                        .append(" [").append(flags.get(i)).append("]\n");
                found = true;
            }
        }

        return found ? result.toString() : "No messages found for: " + searchRecipient;
    }

    public static String deleteByMessageHash(String hashToDelete) {
        for (int i = 0; i < messageHashes.size(); i++) {
            if (messageHashes.get(i).equals(hashToDelete)) {
                String deletedMessage = messages.get(i);
                String flag = flags.get(i);

                // Remove from all arrays
                messageIDs.remove(i);
                messageHashes.remove(i);
                recipients.remove(i);
                messages.remove(i);
                flags.remove(i);

                // Remove from Message object arrays
                switch (flag.toLowerCase()) {
                    case "sent":
                        sentMessages.removeIf(msg -> msg.getMessageHash().equals(hashToDelete));
                        totalMessages--;
                        break;
                    case "disregarded":
                        disregardedMessages.removeIf(msg -> msg.getMessageHash().equals(hashToDelete));
                        break;
                    case "stored":
                        storedMessages.removeIf(msg -> msg.getMessageHash().equals(hashToDelete));
                        break;
                }

                return "Message \"" + deletedMessage + "\" successfully deleted.";
            }
        }
        return "Message hash not found: " + hashToDelete;
    }

    public static String displayFullReport() {
        StringBuilder report = new StringBuilder("FULL MESSAGE REPORT - SENT MESSAGES\n");
        report.append("=====================================\n");

        for (int i = 0; i < flags.size(); i++) {
            if (flags.get(i).equalsIgnoreCase("sent")) {
                report.append("Message Hash: ").append(messageHashes.get(i)).append("\n")
                        .append("Recipient: ").append(recipients.get(i)).append("\n")
                        .append("Message: ").append(messages.get(i)).append("\n")
                        .append("Message ID: ").append(messageIDs.get(i)).append("\n")
                        .append("-------------------------------------\n");
            }
        }

        return report.toString();
    }

    // Read JSON file into stored messages array (ChatGPT assisted)
    public static void readStoredMessagesFromJSON() {
        try {
            File file = new File("messages.json");
            if (!file.exists()) {
                return;
            }

            String content = new String(Files.readAllBytes(Paths.get("messages.json")));
            JSONArray jsonArray = new JSONArray(content);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonMessage = jsonArray.getJSONObject(i);
                String recipient = jsonMessage.getString("recipient");
                String messageText = jsonMessage.getString("messageText");
                String status = jsonMessage.getString("status");

                // Add to arrays
                recipients.add(recipient);
                messages.add(messageText);
                flags.add(status);

                if (jsonMessage.has("messageID")) {
                    messageIDs.add(jsonMessage.getString("messageID"));
                }
                if (jsonMessage.has("messageHash")) {
                    messageHashes.add(jsonMessage.getString("messageHash"));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading stored messages: " + e.getMessage());
        }
    }

=======
    
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
    // Generate random message ID (10 digits)
    private String generateMessageID() {
        Random rand = new Random();
        // Generate 10-digit number
<<<<<<< HEAD
        long num = 1000000000L + (long) (rand.nextDouble() * 9000000000L);
        return String.valueOf(num);
    }

    // Display message details in required order
    public String displayMessageDetails() {
        return "MessageID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipient
                + "\nMessage: " + messageText;
    }

    // Getters
    public String getMessageID() {
        return messageID;
    }

    public int getMessageNumber() {
        return messageNumber;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public String getStatus() {
        return status;
    }

    // Array getters
    public static ArrayList<Message> getSentMessages() {
        return sentMessages;
    }

    public static ArrayList<Message> getDisregardedMessages() {
        return disregardedMessages;
    }

    public static ArrayList<Message> getStoredMessages() {
        return storedMessages;
    }

    public static ArrayList<String> getMessageHashes() {
        return messageHashes;
    }

    public static ArrayList<String> getMessageIDs() {
        return messageIDs;
    }

    public static ArrayList<String> getRecipients() {
        return recipients;
    }
    
    public static ArrayList<String> getMessages() {
        return messages;
    }
    
    public static ArrayList<String> getFlags() {
        return flags;
    }
=======
        long num = 1000000000L + (long)(rand.nextDouble() * 9000000000L);
        return String.valueOf(num);
    }
    
    // Display message details in required order
    public String displayMessageDetails() {
        return "MessageID: " + messageID + 
               "\nMessage Hash: " + messageHash +
               "\nRecipient: " + recipient +
               "\nMessage: " + messageText;
    }
    
    // Getters
    public String getMessageID() { return messageID; }
    public int getMessageNumber() { return messageNumber; }
    public String getRecipient() { return recipient; }
    public String getMessageText() { return messageText; }
    public String getMessageHash() { return messageHash; }
    public String getStatus() { return status; }
    
    // Array getters
    public static ArrayList<Message> getSentMessages() { return sentMessages; }
    public static ArrayList<Message> getDisregardedMessages() { return disregardedMessages; }
    public static ArrayList<Message> getStoredMessages() { return storedMessages; }
    public static ArrayList<String> getMessageHashes() { return messageHashes; }
    public static ArrayList<String> getMessageIDs() { return messageIDs; }
    
    
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
    // Clear all messages (for testing)
    public static void clearAllMessages() {
        sentMessages.clear();
        disregardedMessages.clear();
        storedMessages.clear();
        messageHashes.clear();
        messageIDs.clear();
<<<<<<< HEAD
        recipients.clear();
        messages.clear();
        flags.clear();
=======
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
        totalMessages = 0;
    }
}
