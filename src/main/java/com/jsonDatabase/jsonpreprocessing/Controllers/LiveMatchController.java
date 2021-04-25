package com.jsonDatabase.jsonpreprocessing.Controllers;

import com.jsonDatabase.jsonpreprocessing.Repositories.LiveMatchRepository;
import com.jsonDatabase.jsonpreprocessing.Repositories.mongoGameRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LiveMatchController {
    @Autowired
    LiveMatchRepository liveMatchRepository;

    @Autowired
    mongoGameRepositories mongoGameRepositories;

    @GetMapping("/match/{id}")
    public ResponseEntity getLiveMatch(@PathVariable("id") String match_id){
        return new ResponseEntity(liveMatchRepository
                .findByMatchId(match_id)
                ,HttpStatus.OK);

    }
    @GetMapping("/match")
    public ResponseEntity getBriefMatchDetails(){
        return new ResponseEntity(mongoGameRepositories.findAll(),HttpStatus.OK);
    }
}
