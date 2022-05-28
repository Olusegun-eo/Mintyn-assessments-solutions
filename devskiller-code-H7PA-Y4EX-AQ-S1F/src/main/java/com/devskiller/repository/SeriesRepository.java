package com.devskiller.repository;

import com.devskiller.model.OnlyTitleAndNumberOfEpisodes;
import com.devskiller.model.OnlyTypeAndAverageScore;
import com.devskiller.model.Series;
import com.devskiller.model.Series.ContentType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeriesRepository extends CrudRepository<Series, Long> {

    @Query(value = "SELECT * FROM ", nativeQuery = true)
    List<OnlyTitleAndNumberOfEpisodes> findByNumberOfEpisodesGreaterThanAverage();

    @Query(value = "SELECT * FROM WHERE ", nativeQuery = true)
    List<OnlyTypeAndAverageScore> findByAverageScoreGreaterThan(double averageScore);

    @Query(value = "SELECT * FROM", nativeQuery = true)
    List<OnlyTitleAndNumberOfEpisodes> findByBetweenScoreAndType(
            int minScore, int maxScore, ContentType type);
}
