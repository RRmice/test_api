package com.example.test_api.controllers;

import com.example.test_api.entities.Email;
import com.example.test_api.services.EmailDTO;
import com.example.test_api.services.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    private final EmailService emailService;

    @Autowired
    public MainController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/addmail")
    public ResponseEntity<?> addMail(@RequestBody String request) throws Exception{

        ObjectMapper mapper = new ObjectMapper();
        EmailDTO mail = mapper.readValue(request, EmailDTO.class);

        if (emailService.save(mail.getEmail())) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }





}