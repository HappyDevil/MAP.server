package com.MAP.mapProject.server.service;


import com.MAP.mapProject.server.entity.Mark;
import com.MAP.mapProject.server.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan("com.MAP.mapProject.server")
public class ServiceImpl implements MarkService {

    @Autowired
    private MarkRepository markRepository;

    public List<Mark> getAll() {
        return markRepository.findAll();
    }

    public Mark getByID(long id) {
        return markRepository.findOne(id);
    }

    public Mark save(Mark mark){
        return markRepository.saveAndFlush(mark);
    }

    public void remove(long id) {
        markRepository.delete(id);
    }
}

