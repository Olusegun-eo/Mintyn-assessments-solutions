package africa.semicolon.logisticApplication.services;

import africa.semicolon.logisticApplication.data.dtos.requests.RegisterSenderRequest;
import africa.semicolon.logisticApplication.data.dtos.responses.RegisterSenderResponse;
import africa.semicolon.logisticApplication.data.models.Sender;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface SenderService {
    RegisterSenderResponse registerSender(RegisterSenderRequest registerSenderRequest);

    List<Sender> getSenders();

    void deleteAllSenders();

    Optional<Sender>findSenderByEmail(String email);

}


/*
package africa.semicolon.cheetah.services;

import africa.semicolon.cheetah.data.models.Sender;
import africa.semicolon.cheetah.dtos.requests.RegisterSenderRequest;
import africa.semicolon.cheetah.dtos.responses.RegisterSenderResponse;

import java.util.List;
import java.util.Optional;

public interface SenderService {
    RegisterSenderResponse registerSender(RegisterSenderRequest registerSenderRequest);

    List<Sender> getSenders();

    void deleteAllSender();

    Optional<Sender> findSenderByEmail(String email);
}
 */