package africa.semicolon.logisticApplication.controllers;

import africa.semicolon.logisticApplication.data.exceptions.SenderDoesNotExistException;
import africa.semicolon.logisticApplication.data.models.Package;
import africa.semicolon.logisticApplication.data.dtos.requests.AddPackageRequest;
import africa.semicolon.logisticApplication.data.dtos.responses.AddPackageResponse;
import africa.semicolon.logisticApplication.services.PackageService;
import africa.semicolon.logisticApplication.services.PackageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PackageController {

//    Controllers don't return void
//    They may not take anything in But Must never return void

    private final PackageService packageService = new PackageServiceImpl();


    @PostMapping("/api/addpackage")
    public ResponseEntity<?> addPackage(@RequestBody AddPackageRequest addPackageRequest){
        try{
            AddPackageResponse response = packageService.addPackage(addPackageRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (SenderDoesNotExistException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/package/{id}")
    public Package findPackageById(@PathVariable("id")Integer id){
        return packageService.findMyPackageWithMy(id);
    }

}