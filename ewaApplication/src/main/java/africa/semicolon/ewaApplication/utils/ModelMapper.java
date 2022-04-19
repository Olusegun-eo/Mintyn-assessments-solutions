package africa.semicolon.ewaApplication.utils;

import africa.semicolon.ewaApplication.data.dtos.requests.LoginUserRequest;
import africa.semicolon.ewaApplication.data.dtos.requests.RegisterUserRequest;
import africa.semicolon.ewaApplication.data.dtos.responses.LoginUserResponse;
import africa.semicolon.ewaApplication.data.dtos.responses.RegisterUserResponse;
import africa.semicolon.ewaApplication.data.models.LoginUser;
import africa.semicolon.ewaApplication.data.models.RegisterUser;

public class ModelMapper {

    public static RegisterUser map(RegisterUserRequest registerUserRequest){
        RegisterUser aUser = new RegisterUser();

//        aUser.setUserId(registerUserRequest.getUserId());
        aUser.setUserPhoneNumber(registerUserRequest.getUserPhoneNumber());
        aUser.setUserFirstName(registerUserRequest.getUserFirstName());
        aUser.setUserLastName(registerUserRequest.getUserLastName());
        aUser.setUserEmail(registerUserRequest.getUserEmail());
//        aUser.setUserDate(registerUserRequest.getUserDate());
        return aUser;
    }

    public static RegisterUserResponse map(RegisterUser savedUser){
        RegisterUserResponse response = new RegisterUserResponse();
//        response.setUserId(savedUser.getUserId());
        response.setUserFirstName(savedUser.getUserFirstName());
        response.setUserLastName(savedUser.getUserLastName());
        response.setUserEmail(savedUser.getUserEmail());
        response.setUserPhoneNumber(savedUser.getUserPhoneNumber());

//        response.setDateTime(savedUser.getUserDate());
        return response;
    }




}
