package com.snaildev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PageController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getIndexPage(final HttpServletRequest request,
                                     final HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("message", "This message is from PageController!");
        return modelAndView;
    }
}
