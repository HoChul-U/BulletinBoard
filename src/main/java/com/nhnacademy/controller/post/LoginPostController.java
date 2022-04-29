package com.nhnacademy.controller.post;

import com.nhnacademy.command.Command;
import com.nhnacademy.data.User;
import com.nhnacademy.repository.PostDataRepository;
import com.nhnacademy.repository.UserDataRepostiory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginPostController implements Command {
    private User admin;

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String pwd = req.getParameter("password");
        for (User user : UserDataRepostiory.getInstance().getUsers()) {
            if (id.equals(user.getId()) && pwd.equals(user.getPassword())) {
                HttpSession session = req.getSession();
                session.setAttribute("checkAdmin",adminCheck(user));
                session.setAttribute("user", user);
                session.setAttribute("posts", PostDataRepository.getInstance().getPosts());
                return "re:/board.do";
            }
        }
        return "LoginForm.jsp";
    }
    public boolean adminCheck(User user){
        if(user.getId().equals("admin")){
            return true;
        }
        return false;
    }
}
