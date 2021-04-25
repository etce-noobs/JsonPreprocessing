package com.jsonDatabase.jsonpreprocessing.Repositories;

import com.jsonDatabase.jsonpreprocessing.Model.mongoGame;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface mongoGameRepository  extends MongoRepository<mongoGame,Integer> {

}
