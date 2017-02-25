package com.mapProject.server.service;


import com.mapProject.server.entity.Mark;
import com.mapProject.server.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkServiceImpl implements MarkService {

    @Autowired
    private MarkRepository markRepository;

    public MarkServiceImpl() {
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

