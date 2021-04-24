package com.jsonDatabase.jsonpreprocessing.Services;

import com.jsonDatabase.jsonpreprocessing.Repositories.LiveMatchRepository;
import org.springframework.stereotype.Service;

@Service
public class LiveMatchService {
    LiveMatchRepository liveMatchRepository;
    public String  getMatch(){
        return liveMatchRepository.findByMatchid("d41370a0-f70b-4fac-862b-509ded073705").toString();

    }
}
