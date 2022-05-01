package com.nhnacademy.controller.post;

import com.nhnacademy.command.Command;
import com.nhnacademy.data.User;
import com.nhnacademy.repository.UserDataRepostiory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowUserController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User profile = UserDataRepostiory.getInstance().getUser(req.getParameter("profile"));
        req.getSession().setAttribute("profileId",profile.getId());
        req.getSession().setAttribute("profileName",profile.getName());
        return "userInfo.jsp";
    }
}
