package com.nhnacademy.controller.get;

import com.nhnacademy.command.Command;
import com.nhnacademy.repository.UserDataRepostiory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class AdminPageGetController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        if(Objects.isNull(req.getSession(false))){
            throw new IllegalArgumentException();
        }
        HttpSession session = req.getSession(false);
        session.setAttribute("userlist", UserDataRepostiory.getInstance().getUsers());
        return "Admin.jsp";
    }
}
