package africa.semicolon.ewaApplication.data.dtos.responses;


import lombok.Data;

import java.time.LocalDateTime;

//This consists of fields that you do not want the public to see
@Data
public class RegisterUserResponse {
    private String userId;
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private String userPhoneNumber;
    private LocalDateTime dateTime;
}


