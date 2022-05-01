package com.nhnacademy.controller.get;

import com.nhnacademy.command.Command;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckLang implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getServletContext();
        String lang= (String) servletContext.getAttribute("lang");
        if(lang.contains("ko")){
            servletContext.setAttribute("lang","en");
        } else {
            servletContext.setAttribute("lang","ko");
        }
        return "LoginForm.jsp";
    }
}
