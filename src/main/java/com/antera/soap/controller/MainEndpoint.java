package com.antera.soap.controller;

import com.antera.soap.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import web_service.ColorRequest;
import web_service.ColorResponse;

@Endpoint
public class MainEndpoint {

    @Autowired
    ColorService colorService;

    @PayloadRoot(namespace = "web-service", localPart = "ColorRequest")
    @ResponsePayload
    public ColorResponse ColorRequest(@RequestPayload ColorRequest request) {
        ColorResponse response = new ColorResponse();
        response.setColor(colorService.getColor(request));
        return response;
    }
}
