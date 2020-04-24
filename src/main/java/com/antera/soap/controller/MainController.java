package com.antera.soap.controller;

import com.antera.soap.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import web_service.ColorRequest;
import web_service.ColorResponse;

@Controller
public class MainController {

    @Autowired
    ColorService colorService;


    @RequestMapping(value = {"/rest"}, method = RequestMethod.POST)
    public @ResponseBody
    ColorResponse getFormattedString(@RequestBody ColorRequest request) {
        ColorResponse response = new ColorResponse();
        response.setColor(colorService.getColor(request));
        return response;
    }
}
