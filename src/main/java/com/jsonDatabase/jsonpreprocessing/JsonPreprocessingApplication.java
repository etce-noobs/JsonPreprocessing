package com.jsonDatabase.jsonpreprocessing;

import com.jsonDatabase.jsonpreprocessing.Repositories.GameRepository;
import com.jsonDatabase.jsonpreprocessing.Repositories.LiveMatchRepository;
import com.jsonDatabase.jsonpreprocessing.Repositories.mongoGameRepository;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class JsonPreprocessingApplication implements CommandLineRunner {
    //public final String folderPath="C:/Users/saikat/Desktop/Hackathon 8.0 Full Stack Task/match";
    @Autowired
    GameRepository GameRepository;
    @Autowired
    LiveMatchRepository liveMatchRepository;
    @Autowired
    mongoGameRepository mongoGameRepository;

	public static void main(String[] args) throws IOException, ParseException {
        SpringApplication.run(JsonPreprocessingApplication.class, args);

	}


    @Override
    public void run(String... args) throws Exception {
//        List<Game> gameList= GameRepository.findAll();
//        gameList
//                .stream()
//                .forEach(x-> {
//                    mongoGame game=mongoGame
//                            .builder()
//                            .id(x.getId())
//                            .city(x.getCity())
//                            .competition(x.getCompetition())
//                            .gender(x.getGender())
//                            .liveMatchId(x.getLiveMatchId())
//                            .match_type(x.getMatch_type())
//                            .teams(x.getTeams())
//                            .build();
//                    mongoGameRepository.save(game);
//                });

    }
}
