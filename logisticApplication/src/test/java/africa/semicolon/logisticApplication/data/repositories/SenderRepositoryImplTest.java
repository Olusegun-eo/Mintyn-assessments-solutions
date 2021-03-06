package africa.semicolon.logisticApplication.data.repositories;

import africa.semicolon.logisticApplication.data.models.Sender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SenderRepositoryImplTest {
    SenderRepository senderRepository;

    @BeforeEach
    void setUp() {
        senderRepository = new SenderRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Sender sender = new Sender();
        sender.setSenderName("Jerry");
        sender.setEmailAddress("jerry@gmail.com");
        sender.setPhoneNumber("123456");

        Sender savedSender = senderRepository.save(sender);
        assertEquals(sender, savedSender);
        assertEquals(1, senderRepository.findAll().size());
    }


    public Sender saveSender(){

        Sender sender = new Sender();
        sender.setSenderName("Jerry");
        sender.setEmailAddress("jerry@gmail.com");
        sender.setPhoneNumber("123456");

        return senderRepository.save(sender);
    }

    @Test
    void findSenderByEmail() {
        Sender savedSender = saveSender();
        assertEquals(savedSender, senderRepository.findSenderByEmail(savedSender.getEmailAddress()).get());
    }

    @Test
    void delete() {
        Sender savedSender = saveSender();
        senderRepository.delete(savedSender.getEmailAddress());
        assertEquals(0, senderRepository.findAll().size());
    }

    @Test
    void testDelete() {
        Sender savedSender = saveSender();
        senderRepository.delete(savedSender);
        assertEquals(0, senderRepository.findAll().size());
    }
}


/*
package africa.semicolon.cheetah.data.repositories;

import africa.semicolon.cheetah.data.models.Sender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SenderRepositoryImplTest {
    SenderRepository senderRepository;

    @BeforeEach
    void setUp() {
        senderRepository = new SenderRepositoryImpl();
    }


    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Sender sender = new Sender();
        sender.setSenderName("Jerry");
        sender.setEmailAddress("jerry@email.com");
        sender.setPhoneNumber("09874284");

        Sender savedSender = senderRepository.save(sender);
        assertEquals(sender, savedSender);
        assertEquals(1, senderRepository.findAll().size());

    }
    public Sender saveSender(){
        Sender sender = new Sender();
        sender.setSenderName("Jerry");
        sender.setEmailAddress("jerry@email.com");
        sender.setPhoneNumber("09874284");

        return senderRepository.save(sender);
    }

    @Test
    void findSenderByEmail() {
        Sender savedSender = saveSender();
        assertEquals(savedSender, senderRepository.findSenderByEmail(saveSender().getEmailAddress()).get());
    }

    @Test
    void delete() {
        Sender savedSender = saveSender();
        senderRepository.delete(savedSender.getEmailAddress());
        assertEquals(0, senderRepository.findAll().size());
    }

    @Test
    void testDelete() {
        Sender savedSender = saveSender();
        senderRepository.delete(savedSender);
        assertEquals(0, senderRepository.findAll().size());
        assertTrue(senderRepository.findAll().isEmpty());
    }
}
 */