package africa.semicolon.logisticApplication.data.dtos.responses;

import lombok.Data;


//This is a typical dtos===>These are the things we're expecting from the front End
//Like another App, etc
@Data
public class AddPackageResponse {
    private Integer trackingNumber;
    private String packageName;
    private String receiverName;
    private String receiverPhone;
    private double packageWeight;
}

