package com.MAP.mapProject.server.controller;

import com.MAP.mapProject.server.entity.Mark;
import com.MAP.mapProject.server.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mark")
public class MarkController {

    @Autowired
    private MarkService markService;

    @RequestMapping(value="/getAll",method= RequestMethod.GET)
    @ResponseBody
    public List<Mark> getAllMarks()
    {
        return markService.getAll();
    }

    @RequestMapping(value="/{ID}",method= RequestMethod.GET)
    @ResponseBody
    public Mark getMarkById(@PathVariable("ID") long markID)
    {
        return markService.getByID(markID);
    }

    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public Mark saveMark(@RequestBody Mark mark)
    {
        return markService.save(mark);
    }

    @RequestMapping(value="/delete/{ID}",method= RequestMethod.DELETE)
    @ResponseBody
    public void saveMark(@PathVariable("ID") int markID) {
        markService.remove(markID);
    }

}



//@Autowired
//    private MarkRepository markRepository;
//
//    @RequestMapping(value="/new",method= RequestMethod.GET)
//    @ResponseBody
//    public Mark newMark()
//    {
//        Mark x=new Mark();
//        x.setText("text");
//        x.setTitle("title");
//        x.setPrice(4);
//        x.setDate(new Date());
//        x.setLat(54.1);
//        x.setLng(54.3);
//        x.setUser("user");
//        x.setType("phot");
//        return  markRepository.saveAndFlush(x);
//    }
