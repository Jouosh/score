package dev.martin.app;

import dev.martin.entities.Score;
import dev.martin.repos.ScoreRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional //Stops any persistent changes in the database
public class ScoreRepoTests {

    @Autowired
    ScoreRepo scoreRepo;

    @Test
    public void add_score() {
        Score score = new Score(0, "JAM", 5555);
        Score savedScore = this.scoreRepo.save(score);
        System.out.println(savedScore);
        Assertions.assertNotEquals(0, savedScore.getId());
    }

    @Test
    public void get_score_by_id() {
        Score score = this.scoreRepo.findById(2).get();
        System.out.println(score);
    }

    @Test
    public void all_scores() {
        List<Score> scores = this.scoreRepo.findAllByOrderByPointsDesc();
        System.out.println(scores);
    }

    @Test
    public void get_all_scores_initials_order() {
        List<Score> scores = this.scoreRepo.findAllByOrderByInitialsAsc();
        System.out.println(scores);
    }

    @Test
    public void update_score() {
        Score score = new Score(3, "ZZZ", 10);
        Score updatedScore = this.scoreRepo.save(score);
        System.out.println(updatedScore);
    }

    @Test
    public void delete_score_by_id() {
        this.scoreRepo.deleteById(4);
    }

}
