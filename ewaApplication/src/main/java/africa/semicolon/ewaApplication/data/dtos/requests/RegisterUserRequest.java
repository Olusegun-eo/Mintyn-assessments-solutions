package africa.semicolon.ewaApplication.data.dtos.requests;

//This consists of fields that you do not want the users to fill
import lombok.Data;

@Data
public class RegisterUserRequest {
    private Integer userId;
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private String userPhoneNumber;
    private String userPassword;
}
