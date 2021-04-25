package com.jsonDatabase.jsonpreprocessing.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseClass {
    private Players players;
    private LiveMatch liveMatch;
}
