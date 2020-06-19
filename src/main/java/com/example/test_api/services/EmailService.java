package com.example.test_api.services;

import com.example.test_api.entities.Email;
import com.example.test_api.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public boolean save(String em) {

        Email email = emailRepository.getOneByEmail(em);
        if (email != null) return false;

        email = new Email();
        email.setEmail(em);
        emailRepository.save(email);
        return true;

    }
}