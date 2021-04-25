package com.jsonDatabase.jsonpreprocessing;

import com.jsonDatabase.jsonpreprocessing.Repositories.LiveMatchRepository;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class JsonPreprocessingApplication{


    @Autowired
    LiveMatchRepository liveMatchRepository;

	public static void main(String[] args) throws IOException, ParseException {
        SpringApplication.run(JsonPreprocessingApplication.class, args);

	}



}
