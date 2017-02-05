package com.MAP.mapProject.server.service;


import com.MAP.mapProject.server.entity.Mark;
import com.MAP.mapProject.server.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements MarkService {

    @Autowired
    private MarkRepository markRepository;

    public ServiceImpl() {
    }

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

