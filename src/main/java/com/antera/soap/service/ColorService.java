package com.antera.soap.service;


import web_service.ColorRequest;
import web_service.ColorStringRequest;

public interface ColorService {
    String getColor(ColorRequest colors);
    String getColor(ColorStringRequest colors);
}
