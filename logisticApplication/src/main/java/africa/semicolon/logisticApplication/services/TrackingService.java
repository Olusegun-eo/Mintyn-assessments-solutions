package africa.semicolon.logisticApplication.services;

import africa.semicolon.logisticApplication.data.dtos.requests.AddTrackingInfoRequest;
import africa.semicolon.logisticApplication.data.dtos.responses.AddTrackingInfoResponse;
import africa.semicolon.logisticApplication.data.models.TrackingInformation;

public interface TrackingService {
    AddTrackingInfoResponse updateTrackingInfo(AddTrackingInfoRequest addTrackingInfoRequest);
    TrackingInformation trackPackage(Integer packageId);
}
