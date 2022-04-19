package africa.semicolon.ewaApplication.data.repositories;

import java.util.List;
import java.util.Optional;

public interface TrackingDataRepository {

    TrackingInformation save(TrackingInformation trackingInformation);
    List<TrackingInformation> findAll();
    void deleteAll();
    Optional<TrackingInformation> findByPackageId(Integer packageId);
    void delete(Integer packageId);
    void delete(TrackingInformation trackingInformation);
}
