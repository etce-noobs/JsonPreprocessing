package com.jsonDatabase.jsonpreprocessing.Repositories;

import com.jsonDatabase.jsonpreprocessing.Model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Integer> {
}
