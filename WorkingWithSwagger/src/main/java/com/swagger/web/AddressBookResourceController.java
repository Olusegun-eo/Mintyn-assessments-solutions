package com.swagger.web;


import com.swagger.data.model.Contact;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class AddressBookResourceController {


//    Using ConcurrentHashMap as the Database to implementation contactList to save all the contacts in the memory
//    It is an In-Memory Database

    ConcurrentHashMap<Long, Contact> contacts = new ConcurrentHashMap<>();

    @GetMapping("/{id}")
    public Contact getContact(@PathVariable Long id) {
        return contacts.get(id);
    }

    @Operation(summary = "Get contacts",description= "get a list of contacts", tags = "Get")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Contatct", content = {@Content(mediaType = "application/json",
            schema = @Schema(implementation = Contact.class)) }),
            @ApiResponse(responseCode = "404", description = "Contact not Found", content = @Content)
    })
    @GetMapping("/contacts")
    public List<Contact> getAllContacts(){
        return new ArrayList<>(contacts.values());
    }

    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact){
        contacts.put(contact.getId(), contact);
        return contact;
    }

}
