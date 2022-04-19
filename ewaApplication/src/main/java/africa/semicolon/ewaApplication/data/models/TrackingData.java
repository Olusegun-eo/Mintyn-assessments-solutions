package africa.semicolon.ewaApplication.data.models;


import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class TrackingData {

    private LocalDateTime dateTimeOfEvent = LocalDateTime.now();
    @NonNull
    private String event;
    @NonNull
    private String userPhoneNumber;
    @NonNull
    private String userFirstName;
    @NonNull
    private String userLastName;
    @NonNull
    private String userEmail;
    @NonNull
    private String userAddress;
}
