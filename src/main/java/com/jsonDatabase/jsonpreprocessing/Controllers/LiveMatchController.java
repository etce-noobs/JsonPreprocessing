package com.jsonDatabase.jsonpreprocessing.Controllers;

import com.jsonDatabase.jsonpreprocessing.Repositories.LiveMatchRepository;
import com.jsonDatabase.jsonpreprocessing.Services.LiveMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LiveMatchController {
    @Autowired
    LiveMatchService liveMatchService;

    @Autowired
    LiveMatchRepository liveMatchRepository;
    @GetMapping("/get")
    public ResponseEntity getLiveMatch(){
        return new ResponseEntity(liveMatchRepository
                .findByMatchId("d41370a0-f70b-4fac-862b-509ded073705")
                ,HttpStatus.OK);

    }
}
