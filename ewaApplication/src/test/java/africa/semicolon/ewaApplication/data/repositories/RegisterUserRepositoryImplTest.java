package africa.semicolon.ewaApplication.data.repositories;

import africa.semicolon.ewaApplication.data.models.RegisterUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterUserRepositoryImplTest {
    RegisterUserRepository registerUserRepository;
    @BeforeEach
    void setUp() {
        registerUserRepository = new RegisterUserRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        RegisterUser user = new RegisterUser();
        user.setUserId(0001);
        user.setUserFirstName("Tolu");
        user.setUserLastName("Olusegun");
        user.setUserEmail("tolu@gmail.com");
        user.setUserPhoneNumber("08039522075");
        user.setUserAddress("312, harbert Macaulay way, Sabo, yaba");

        RegisterUser savedUser = registerUserRepository.save(user);
        assertEquals(1, savedUser.getUserId());
    }

    @Test
    void findAll() {
        RegisterUser user = new RegisterUser();
        user.setUserId(0001);
        user.setUserFirstName("Tolu");
        user.setUserLastName("Olusegun");
        user.setUserEmail("tolu@gmail.com");
        user.setUserPhoneNumber("08039522075");
        user.setUserAddress("312, harbert Macaulay way, Sabo, yaba");

        RegisterUser savedUser = registerUserRepository.save(user);
        assertEquals(1, registerUserRepository.findById().size());
    }

    @Test
    void delete() {
        RegisterUser user = new RegisterUser();
        user.setUserId(0001);
        user.setUserFirstName("Tolu");
        user.setUserLastName("Olusegun");
        user.setUserEmail("tolu@gmail.com");
        user.setUserPhoneNumber("08039522075");
        user.setUserAddress("312, harbert Macaulay way, Sabo, yaba");

        RegisterUser savedUser = registerUserRepository.save(user);
        assertEquals(1, registerUserRepository.findById().size());

        registerUserRepository.delete(user);
        assertEquals(1, registerUserRepository.findById().size());
    }

    @Test
    void testDelete() {
        RegisterUser user = new RegisterUser();
        user.setUserId(0001);
        user.setUserFirstName("Tolu");
        user.setUserLastName("Olusegun");
        user.setUserEmail("tolu@gmail.com");
        user.setUserPhoneNumber("08039522075");
        user.setUserAddress("312, harbert Macaulay way, Sabo, yaba");

        RegisterUser savedUser = registerUserRepository.save(user);
        assertEquals(1, registerUserRepository.findById().size());
    }

    @Test
    void findUserById() {

    }
}