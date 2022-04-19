package africa.semicolon.logisticApplication.services;

import africa.semicolon.logisticApplication.data.models.Package;
import africa.semicolon.logisticApplication.data.models.Sender;
import africa.semicolon.logisticApplication.data.repositories.PackageRepository;
import africa.semicolon.logisticApplication.data.repositories.PackageRepositoryImpl;
import africa.semicolon.logisticApplication.data.dtos.requests.AddPackageRequest;
import africa.semicolon.logisticApplication.data.dtos.responses.AddPackageResponse;
import africa.semicolon.logisticApplication.utils.ModelMapper;

import java.util.List;
import java.util.Optional;

public class PackageServiceImpl implements PackageService{

    private static final PackageRepository packageRepository = new PackageRepositoryImpl();

    private final SenderService senderService = new SenderServiceImpl();

    @Override
    public AddPackageResponse addPackage(AddPackageRequest addPackageRequest) {
        Optional<Sender> senderOptional = senderService.findSenderByEmail(addPackageRequest.getSenderEmail());
//       Convert addPackage request to a package
        Package aPackage = ModelMapper.map(addPackageRequest);

//        Save Package
        Package savedPackage = packageRepository.save(aPackage);

//        Convert Saved Package to database response
        AddPackageResponse response = ModelMapper.map(savedPackage);
//        return  converted response
        return response;
    }

    @Override
    public Package findMyPackageWithMy(Integer id){
        return packageRepository.findById(id);
    }

    @Override
    public List<Package> getAllPackages() {
        return null;
    }

    @Override
    public void deleteAllPackages() {

    }
}




/*
package africa.semicolon.cheetah.services;

import africa.semicolon.cheetah.data.models.Package;
import africa.semicolon.cheetah.data.models.Sender;
import africa.semicolon.cheetah.data.repositories.PackageRepository;
import africa.semicolon.cheetah.data.repositories.PackageRepositoryImpl;
import africa.semicolon.cheetah.dtos.requests.AddPackageRequest;
import africa.semicolon.cheetah.dtos.responses.AddPackageResponse;
import africa.semicolon.cheetah.exceptions.SenderDoesNotExistException;
import africa.semicolon.cheetah.utils.ModelMapper;

import java.util.Optional;

public class PackageServiceImpl implements PackageService{
    private static final PackageRepository packageRepository = new PackageRepositoryImpl();
    private final SenderService senderService = new SenderServiceImpl();

    @Override
    public AddPackageResponse addPackage(AddPackageRequest addPackageRequest) {
        //    convert addpackage request to a package
        Optional<Sender> senderOptional = senderService.findSenderByEmail(addPackageRequest.getSenderEmail());
        if(senderOptional == null) throw new SenderDoesNotExistException("Sender not register");
      Package aPackage = ModelMapper.map(addPackageRequest);

//        save package
        Package savedPackage = packageRepository.save(aPackage);

//        convert saved package to addpackage response
//        AddPackageResponse response = ModelMapper.map(savedPackage);
//        return response;
//        or
        return ModelMapper.map(savedPackage);
    }


}
 */