/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe_assignment;

<<<<<<< HEAD
import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
=======
import java.util.Locale;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
import org.junit.jupiter.api.BeforeEach;


public class MessageTest {
    
    private Message message1;
    private Message message2;

    @BeforeEach
    void setUp() {
        // Clear previous messages before each test
        Message.clearAllMessages();

        // Message 1 (valid)
<<<<<<< HEAD
        message1 = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight");
        
        // Message 2 (invalid recipient format)
        message2 = new Message( "08575975889", "Hi Keegan, did you receive the payment?");
=======
        message1 = new Message(1, "+27718693002", "Hi Mike, can you join us for dinner tonight");
        
        // Message 2 (invalid recipient format)
        message2 = new Message(2, "08575975889", "Hi Keegan, did you receive the payment?");
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
    }
    /**
     * Test of checkMessageID method, of class Message.
     */
    @Test
    public void testCheckMessageID_Successful() {
        System.out.println("checkMessageID");
<<<<<<< HEAD
        Message instance = new Message("+27718693002","Hi Mike, can you join us for dinner tonight " );
=======
        Message instance = new Message(1,"+27718693002","Hi Mike, can you join us for dinner tonight " );
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
        boolean expResult = true;
        boolean result = instance.checkMessageID();
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckMessageID_Unsuccessful() {
        System.out.println("checkMessageID");
<<<<<<< HEAD
        Message instance = new Message("08575975889 ","Hi Keegan, did you receive the payment?" );
=======
        Message instance = new Message(2,"08575975889 ","Hi Keegan, did you receive the payment?" );
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
        boolean expResult = false;
        boolean result = instance.checkMessageID();
        assertEquals(expResult, result);
    }
    /**
     * Test of checkRecipientCell method, of class Message.
     */
    @Test
    public void testCheckRecipientCell_Success() {
        System.out.println("checkRecipientCell");
        assertTrue(message1.checkRecipientCell());
        assertEquals("Cell phone number successfully captured.", message1.getRecipientValidation());
    }

    @Test
    void testCheckRecipientNumber_Failure() {
        assertFalse(message2.checkRecipientCell());
        assertEquals(
            "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
            message2.getRecipientValidation()
        );
    }
    /**
     * Test of createMessageHash method, of class Message.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
         // message1 hash = firstTwoID:messageNumber:firstWord+lastWord (uppercase)
        String hash = message1.createMessageHash();
        assertTrue(hash.contains(":1:"));
        assertEquals((message1.getMessageID().substring(0, 2) + ":1:HITONIGHT").toUpperCase(), hash);
    }
<<<<<<< HEAD
=======
    
    @Test
    public void testGenerateMessageID(){
        assertNotNull(message1.getMessageID());
        assertTrue(message1.getMessageID().length() <= 10);
        System.out.printf("Message ID generated: "+ message1.getMessageID());
    }
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1

    /**
     * Test of checkMessageLength method, of class Message.
     */
    @Test
    public void testCheckMessageLength_Success() {
        System.out.println("checkMessageLength");
        String expResult = "Message sent.";
        assertTrue(message1.checkMessageLength());
        assertEquals(expResult, message1.getMessageLengthValidation());
    }
    
    @Test
    public void testCheckMessageLength_Failure() {
        String longText = "A".repeat(260);
<<<<<<< HEAD
        Message longMessage = new Message( "+27821234567", longText);
=======
        Message longMessage = new Message(3, "+27821234567", longText);
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
        assertFalse(longMessage.checkMessageLength());

        int excess = longText.length() - 250;
        String expected = "Message exceeds 250 characters by " + excess + ", please reduce size.";
        String actual = longMessage.checkMessageLength()
                ? "Message ready to send."
                : "Message exceeds 250 characters by " + excess + ", please reduce size.";
        assertEquals(expected, actual);
    }
<<<<<<< HEAD
    
    @Test
    public void testGenerateMessageID(){
        assertNotNull(message1.getMessageID());
        assertTrue(message1.getMessageID().length() <= 10);
        System.out.println("Message ID generated: " + message1.getMessageID());
    }
=======
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
   
    /**
     * Test of sentMessage method, of class Message.
     */
    @Test
    public void testSentMessage() {
        System.out.println("sentMessage");
        String result = message1.sentMessage(1);
        assertEquals("Message successfully sent.", result);
        assertEquals(1, Message.returnTotalMessages());
    }

    /**
     * Test of returnTotalMessages method, of class Message.
     */
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        int expResult = 1;
        message1.sentMessage(1);
        message2.sentMessage(2);
        int result = Message.returnTotalMessages();
        assertEquals(expResult, result);
    }

    /**
     * Test of storeMessage method, of class Message.
     */
    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        String result = message1.sentMessage(3);
        assertEquals("Message successfully stored.", result);
        assertEquals(0, Message.returnTotalMessages());   
    }

        @Test
    public void testDisregardMessage() {
        String result = message2.sentMessage(2);
        String expected = "Press 0 to delete message.";
        assertEquals(expected, result);
    }

<<<<<<< HEAD
    /*===========Part 3 Tests===========================*/
    // Test data population method for Part 3
    private void populateTestData() {
        Message.clearAllMessages();
        
        // Test Data from Part 3 requirements
        String[][] testData = {
            {"+27834557896", "Did you get the cake?", "sent"},
            {"+27838884567", "Where are you? You are late! I have asked you to be on time.", "stored"},
            {"+27834484567", "Yohoooo, I am at your gate.", "disregarded"},
            {"0838884567", "It is dinner time!", "sent"},
            {"+27838884567", "Ok, I am leaving without you.", "stored"}
        };
        
        // Manually populate the arrays that Message class uses
        for (String[] data : testData) {
            // Add to recipient array
            Message.getRecipients().add(data[0]);
            // Add to messages array
            Message.getMessages().add(data[1]);
            // Add to flags array
            Message.getFlags().add(data[2]);
            
            
            // Also create Message objects and add to appropriate arrays
            Message msg = new Message(data[0], data[1]);
            switch(data[2]) {
                case "sent":
                    Message.getSentMessages().add(msg);
                    break;
                case "stored":
                    Message.getStoredMessages().add(msg);
                    break;
                case "disregarded":
                    Message.getDisregardedMessages().add(msg);
                    break;
            }
        }
    }
        
    @Test
    public void testDisplaySentMessagesWithRecipients() {
        populateTestData();
        String result = Message.displaySentMessagesWithRecipients();
        assertTrue(result.contains("SENT MESSAGES WITH RECIPIENTS"));
        assertTrue(result.contains("+27834557896"));
        assertTrue(result.contains("Did you get the cake?"));
        assertTrue(result.contains("It is dinner time!"));
    }

    @Test
    public void testDisplayLongestMessage() {
        populateTestData();
        String result = Message.displayLongestMessage();
        assertTrue(result.contains("Longest sent message: "));
        assertTrue(result.contains("Where are you? You are late! I have asked you to be on time."));
    }

    @Test
    public void testSearchByMessageID() {
        populateTestData();
         if (!Message.getMessageIDs().isEmpty()) {
            String messageID = Message.getMessageIDs().get(0);
            String result = Message.searchByMessageID(messageID);
            assertTrue(result.contains("Message ID: " + messageID));
        }
    }

    @Test
    public void testSearchByMessageIDNotFound() {
        populateTestData();
        String result = Message.searchByMessageID("NONEXISTENT123");
        assertTrue(result.contains("Message ID not found"));
    }
    
    @Test
    public void testSearchByRecipientNotFound() {
        populateTestData();
        String result = Message.searchByRecipient("+27000000000");
        assertTrue(result.contains("No messages found for"));
    }

    @Test
    public void testSearchByRecipient() {
        populateTestData();
        String result = Message.searchByRecipient("+27838884567");
        
        assertTrue(result.contains("Messages for +27838884567"));
        assertTrue(result.contains("Where are you? You are late!"));
        assertTrue(result.contains("Ok, I am leaving without you"));
    }

    @Test
    public void testDeleteByMessageHash() {
         populateTestData();
        
        if (!Message.getMessageHashes().isEmpty()) {
            String messageHash = Message.getMessageHashes().get(0);
            int initialSize = Message.getMessageHashes().size();
            
            String result = Message.deleteByMessageHash(messageHash);
            assertTrue(result.contains("successfully deleted"));
            assertEquals(initialSize - 1, Message.getMessageHashes().size());
        }
    }

     @Test
    public void testDeleteByMessageHashNotFound() {
        populateTestData();
        String result = Message.deleteByMessageHash("NONEXISTENT:HASH");
        assertTrue(result.contains("Message hash not found"));
    }

=======
>>>>>>> a301cfd41b22f6075c41ecea587e1a7df791b6b1
}
