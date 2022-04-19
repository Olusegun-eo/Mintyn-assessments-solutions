package africa.semicolon.logisticApplication.controllers;

import africa.semicolon.logisticApplication.data.dtos.requests.RegisterSenderRequest;
import africa.semicolon.logisticApplication.data.dtos.responses.RegisterSenderResponse;
import africa.semicolon.logisticApplication.data.models.Sender;
import africa.semicolon.logisticApplication.services.SenderService;
import africa.semicolon.logisticApplication.services.SenderServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class SenderController {
    private final SenderService senderService = new SenderServiceImpl();

    @PostMapping("/api/v1/sender")
    public RegisterSenderResponse registerSender(@RequestBody RegisterSenderRequest registerSenderRequest){
        return senderService.registerSender(registerSenderRequest);
    }


    @GetMapping("/api/v1/sender/{id}")
    public Optional<Sender> getSender(@PathVariable("id") String email){
        return senderService.findSenderByEmail(email);
    }

}
