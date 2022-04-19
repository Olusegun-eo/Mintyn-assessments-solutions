package africa.semicolon.ewaApplication.data.dtos.requests;

import lombok.Data;

@Data
public class LoginUserRequest {
    private String userEmail;
    private String userPhoneNumber;
    private String password;
}
