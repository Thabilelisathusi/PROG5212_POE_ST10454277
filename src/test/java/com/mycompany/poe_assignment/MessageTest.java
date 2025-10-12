/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe_assignment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;


public class MessageTest {
    
    private Message message1;
    private Message message2;

    @BeforeEach
    void setUp() {
        // Clear previous messages before each test
        Message.clearAllMessages();

        // Message 1 (valid)
        message1 = new Message(1, "+27718693002", "Hi Mike, can you join us for dinner tonight");
        
        // Message 2 (invalid recipient format)
        message2 = new Message(2, "08575975889", "Hi Keegan, did you receive the payment?");
    }
    /**
     * Test of checkMessageID method, of class Message.
     */
    @Test
    public void testCheckMessageID_Successful() {
        System.out.println("checkMessageID");
        Message instance = new Message(1,"+27718693002","Hi Mike, can you join us for dinner tonight " );
        boolean expResult = true;
        boolean result = instance.checkMessageID();
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckMessageID_Unsuccessful() {
        System.out.println("checkMessageID");
        Message instance = new Message(2,"08575975889 ","Hi Keegan, did you receive the payment?" );
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
        Message longMessage = new Message(3, "+27821234567", longText);
        assertFalse(longMessage.checkMessageLength());

        int excess = longText.length() - 250;
        String expected = "Message exceeds 250 characters by " + excess + ", please reduce size.";
        String actual = longMessage.checkMessageLength()
                ? "Message ready to send."
                : "Message exceeds 250 characters by " + excess + ", please reduce size.";
        assertEquals(expected, actual);
    }
   
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

}
