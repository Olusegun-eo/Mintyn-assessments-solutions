package africa.semicolon.logisticApplication.services;

import africa.semicolon.logisticApplication.data.models.Package;
import africa.semicolon.logisticApplication.data.dtos.requests.AddPackageRequest;
import africa.semicolon.logisticApplication.data.dtos.responses.AddPackageResponse;

import java.util.List;

public interface    PackageService {

    AddPackageResponse addPackage(AddPackageRequest addPackageRequest);
    Package findMyPackageWithMy(Integer id);
    List<Package> getAllPackages();
    void deleteAllPackages();
}
