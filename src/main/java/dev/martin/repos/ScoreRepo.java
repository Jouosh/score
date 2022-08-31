package dev.martin.repos;

import dev.martin.entities.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepo extends JpaRepository<Score, Integer> {

    List<Score> findAllByOrderByPointsDesc();
    List<Score> findAllByOrderByInitialsAsc();

}
