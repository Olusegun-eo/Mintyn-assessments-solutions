# Introduction

Recently, you have agreed to purchase a subscription plan to watch your favorite TV series. 
Unfortunately, you cannot decide which platform to choose. That's why you are going to 
prepare a series of queries that will help you select the best streaming platform.

# Problem Statement

In order to complete this task, you have to implement queries inside
the `SeriesRepository` and the `StreamingPlatformRepository` according to the given criteria:

### Example inserts

````
insert into streaming_platform (id, name, headquarter, website, launched) values (1, 'Netflix', 'Bahamas', 'www.netflix.com', '1997-08-29');
insert into streaming_platform (id, name, headquarter, website, launched) values (2, 'Amazon Prime', 'Aruba', 'www.amazon.com/prime', '2005-02-02');
insert into streaming_platform (id, name, headquarter, website, launched) values (17, 'Sky Go', 'Bahamas', 'www.sky-go.com', '2019-02-02');
````

````
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (1, 'Stranger Things', 25, 98, 'SF', 1);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (2, 'Black Mirror', 22, 88, 'SF', 1);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (6, 'The Boys', 8, 60, 'ACTION', 2);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (7, 'Bosch', 10, 44, 'DRAMA', 2);
````

1. **isPresentByNameAndTitle**(name, title): 
   - Should return `true` if there is a streaming platform with a given `name` and series `title`.
   - Should return `false` if there is no streaming platform with a given `name` and series `title`.
   
   Example: 
   - isPresentByNameAndTitle("Netflix", "Stranger Things") should return `true`.
   - isPresentByNameAndTitle("Netflix", "The Boys") should return `false`,
   
2. **findBySeriesTitle**(name):
   - Should return a streaming platform name and a corresponding series title, separated with `-` for a given `title`.

   Example: 
   - findBySeriesTitle("Stranger Things") should return `Netflix - Stranger Things`.

3. **findByNumberOfStreamingPlatformGreaterThan**(numberOfStreamingPlatform):
   - Should return a list of the streaming platform headquarters with a number of streaming platforms greater than a given `numberOfStreamingPlatform`.

   Example: 
   - findByNumberOfStreamingPlatformGreaterThan(1) should return `Bahamas`.

4. **findByNumberOfEpisodesGreaterThanAverage**():
   - Should return a list of `OnlyTitleAndNumberOfEpisodes` projections, for which the number of episodes is greater than the total average number of episodes. 
     Order results first by the `numberOfEpisodes` ascending, then by the `title` descending.

   Example: 
   - findByNumberOfEpisodesGreaterThanAverage() should return 
     OnlyTitleAndNumberOfEpisodes("Stranger Things", 25) and OnlyTitleAndNumberOfEpisodes("Black Mirror", 22). 

5. **findByAverageScoreGreaterThan**(averageScore):
   - Should return a list of `OnlyTypeAndAverageScore` projections, for which the average score is greater than a given `averageScore`.

   Example: 
   - findByAverageScoreGreaterThan(80.1) should return OnlyTypeAndAverageScore("SF", 93).

6. **findByBetweenScoreAndType**(minScore, maxScore, type):
   - Should return a list of `OnlyTitleAndNumberOfEpisodes` projections for a given series `type` and a score between `minScore` and `maxScore`. 

   Example: 
   - findByBetweenScoreAndType(40, 45, "DRAMA") should return OnlyTitleAndNumberOfEpisodes("Bosch", 10). 

# Hints

1. Make sure your solution is correct, but also pay attention to its quality.
2. Please only modify the StreamingPlatformRepository class and the SeriesRepository class.
3. Please check the StreamingPlatformRepositoryTest class and the SeriesRepositoryTest class in order to better understand and partially verify your solution.
4. For the sake of this task, assume that a series can only be present on one streaming platform.
