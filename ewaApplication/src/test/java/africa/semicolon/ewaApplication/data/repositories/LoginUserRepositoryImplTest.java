package africa.semicolon.ewaApplication.data.repositories;

import africa.semicolon.ewaApplication.data.models.LoginUser;
import africa.semicolon.ewaApplication.data.models.TrackingData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;

class LoginUserRepositoryImplTest {
    LoginUserRepository loginUserRepository;
    @BeforeEach
    void setUp() {
        loginUserRepository = new LoginUserRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        LoginUser loginUser = new LoginUser();
        loginUser.setUserLoginId(123456);

        TrackingData trackingData = new TrackingData("a new user", "08012345678", "Tolu", "Segun", "tolseg@mail.com", "321, harbert Macaulay");
        loginUser.getTrackingLogins().add(trackingData);
        LoginUser savedUserInfo = loginUserRepository.save(loginUser);

        assertEquals(savedUserInfo, loginUser);
        assertEquals(1, loginUserRepository.findAllUsers().size());
    }

    public LoginUser saveTestHelper() {
        LoginUser loginUser = new LoginUser();
        loginUser.setUserLoginId(123456);

        TrackingData trackingData = new TrackingData("a new user", "08012345678", "Tolu", "Segun", "tolseg@mail.com", "321, harbert Macaulay");
        loginUser.getTrackingLogins().add(trackingData);
        LoginUser savedUserInfo = loginUserRepository.save(loginUser);
        return savedUserInfo;
    }

    @Test
    void findAllUsers() {
        saveTestHelper();
        assertEquals(1, loginUserRepository.findAllUsers().size());
    }

    @Test
    void deleteAllUsers() {
        saveTestHelper();
        assertEquals(1, loginUserRepository.findAllUsers().size());
        loginUserRepository.deleteAllUsers();
        assertEquals(0, loginUserRepository.findAllUsers().size());
    }

    @Test
    void findUserById() {
        LoginUser savedLoginUser = saveTestHelper();
        Optional<LoginUser> optionalLoginUser = loginUserRepository.findUserById(savedLoginUser.getUserLoginId());
        assertTrue(optionalLoginUser.isPresent());
        assertEquals(savedLoginUser, optionalLoginUser.get());
    }

    @Test
    void delete() {
        LoginUser savedLoginUser = saveTestHelper();
        assertEquals(1, loginUserRepository.findAllUsers().size());
        loginUserRepository.delete(savedLoginUser.getUserLoginId());
        assertEquals(0, loginUserRepository.findAllUsers().size());
    }

    @Test
    void testDelete() {
        LoginUser savedLoginUser = saveTestHelper();
        assertEquals(1, loginUserRepository.findAllUsers().size());
        loginUserRepository.delete(savedLoginUser);
        assertEquals(0, loginUserRepository.findAllUsers().size());
    }
}