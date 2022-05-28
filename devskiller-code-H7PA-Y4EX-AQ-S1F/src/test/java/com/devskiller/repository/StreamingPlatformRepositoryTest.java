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

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class StreamingPlatformRepositoryTest {

    @Autowired
    private StreamingPlatformRepository repository;

    @Test
    @DisplayName("should return true if platform with title is present")
    void trueIfPresent() {
        // given
        // when
        boolean actual = repository.isPresentByNameAndTitle("HBO Go", "Oz");

        // then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("should return headquarter having more platform than numberOfStreamingPlatform")
    void headquarters() {
        // given
        List<String> expected = asList("Canada", "Jamaica", "Panama");

        // when
//        List<String> actual = repository.findByNumberOfStreamingPlatformGreaterThan(3);

        // then
//        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }




    @TestConfiguration
    @EnableJpaRepositories(includeFilters = {
            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {StreamingPlatformRepository.class})})
    public static class TestConfig {

    }





}
