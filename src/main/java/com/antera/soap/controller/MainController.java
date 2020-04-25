package com.antera.soap.controller;

import com.antera.soap.service.ColorService;
import com.antera.soap.entity.ColorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web_service.ColorRequest;

import web_service.ColorStringRequest;

@Controller(value = "/")
public class MainController {

    @Autowired
    ColorService colorService;

    /**
     *
     * @param request {"cyan": true, "magenta": false, "yellow": true, "black": false}
     * @return {"color": "green"}
     */

    @RequestMapping(value = {"/rest"}, method = RequestMethod.POST)
    public @ResponseBody
    ColorResponse getFormattedString(@RequestBody ColorRequest request) {
        ColorResponse response = new ColorResponse();
        response.setColor(colorService.getColor(request));
        return response;
    }

    /**
     * restPathVariable/cyan&magenta&yellow&black // all is need
     */
    @RequestMapping(value = {"/restPathVariable/{cyan}&{magenta}&{yellow}&{black}"}, method = RequestMethod.GET)
    @ResponseBody
    public ColorResponse getPathVariable(
            @PathVariable String cyan, @PathVariable String magenta, @PathVariable String yellow, @PathVariable String black) {
        ColorResponse response = new ColorResponse();
        response.setColor("this service is in progress, try to get request later");
        return response;
    }

    /**
     *
     * restParams?cyan=bool&magenta=bool&yellow=bool&black=bool//not all need
     */
    @RequestMapping(value = {"/restParams"}, method = RequestMethod.GET)
    @ResponseBody
    public ColorResponse getParamsVariable(
            @RequestParam(value = "cyan", required = false) boolean cyan, @RequestParam(value = "magenta", required = false) boolean magenta,
            @RequestParam(value = "yellow", required = false) boolean yellow, @RequestParam(value = "black", required = false) boolean black) {
        ColorRequest request = new ColorRequest();
        request.setCyan(cyan);
        request.setMagenta(magenta);
        request.setYellow(yellow);
        request.setBlack(black);
        ColorResponse response = new ColorResponse();
        response.setColor(colorService.getColor(request));
        return response;
    }

    /**
    * restValues?cyan&magenta&yellow&black or restValues?cyan="cyan"&magenta="magenta"&yellow="yellow"&black="black" //not all need
     */
    @RequestMapping(value = {"/restValues"}, method = RequestMethod.GET)
    @ResponseBody
    public ColorResponse getParams(
            @RequestParam(value = "cyan", required = false) String cyan, @RequestParam(value = "magenta", required = false) String magenta,
            @RequestParam(value="yellow", required = false) String yellow, @RequestParam(value = "black", required = false) String black) {
        ColorStringRequest request = new ColorStringRequest();
        request.setCyanColor(cyan);
        request.setMagentaColor(magenta);
        request.setYellowColor(yellow);
        request.setBlackColor(black);
        ColorResponse response = new ColorResponse();
        response.setColor(colorService.getColor(request));
        return response;
    }
}
