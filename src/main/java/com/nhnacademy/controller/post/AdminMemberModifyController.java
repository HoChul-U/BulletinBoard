package com.nhnacademy.controller.post;

import com.nhnacademy.command.Command;
import com.nhnacademy.data.User;
import com.nhnacademy.data.UserData;
import com.nhnacademy.repository.UserDataRepostiory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class AdminMemberModifyController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        String id = req.getParameter("id");
        if(Objects.nonNull(session)){
            if((UserDataRepostiory.getInstance().getUser(id).getId()).contains(id)){
                User user = new UserData(req.getParameter("c_id"), req.getParameter("pwd"), req.getParameter("name"),"");
                UserDataRepostiory.getInstance().modify(user,id);
            }
            session.setAttribute("userlist",UserDataRepostiory.getInstance().getUsers());
        }
        return "re:Admin.jsp";
    }
}
