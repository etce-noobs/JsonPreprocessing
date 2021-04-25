package com.jsonDatabase.jsonpreprocessing.Controllers;

import com.jsonDatabase.jsonpreprocessing.Model.LiveMatch;
import com.jsonDatabase.jsonpreprocessing.Model.Players;
import com.jsonDatabase.jsonpreprocessing.Model.ResponseClass;
import com.jsonDatabase.jsonpreprocessing.Repositories.LiveMatchRepository;
import com.jsonDatabase.jsonpreprocessing.Repositories.mongoGameRepositories;
import com.jsonDatabase.jsonpreprocessing.Services.LiveMatchService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LiveMatchController {
    @Autowired
    LiveMatchRepository liveMatchRepository;

    @Autowired
    mongoGameRepositories mongoGameRepositories;

    @Autowired
    LiveMatchService liveMatchService;

    @GetMapping("/match/{id}")
    public ResponseEntity getLiveMatch(@PathVariable("id") String match_id) throws ParseException {
        List<LiveMatch> matchList=liveMatchRepository.findByMatchId(match_id);
        if (matchList.isEmpty()){
            return new ResponseEntity("No such match found!!",HttpStatus.NO_CONTENT);
        }
        LiveMatch match = matchList.get(0);
        Players playersInTheMatch=liveMatchService.getPlayers(match);
        ResponseClass responseClass=ResponseClass
                .builder()
                .liveMatch(match)
                .players(playersInTheMatch)
                .build();
        return new ResponseEntity(responseClass
                ,HttpStatus.OK);

    }
    @GetMapping("/match")
    public ResponseEntity getBriefMatchDetails(){
        return new ResponseEntity(mongoGameRepositories.findAll(),HttpStatus.OK);
    }
}

