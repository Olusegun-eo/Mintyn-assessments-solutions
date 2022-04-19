package africa.semicolon.ewaApplication.services;

import africa.semicolon.ewaApplication.data.dtos.requests.RegisterUserRequest;
import africa.semicolon.ewaApplication.data.dtos.responses.RegisterUserResponse;
import africa.semicolon.ewaApplication.data.exceptions.DuplicateUserException;
import africa.semicolon.ewaApplication.data.exceptions.UserDoesNotExistException;
import africa.semicolon.ewaApplication.data.models.RegisterUser;
import africa.semicolon.ewaApplication.data.repositories.RegisterUserRepository;
import africa.semicolon.ewaApplication.data.repositories.RegisterUserRepositoryImpl;
import africa.semicolon.ewaApplication.utils.ModelMapper;

import java.util.List;
import java.util.Optional;

public class RegisterUserServiceImpl implements RegisterUserService {
    private static final RegisterUserRepository registerUserRepository = new RegisterUserRepositoryImpl();
    private final LoginUserService loginUserService = new LoginUserServiceImpl();

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        Optional<RegisterUser>registerDatabase = registerUserRepository.findUserById(registerUserRequest.getUserEmail());
        if (registerDatabase.isPresent()) throw new DuplicateUserException(registerUserRequest.getUserEmail() + "user already exist");

        RegisterUser aUser = ModelMapper.map(registerUserRequest);
        RegisterUser savedUser = registerUserRepository.save(aUser);

        RegisterUserResponse response = ModelMapper.map(savedUser);
        return response;
    }


    @Override
    public RegisterUser findUserWithId(Integer userId) {
        return registerUserRepository.findById(userId);
    }

    @Override
    public List<RegisterUser> getAllRegisterUsers() {
        return null;
    }

    @Override
    public void deleteAllUsers() {

    }

}



