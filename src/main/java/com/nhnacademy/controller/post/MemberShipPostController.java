package com.nhnacademy.controller.post;

import com.nhnacademy.command.Command;
import com.nhnacademy.data.User;
import com.nhnacademy.data.UserData;
import com.nhnacademy.repository.UserDataRepostiory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberShipPostController implements Command {
    private User user;
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        if(CheckOverLap(req)){
            UserDataRepostiory
                .getInstance()
                .add(user);
            return "LoginForm.jsp";
        }
        return "re:JoinMemberShip.jsp";
    }

    private boolean CheckOverLap(HttpServletRequest req) {
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        String name = req.getParameter("name");
        String profile = req.getParameter("profile");
        for (User user :UserDataRepostiory.getInstance().getUsers() ) {
            if(user.getId().equals(id)){
                log.error("ID 가중복입니다.");
                return false;
            }
        };
        this.user = new UserData(id, pwd, name, profile);
        return true;
    }
}
