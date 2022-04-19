package africa.semicolon.ewaApplication.controllers;

import africa.semicolon.ewaApplication.data.dtos.requests.RegisterUserRequest;
import africa.semicolon.ewaApplication.data.dtos.responses.RegisterUserResponse;
import africa.semicolon.ewaApplication.data.exceptions.UserDoesNotExistException;
import africa.semicolon.ewaApplication.data.models.RegisterUser;
import africa.semicolon.ewaApplication.services.RegisterUserService;
import africa.semicolon.ewaApplication.services.RegisterUserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class RegisterController {

    private final RegisterUserService registerService = new RegisterUserServiceImpl();

    @PostMapping("/api/addUser")
    public ResponseEntity<?> addUser(@RequestBody RegisterUserRequest addRegisterRequest){

        try {
            RegisterUserResponse response = registerService.registerUser(addRegisterRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UserDoesNotExistException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/register{userId}")
    public Optional<RegisterUser> findUserByEmail(@PathVariable ("userId") String userEmail){
       return registerService.findUserByEmail(userEmail);
    }

}
