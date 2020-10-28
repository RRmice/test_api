package com.example.test_api.services;

import com.example.test_api.entities.Email;
import com.example.test_api.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public boolean save(EmailDTO em) {

        Email email;

        email = new Email();
        email.setEmail(em.getEmail());
        emailRepository.save(email);
        return true;

    }

    public Email getEmail(EmailDTO em){
        return emailRepository.getOneByEmail(em.getEmail());
    }
}