package africa.semicolon.logisticApplication.controllers;


import africa.semicolon.logisticApplication.data.dtos.requests.AddTrackingInfoRequest;
import africa.semicolon.logisticApplication.data.dtos.responses.AddTrackingInfoResponse;
import africa.semicolon.logisticApplication.data.models.TrackingInformation;
import africa.semicolon.logisticApplication.services.TrackingService;
import africa.semicolon.logisticApplication.services.TrackingServiceImpl;
import org.springframework.web.bind.annotation.*;


@RestController
public class    PackageTrackingController {


    private final TrackingService trackingService = new TrackingServiceImpl();

    @PostMapping("/api/trackingInfo")
    public AddTrackingInfoResponse addTrackingInfoResponse(@RequestBody AddTrackingInfoRequest addTrackingInfoRequest){
        return trackingService.updateTrackingInfo(addTrackingInfoRequest);
    }

    @GetMapping("/api/trackingInfo/{id}")
    public TrackingInformation getTrackingInfoResponse(@PathVariable ("id") Integer trackingId){
        return trackingService.trackPackage(trackingId);
    }

}
