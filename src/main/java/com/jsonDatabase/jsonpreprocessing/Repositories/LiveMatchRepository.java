package com.jsonDatabase.jsonpreprocessing.Repositories;

import com.jsonDatabase.jsonpreprocessing.Model.LiveMatch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface LiveMatchRepository extends MongoRepository<LiveMatch,Integer> {

    LiveMatch findByMatchid(String id);

    @Query("{'matchid' : ?0 }")
    public List<LiveMatch> findByMatchId(String id);
}
