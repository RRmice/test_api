package com.example.test_api.repositories;

import com.example.test_api.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

       public Email getOneByEmail(String email);

}