package com.hatchways.data.web.controllers;


import com.hatchways.data.model.GetPosts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PostApiController {

    String sortTag = "{\"tags\":\"desc\"}";
    String sortSortBy = "{\"sortBy\":desc\"}";
    String sortDirection = "{\"direction\":desc\"}";
    private static final String URL ="http://hatchways.io/api/assessment/blog/posts?tag=${sort}&sortBy=${sortBy}&direction=${direction}";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/posts")
    public List<Object> getAllPosts() {
        Object posts = restTemplate.getForObject(URL, Object.class, new String[]{sortTag, sortSortBy, sortDirection});
         return Arrays.asList(posts);
    }

}
