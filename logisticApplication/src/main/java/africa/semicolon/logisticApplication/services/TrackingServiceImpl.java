package africa.semicolon.logisticApplication.services;

import africa.semicolon.logisticApplication.data.dtos.requests.AddTrackingInfoRequest;
import africa.semicolon.logisticApplication.data.dtos.responses.AddTrackingInfoResponse;
import africa.semicolon.logisticApplication.data.exceptions.InvalidPackageIdException;
import africa.semicolon.logisticApplication.data.models.TrackingData;
import africa.semicolon.logisticApplication.data.models.TrackingInformation;
import africa.semicolon.logisticApplication.data.repositories.TrackingInformationRepository;
import africa.semicolon.logisticApplication.data.repositories.TrackingInformationRepositoryImpl;
import africa.semicolon.logisticApplication.utils.ModelMapper;

import java.util.Optional;

public class TrackingServiceImpl implements TrackingService{
    private static final TrackingInformationRepository trackingRepo = new TrackingInformationRepositoryImpl();
    private final PackageService packageService = new PackageServiceImpl();

    @Override
    public AddTrackingInfoResponse updateTrackingInfo(AddTrackingInfoRequest addTrackingInfoRequest) {
// verify package id is correct
        var aPackage = packageService.findMyPackageWithMy(addTrackingInfoRequest.getPackageId());
        if(aPackage==null) throw new InvalidPackageIdException("Package Id is invalid");

        TrackingData trackingData = new TrackingData(addTrackingInfoRequest.getEvent());
//        find previous tracking id;
        Optional<TrackingInformation> optionalInfo = trackingRepo.findByPackageId(addTrackingInfoRequest.getPackageId());

        //        if exist add new event and save;
        if(optionalInfo.isPresent()){
            optionalInfo.get().getTrackingData().add(trackingData);
            trackingRepo.save(optionalInfo.get());
        }else{
            //        else create new tracking info, add new event and save
            TrackingInformation trackingInformation = new TrackingInformation();
            trackingInformation.setPackageId(addTrackingInfoRequest.getPackageId());
            trackingInformation.getTrackingData().add(trackingData);
            trackingRepo.save(trackingInformation);
        }
//        convert saved tracking info to response dto
//        return response dto;
        return ModelMapper.map(trackingData, addTrackingInfoRequest);
    }

    @Override
    public TrackingInformation trackPackage(Integer packageId) {
        return trackingRepo.findByPackageId(packageId).get();
    }
}



/*
package africa.semicolon.cheetah.services;

import africa.semicolon.cheetah.data.models.TrackingData;
import africa.semicolon.cheetah.data.models.TrackingInformation;
import africa.semicolon.cheetah.data.repositories.TrackingInformationRepository;
import africa.semicolon.cheetah.data.repositories.TrackingInformationRepositoryImpl;
import africa.semicolon.cheetah.dtos.requests.AddTrackingInfoRequest;
import africa.semicolon.cheetah.dtos.responses.AddTrackingInfoResponse;
import africa.semicolon.cheetah.exceptions.InvalidPackageIdException;
import africa.semicolon.cheetah.utils.ModelMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class TrackingServiceImpl implements TrackingService{
    private final PackageService packageService = new PackageServiceImpl();

    private static final TrackingInformationRepository trackingRepo = new TrackingInformationRepositoryImpl();

    @Override
    public AddTrackingInfoResponse updateTrackingInfo(AddTrackingInfoRequest addTrackingInfoRequest) {
//        verify package id is correct

        log.info("package id is "+ addTrackingInfoRequest.getPackageId());
      var aPackage = packageService.findMyPackageWithMy(addTrackingInfoRequest.getPackageId());
        if(aPackage == null) throw new InvalidPackageIdException("Package Id is invalid");
        TrackingData trackingData = new TrackingData(addTrackingInfoRequest.getEvent());
//        find previous tracking info;
        Optional<TrackingInformation> optionalInfo = trackingRepo.
                findByPackageId(addTrackingInfoRequest.getPackageId());

        TrackingInformation response = null;
        if(optionalInfo.isPresent()) {optionalInfo.get().getTrackingData().add(trackingData);
        trackingRepo.save(optionalInfo.get());
        }
        else{
            TrackingInformation trackingInformation = new TrackingInformation();
            trackingInformation.setPackageId(addTrackingInfoRequest.getPackageId());
            trackingInformation.getTrackingData().add(trackingData);
            trackingRepo.save(trackingInformation);

        }

//        else create new tracking info, add new event and save
//        convert saved tracking info to response dto
//        return response dto
//        (trackingData, addTrackingInfoRequest);
        return ModelMapper.map(trackingData, addTrackingInfoRequest.getPackageId());
    }

    @Override
    public TrackingInformation trackPackage(Integer packageId) {
        return trackingRepo.findByPackageId(packageId).get();
    }
}
 */