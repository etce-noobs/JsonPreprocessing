package com.jsonDatabase.jsonpreprocessing.Repositories;

import com.jsonDatabase.jsonpreprocessing.Model.LiveMatch;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LiveMatchRepository extends MongoRepository<LiveMatch,Integer> {
}
