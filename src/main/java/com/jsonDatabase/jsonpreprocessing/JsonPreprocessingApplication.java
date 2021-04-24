package com.jsonDatabase.jsonpreprocessing;

import com.jsonDatabase.jsonpreprocessing.Model.Game;
import com.jsonDatabase.jsonpreprocessing.Model.LiveMatch;
import com.jsonDatabase.jsonpreprocessing.Model.Toss;
import com.jsonDatabase.jsonpreprocessing.Repositories.GameRepository;
import com.jsonDatabase.jsonpreprocessing.Repositories.LiveMatchRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

@SpringBootApplication
public class JsonPreprocessingApplication implements CommandLineRunner {
    public final String folderPath="C:/Users/saikat/Desktop/Hackathon 8.0 Full Stack Task/match";
    @Autowired
    GameRepository gameRepository;
    @Autowired
    LiveMatchRepository liveMatchRepository;
	public static void main(String[] args) throws IOException, ParseException {
        SpringApplication.run(JsonPreprocessingApplication.class, args);

	}

    @Override
    public void run(String... args) throws Exception {
        JSONParser parser=new JSONParser();
        final File folder=new File(folderPath);
        for (File file: folder.listFiles()){
            System.out.println(file.getName());
            Object jsonParse=parser.parse(new FileReader(file));
            JSONObject jsonObject=(JSONObject)jsonParse;
            JSONObject information=(JSONObject) jsonObject.get("info");
            JSONArray teams=(JSONArray) information.get("teams");
            String Teams=teams.get(0)+"/"+teams.get(1);
            String uniqueId= UUID.randomUUID().toString();
            Game game= Game
                    .builder()
                    .city((String) information.get("city"))
                    .competition((String) information.get("competition"))
                    .gender((String) information.get("gender"))
                    .match_type((String) information.get("match_type"))
                    .teams((String) Teams)
                    .liveMatchId(uniqueId)
                    .build();
            gameRepository.save(game);
            createMongo(jsonObject,game.getLiveMatchId());


        }

    }
    public void createMongo(JSONObject jsonObject,String uniqueId){
	    JSONObject infoTag=(JSONObject)jsonObject.get("info");
	    JSONObject tossTag=(JSONObject)infoTag.get("toss");
	    Toss toss=Toss.builder()
                .decision((String)tossTag.get("decision"))
                .winner((String)tossTag.get("winner"))
                .build();
        JSONArray umpireTag=(JSONArray)infoTag.get("umpires");
        String spaceSeparatedUmpires="";
        for (int i=0;i<umpireTag.size();i++){
            spaceSeparatedUmpires=spaceSeparatedUmpires+","+(String)umpireTag.get(i);
        }
        JSONObject outcomeTag=(JSONObject)infoTag.get("outcome");
        String outcome=(String) outcomeTag.get("winner")
                +" won by ";
        JSONObject by=(JSONObject) (outcomeTag.get("by"));
        if(by.containsKey("runs")){
            outcome=outcome+(Long)(by.get("runs"))+" runs";
        }
        else
            outcome=outcome+(Long) (by.get("wickets"))+" wickets";

        JSONArray inningsArrayTag=(JSONArray) jsonObject.get("innings");
        String firstInn=((JSONObject)inningsArrayTag.get(0)).get("1st innings").toString();
        String secondInn=((JSONObject)inningsArrayTag.get(1)).get("2nd innings").toString();
        LiveMatch liveMatch=LiveMatch
                .builder()
                .firstInnings(firstInn)
                .secondInnings(secondInn)
                .matchid(uniqueId)
                .outcome(outcome)
                .toss(toss)
                .umpires(spaceSeparatedUmpires)
                .build();
        liveMatchRepository.insert(liveMatch);






    }
}
