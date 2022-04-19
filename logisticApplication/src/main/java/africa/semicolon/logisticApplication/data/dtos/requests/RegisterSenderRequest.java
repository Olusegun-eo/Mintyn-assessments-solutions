package africa.semicolon.logisticApplication.data.dtos.requests;


import lombok.Data;

@Data
public class RegisterSenderRequest {
    private String senderEmail;
    private String senderName;
    private String phoneNumber;
}


