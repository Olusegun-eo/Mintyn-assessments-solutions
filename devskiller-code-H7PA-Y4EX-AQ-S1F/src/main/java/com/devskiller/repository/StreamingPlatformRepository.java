package com.devskiller.repository;


import com.devskiller.model.StreamingPlatform;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface StreamingPlatformRepository extends CrudRepository<StreamingPlatform, Long> {
//
//    @Query(value = "",  nativeQuery = true)
//    List<String> findByNumberOfStreamingPlatformGreaterThan(long numberOfStreamingPlatform);

    @Query(value = "SELECT * from streaming_platform WHERE streaming_platform.name = ?1, AND series.title = ?2", nativeQuery = true)
    boolean isPresentByNameAndTitle(String name, String title);

//    @Query(value = "SELECT * from StreamingPlatform", nativeQuery = true)
    @Query(value = " SELECT * FROM series WHERE series.title =: 'title' ", nativeQuery = true)
    String findBySeriesTitle(@Param("title") String title);
}


//right-join == USE COLUMN_ID TO JOIN 2SEPARATES TABLE
//lEFT-JOIN ==
//OUTER-JOIN == NON-INTERSECTION COLOUMN
//inner-join == intersection from tqo tABLES
