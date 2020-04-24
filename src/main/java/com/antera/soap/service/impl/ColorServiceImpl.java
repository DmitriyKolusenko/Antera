package com.antera.soap.service.impl;

import com.antera.soap.service.ColorService;
import org.springframework.stereotype.Service;
import web_service.ColorRequest;

@Service
public class ColorServiceImpl implements ColorService{
    @Override
    public String getColor(ColorRequest colors) {
        if (colors.isCyan() && colors.isMagenta() && colors.isYellow())
            return "black";
        if (colors.isBlack())
            return "black";
        if (colors.isCyan() && colors.isMagenta())
            return "blue";
        if (colors.isCyan() && colors.isYellow())
            return "green";
        if (colors.isMagenta() && colors.isYellow())
            return "red";
        if (colors.isCyan())
            return "cyan";
        if (colors.isMagenta())
            return "magenta";
        if (colors.isYellow())
            return "yellow";
        return "white";
    }
}
