package dev.martin.controllers;

import dev.martin.entities.Score;
import dev.martin.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ScoreControllers {

    @Autowired
    ScoreService scoreService;

    @PostMapping("/scores")
    @ResponseBody
    public ResponseEntity<Score> createScore(@RequestBody Score body) {
        Score savedScore = this.scoreService.registerScore(body);
        return new ResponseEntity<Score>(savedScore, HttpStatus.CREATED);
    }

    @GetMapping("/scores/{id}")
    @ResponseBody
    public Score getScoreById(@PathVariable String id) {
        int scoreId = Integer.parseInt(id);
        return this.scoreService.getScoreById(scoreId);
    }

    @GetMapping("/scores")
    @ResponseBody
    public List<Score> getAllScores(@RequestParam(required = false) String order) {
        if (order == null) {
            return this.scoreService.getAllScores();
        } else {
            return this.scoreService.getAllScoresOrderByInitial();
        }
    }

    @PutMapping("/scores")
    @ResponseBody
    public Score updateScore(@RequestBody Score body) {
        Score savedScore = this.scoreService.modifyScore(body);
        return savedScore;
    }

    @DeleteMapping("/scores/{id}")
    @ResponseBody
    public boolean deleteScore(@PathVariable String id) {
        int scoreId = Integer.parseInt(id);
        return this.scoreService.deleteScore(scoreId);
    }

}
