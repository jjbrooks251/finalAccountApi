package com.qa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.entities.SentAccount;

@Repository
public interface MongoAccountRepo extends MongoRepository<SentAccount, Integer>{
}

