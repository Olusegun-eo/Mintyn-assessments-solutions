package africa.semicolon.ewaApplication.data.models;


import lombok.Data;

@Data
public class RegisterUser {
    private Integer userId;
    private String userPhoneNumber;
    private String userFirstName;
    private String userLastName;
    private String password;
    private String userEmail;
    private String userAddress;
}
