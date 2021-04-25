package com.jsonDatabase.jsonpreprocessing.Services;

import com.jsonDatabase.jsonpreprocessing.Model.LiveMatch;
import com.jsonDatabase.jsonpreprocessing.Model.Players;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class LiveMatchService {

    public Players getPlayers(LiveMatch match) throws ParseException {
        String firstInnings=match.getFirstInnings();
        JSONParser parser=new JSONParser();
        JSONObject firstInningsJson=(JSONObject)parser.parse(firstInnings);
        HashSet<String> firstInningsBatting=new HashSet<String>();
        HashSet<String> secondInningsBatting=new HashSet<String>();
        JSONArray firstInningsDeliveries=(JSONArray) firstInningsJson.get("deliveries");
        for(int i=0;i<firstInningsDeliveries.size();i++){
            JSONObject delivery_obj=(JSONObject)firstInningsDeliveries.get(i);
            Set<String> key= delivery_obj.keySet();
            JSONObject ballDetails=null;
            for (String s:key){
                ballDetails=(JSONObject) delivery_obj.get(s);
            }
            firstInningsBatting.add((String)ballDetails.get("batsman"));
            firstInningsBatting.add((String)ballDetails.get("non_striker"));
            secondInningsBatting.add((String)ballDetails.get("bowler"));

        }
        String secondInnings=match.getSecondInnings();
        JSONObject secondInningsJson=(JSONObject)parser.parse(secondInnings);
        JSONArray secondInningsDeliveries=(JSONArray)secondInningsJson.get("deliveries");
        for (int i=0;i<secondInningsDeliveries.size();i++){
            JSONObject delivery_obj=(JSONObject)secondInningsDeliveries.get(i);
            Set<String> key= delivery_obj.keySet();
            JSONObject ballDetails=null;
            for (String s:key){
                ballDetails=(JSONObject) delivery_obj.get(s);
            }
            firstInningsBatting.add((String)ballDetails.get("bowler"));
            secondInningsBatting.add((String)ballDetails.get("non_striker"));
            secondInningsBatting.add((String)ballDetails.get("batsman"));
        }
        Players players=Players
                .builder()
                .firstInningsBatting(firstInningsBatting)
                .secondInningsBatting(secondInningsBatting)
                .build();
        return players;

    }


}
