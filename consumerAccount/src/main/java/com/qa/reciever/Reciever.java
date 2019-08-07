package com.qa.reciever;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.qa.entities.SentAccount;
import com.qa.repository.MongoAccountRepo;

@Component
public class Reciever {

    @Autowired
    private MongoAccountRepo repo;

    @JmsListener(destination = "AccountQueue", containerFactory = "myFactory")
    public void receiveMessage(SentAccount sentAccount) {
        repo.save(sentAccount);
    }

}
