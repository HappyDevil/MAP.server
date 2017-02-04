package com.MAP.mapProject.server.controller;

import com.MAP.mapProject.server.entity.Mark;
import com.MAP.mapProject.server.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/mark")
public class MarkController {


    @Autowired
    private MarkRepository markRepository;

    @RequestMapping(value="/get",method= RequestMethod.GET)
    @ResponseBody
    public Mark getMarks(ModelMap model)
    {
        return createMockMark();
    }


    private Mark createMockMark() {

        Mark mark = new Mark();
        mark.setDate(new Date());
        mark.setPrice(4);
        mark.setId(1);
        mark.setUser("user");
        mark.setTitle("title");
        mark.setText("txt");

        List<Mark> all = markRepository.findAll();

        return mark;
    }

}
