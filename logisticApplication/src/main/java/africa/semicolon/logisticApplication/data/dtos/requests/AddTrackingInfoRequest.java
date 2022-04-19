package africa.semicolon.logisticApplication.data.dtos.requests;


import lombok.Data;

@Data
public class AddTrackingInfoRequest{
    private Integer packageId;
    private String event;
}

