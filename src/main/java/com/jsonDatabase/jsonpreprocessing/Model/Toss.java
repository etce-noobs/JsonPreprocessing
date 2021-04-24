package com.jsonDatabase.jsonpreprocessing.Model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Toss {
    private String winner;
    private String decision;
}
