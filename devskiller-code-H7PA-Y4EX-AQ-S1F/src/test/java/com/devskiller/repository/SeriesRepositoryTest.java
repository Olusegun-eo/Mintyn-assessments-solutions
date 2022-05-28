package com.devskiller.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

import static com.devskiller.model.Series.ContentType.DRAMA;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class SeriesRepositoryTest {

    @Autowired
    private SeriesRepository repository;

    @Test
    @DisplayName("should return projections between score and given type")
    void betweenAndType() {
        // given
        List<Pair<String, Integer>> expected = asList(
                Pair.of("The Crown", 23),
                Pair.of("Harlots", 24));

        // when
        List<Pair<String, Integer>> actual = repository.findByBetweenScoreAndType(80, 99, DRAMA)
                .stream()
                .map(e -> Pair.of(e.getTitle(), e.getNumberOfEpisodes()))
                .collect(toList());
        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }


    @TestConfiguration
    @EnableJpaRepositories(includeFilters = {
            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {SeriesRepository.class})})
    public static class TestConfig {

    }



}
