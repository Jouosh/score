package dev.martin.services;

import dev.martin.entities.Score;

import java.util.List;

public interface ScoreService {

    //Create
    Score registerScore(Score score);

    //Read
    Score getScoreById(int id);

    List<Score> getAllScores();

    List<Score> getAllScoresOrderByInitial();

    //Update
    Score modifyScore(Score score);

    //Delete
    boolean deleteScore(int id);

}
