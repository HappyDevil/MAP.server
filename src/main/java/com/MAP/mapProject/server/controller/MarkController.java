package com.MAP.mapProject.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mark")
public class MarkController {
    @RequestMapping(value="/get",method= RequestMethod.GET)
    @ResponseBody
    public String getMarks(ModelMap model)
    {
        return "My mark";
    }

}
