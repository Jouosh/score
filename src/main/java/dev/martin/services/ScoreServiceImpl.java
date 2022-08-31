package dev.martin.services;

import dev.martin.entities.Score;
import dev.martin.exceptions.NegativeScoreException;
import dev.martin.exceptions.ScoreNotFoundException;
import dev.martin.repos.ScoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreServiceImpl implements ScoreService{

    @Autowired
    ScoreRepo scoreRepo;

    @Override
    public Score registerScore(Score score) {

        if (score.getPoints() < 0) {
            throw new NegativeScoreException();
        }

        if (score.getInitials().length() > 3) {
            score.setInitials(score.getInitials().substring(0, 3));
        }

        score.setInitials(score.getInitials().toUpperCase());

        Score savedScore = this.scoreRepo.save(score);
        return savedScore;
    }

    @Override
    public Score getScoreById(int id) {
        Optional<Score> possibleScore = this.scoreRepo.findById(id);
        if (possibleScore.isPresent()) {
            return possibleScore.get();
        } else {
            throw new ScoreNotFoundException();
        }
    }

    @Override
    public List<Score> getAllScores() {
        List<Score> scores = this.scoreRepo.findAllByOrderByPointsDesc();
        return scores;
    }

    @Override
    public List<Score> getAllScoresOrderByInitial() {
        List<Score> scores = this.scoreRepo.findAllByOrderByInitialsAsc();
        return scores;
    }

    @Override
    public Score modifyScore(Score score) {
        if (score.getPoints() < 0) {
            throw new NegativeScoreException();
        }

        if (score.getInitials().length() > 3) {
            score.setInitials(score.getInitials().substring(0, 3));
        }

        score.setInitials(score.getInitials().toUpperCase());

        Score savedScore = this.scoreRepo.save(score);
        return savedScore;
    }

    @Override
    public boolean deleteScore(int id) {
        try {
            this.scoreRepo.deleteById(id);
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }

}
