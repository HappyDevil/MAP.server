package com.MAP.mapProject.server.service;

import com.MAP.mapProject.server.entity.Mark;

import java.util.List;


public interface MarkService {

    List<Mark> getAll();
    Mark getByID(long id);
    Mark save(Mark mark);
    void remove(long id);

}
