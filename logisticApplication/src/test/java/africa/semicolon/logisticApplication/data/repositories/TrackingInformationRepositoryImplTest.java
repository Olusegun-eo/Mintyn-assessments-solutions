package africa.semicolon.logisticApplication.data.repositories;

import africa.semicolon.logisticApplication.data.dtos.responses.RegisterSenderResponse;
import africa.semicolon.logisticApplication.data.models.TrackingData;
import africa.semicolon.logisticApplication.data.models.TrackingInformation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TrackingInformationRepositoryImplTest {
    TrackingInformationRepository trackingInformationRepository;

    @BeforeEach
    void setUp() {
        trackingInformationRepository = new TrackingInformationRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        TrackingInformation trackingInformation = new TrackingInformation();
        trackingInformation.setPackageId(123456789);

        TrackingData trackingData = new TrackingData("Package ready for delivery");
        trackingInformation.getTrackingData().add(trackingData);
        TrackingInformation savedInfo = trackingInformationRepository.save(trackingInformation);

        assertEquals(savedInfo, trackingInformation);
        assertEquals(1, trackingInformationRepository.findAll().size());

    }

    private TrackingInformation saveTestHelper(){
        TrackingInformation trackingInformation = new TrackingInformation();
        trackingInformation.setPackageId(123456789);

        TrackingData trackingData = new TrackingData("Package ready for delivery");
        trackingInformation.getTrackingData().add(trackingData);
        TrackingInformation savedInfo = trackingInformationRepository.save(trackingInformation);
        return savedInfo;
    }


    @Test
    void findAll() {
        saveTestHelper();
        assertEquals(1,trackingInformationRepository.findAll().size());
    }

    @Test
    void deleteAll() {
        saveTestHelper();
        assertEquals(1, trackingInformationRepository.findAll().size());
        trackingInformationRepository.deleteAll();
        assertEquals(0, trackingInformationRepository.findAll().size());
    }

    @Test
    void findByPackageId() {
        TrackingInformation savedTrackingInformation = saveTestHelper();
        Optional<TrackingInformation> optionalTrackingInformation = trackingInformationRepository.findByPackageId(savedTrackingInformation.getPackageId());
        assertTrue(optionalTrackingInformation.isPresent());
        assertEquals(savedTrackingInformation, optionalTrackingInformation.get());
    }

    @Test
    void delete() {
        TrackingInformation savedTrackingInformation = saveTestHelper();
        assertEquals(1, trackingInformationRepository.findAll().size());
        trackingInformationRepository.delete(savedTrackingInformation.getPackageId());
        assertEquals(0, trackingInformationRepository.findAll().size());
    }

    @Test
    void testDelete() {
        TrackingInformation savedTrackingInformation = saveTestHelper();
        assertEquals(1, trackingInformationRepository.findAll().size());
        trackingInformationRepository.delete(savedTrackingInformation);
        assertEquals(0, trackingInformationRepository.findAll().size());
    }

}
