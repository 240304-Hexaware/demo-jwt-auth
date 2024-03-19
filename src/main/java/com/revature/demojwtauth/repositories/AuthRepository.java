package com.revature.demojwtauth.repositories;

import com.revature.demojwtauth.models.AuthDto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthRepository extends MongoRepository<AuthDto, ObjectId> {
}
