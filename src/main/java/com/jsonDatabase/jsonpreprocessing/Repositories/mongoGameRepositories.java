package com.jsonDatabase.jsonpreprocessing.Repositories;

import com.jsonDatabase.jsonpreprocessing.Model.mongoGame;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface mongoGameRepositories extends MongoRepository<mongoGame,Integer> {
}
