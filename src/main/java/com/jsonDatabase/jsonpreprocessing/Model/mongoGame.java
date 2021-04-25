package com.jsonDatabase.jsonpreprocessing.Model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class mongoGame {
    private int id;
    private String city;
    private String competition;
    private String gender;
    private String match_type;
    private String teams;


    private String liveMatchId;
}
