/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_assignment;


import java.util.Random;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Message {
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;
    private String status; // sent, stored, disregarded
    
    private static int totalMessages = 0;
    private static ArrayList<Message> sentMessages = new ArrayList<>();
    private static ArrayList<Message> disregardedMessages = new ArrayList<>();
    private static ArrayList<Message> storedMessages = new ArrayList<>();
    private static ArrayList<String> messageHashes = new ArrayList<>();
    private static ArrayList<String> messageIDs = new ArrayList<>();
    
    // Constructor
    public Message(int messageNumber, String recipient, String messageText) {
        this.messageNumber = messageNumber++;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }
    
    // Check message ID length (max 10 characters)
    public boolean checkMessageID() {
        return messageID != null && messageID.length() <= 10;
    }
    
    // Check recipient cell number format
    public boolean checkRecipientCell() {
        // Reuse the regex from Login class for phone number validation
        String regex = "^\\+27[0-9]{9}$";
        return recipient != null && recipient.matches(regex);
    }
    
    // Create message hash using string manipulation
    public String createMessageHash() {
        if (messageID == null || messageText == null) {
            return "00:0:ERROR";
        }
        
        // Get first two characters of message ID
        String firstTwo = messageID.length() >= 2 ? messageID.substring(0, 2) : messageID;
        
        // Get first and last words from message
        String[] words = messageText.split("\\s+");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 1 ? words[words.length - 1] : firstWord;
        
        
        // Format: firstTwoID:messageNumber:firstWordlastWord (all uppercase)
        return (firstTwo + ":" + messageNumber + ":" + firstWord + lastWord).toUpperCase();
    }
    
    // Check if message length is valid (max 250 characters)
    public boolean checkMessageLength() {
        return messageText != null && messageText.length() <= 250;
    }
    
    // Get message length validation message
    public String getMessageLengthValidation() {
        if (checkMessageLength()) {
            return "Message sent.";
        } else {
            return "Please enter a message of less than 250 characters";
        }
    }
    
    // Get recipient validation message
    public String getRecipientValidation() {
        if (checkRecipientCell()) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }
    
    // Send message with options
    public String sentMessage(int option) {
        switch (option) {
            case 1: // Send
                status = "Send Message";
                sentMessages.add(this);
                messageHashes.add(this.messageHash);
                messageIDs.add(this.messageID);
                totalMessages++;
                return "Message successfully sent.";
            case 2: // Disregard
                status = "Disregard Message";
                disregardedMessages.add(this);
                return "Press 0 to delete message.";
            case 3: // Store
                status = "Store Message to send later";
                storedMessages.add(this);
                storeMessage();
                return "Message successfully stored.";
            default:
                return "Invalid option.";
        }
    }
    
    // Print all sent messages
    public static String printMessages() {
        if (sentMessages.isEmpty()) {
            return "No messages sent yet.";
        }
        
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
    
    // Return total number of sent messages
    public static int returnTotalMessages() {
        return totalMessages;
    }
    
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
            
            // Read existing file or create new one
            File file = new File("messages.json");
            JSONArray jsonArray;
            
            if (file.exists() && file.length() > 0) {
                String content = new String(Files.readAllBytes(Paths.get("messages.json")));
                jsonArray = new JSONArray(content);
            } else {
                jsonArray = new JSONArray();
            }
            
            // Add new message
            jsonArray.put(messageJson);
            
            // Write back to file
            Files.write(Paths.get("messages.json"), jsonArray.toString().getBytes());
        } catch (IOException e) {
            System.err.println("Error storing message: " + e.getMessage());
        }
    }
    
    // Generate random message ID (10 digits)
    private String generateMessageID() {
        Random rand = new Random();
        // Generate 10-digit number
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
    
    
    // Clear all messages (for testing)
    public static void clearAllMessages() {
        sentMessages.clear();
        disregardedMessages.clear();
        storedMessages.clear();
        messageHashes.clear();
        messageIDs.clear();
        totalMessages = 0;
    }
}
