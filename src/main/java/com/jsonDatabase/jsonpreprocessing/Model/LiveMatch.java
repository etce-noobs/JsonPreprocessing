package com.jsonDatabase.jsonpreprocessing.Model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class LiveMatch {

    private String  matchid;
    private Toss toss;
    private String umpires;
    private String firstInnings;
    private String secondInnings;
    private String outcome;


}
