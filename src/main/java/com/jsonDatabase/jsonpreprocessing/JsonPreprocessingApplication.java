package com.jsonDatabase.jsonpreprocessing;

import com.jsonDatabase.jsonpreprocessing.Repositories.GameRepository;
import com.jsonDatabase.jsonpreprocessing.Repositories.LiveMatchRepository;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class JsonPreprocessingApplication{
    public final String folderPath="C:/Users/saikat/Desktop/Hackathon 8.0 Full Stack Task/match";
    @Autowired
    GameRepository gameRepository;
    @Autowired
    LiveMatchRepository liveMatchRepository;

	public static void main(String[] args) throws IOException, ParseException {
        SpringApplication.run(JsonPreprocessingApplication.class, args);

	}



}
