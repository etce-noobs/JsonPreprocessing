package com.jsonDatabase.jsonpreprocessing.Model;

import lombok.*;

import java.util.HashSet;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Players {
    HashSet<String> firstInningsBatting;
    HashSet<String> secondInningsBatting;
}
