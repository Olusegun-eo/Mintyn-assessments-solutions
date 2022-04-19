package africa.semicolon.ewaApplication.data.models;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LoginUser {
    private Integer userLoginId;
    private final List<TrackingData> trackingLogins = new ArrayList<>();

}

