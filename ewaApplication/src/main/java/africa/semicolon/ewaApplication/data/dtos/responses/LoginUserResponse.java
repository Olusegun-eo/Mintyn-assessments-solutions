package africa.semicolon.ewaApplication.data.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoginUserResponse {
    private String userId;
    private String userFirstName;
    private String userLastName;
    private String userPhoneNumber;
    private LocalDateTime dateTime;
}
