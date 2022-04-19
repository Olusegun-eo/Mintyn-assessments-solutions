package africa.semicolon.logisticApplication.data.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class AddTrackingInfoResponse {
    private Integer packageId;
    private LocalDateTime dateTime;
    private String event;
}

