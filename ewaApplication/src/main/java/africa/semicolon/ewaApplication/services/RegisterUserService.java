package africa.semicolon.ewaApplication.services;

import africa.semicolon.ewaApplication.data.dtos.requests.RegisterUserRequest;
import africa.semicolon.ewaApplication.data.dtos.responses.RegisterUserResponse;
import africa.semicolon.ewaApplication.data.models.RegisterUser;

import java.util.List;
import java.util.Optional;

public interface RegisterUserService {
    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);
    RegisterUser findUserWithId(Integer userId);
    List<RegisterUser> getAllRegisterUsers();
    void deleteAllUsers();
}
