package com.course.project.trailcenter.repository;

import com.course.project.trailcenter.business.entities.TrailEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TrailRepository {

    public TrailEntity addNewTrail(Integer trailID, String trailName, ArrayList<Integer> trailMap) {
        //todo insert to database
        return new TrailEntity(trailID, trailName, trailMap);
    }
}
