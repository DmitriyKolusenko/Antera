package com.antera.soap.service.impl;

import com.antera.soap.service.ColorService;
import org.springframework.stereotype.Service;
import web_service.ColorRequest;
import web_service.ColorStringRequest;

import java.util.Objects;

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

    @Override
    public String getColor(ColorStringRequest colors) {
        if (!Objects.isNull(colors.getCyanColor()) && !Objects.isNull(colors.getMagentaColor()) && !Objects.isNull(colors.getYellowColor()))
            return "black";
        if (!Objects.isNull(colors.getBlackColor()))
            return "black";
        if (!Objects.isNull(colors.getCyanColor()) && !Objects.isNull(colors.getMagentaColor()))
            return "blue";
        if (!Objects.isNull(colors.getCyanColor()) && !Objects.isNull(colors.getYellowColor()))
            return "green";
        if (!Objects.isNull(colors.getMagentaColor()) && !Objects.isNull(colors.getYellowColor()))
            return "red";
        if (!Objects.isNull(colors.getCyanColor()))
            return "cyan";
        if (!Objects.isNull(colors.getMagentaColor()))
            return "magenta";
        if (!Objects.isNull(colors.getYellowColor()))
            return "yellow";
        return "white";
    }
}
