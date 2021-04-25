package com.jsonDatabase.jsonpreprocessing;

import com.jsonDatabase.jsonpreprocessing.Model.LiveMatch;
import com.jsonDatabase.jsonpreprocessing.Model.Players;
import com.jsonDatabase.jsonpreprocessing.Repositories.LiveMatchRepository;
import com.jsonDatabase.jsonpreprocessing.Services.LiveMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JsonPreprocessingApplication implements CommandLineRunner {
    @Autowired
    LiveMatchRepository liveMatchRepository;
    @Autowired
    LiveMatchService liveMatchService;
    public static void main(String[] args)  {
        SpringApplication.run(JsonPreprocessingApplication.class, args);

	}


    @Override
    public void run(String... args) throws Exception {
        List<LiveMatch> matchList=liveMatchRepository.findByMatchId("bb39d61e-deaa-4dfa-baf4-e6be366c3b02");
        LiveMatch match = matchList.get(0);
        Players playersInTheMatch=liveMatchService.getPlayers(match);

    }
}
