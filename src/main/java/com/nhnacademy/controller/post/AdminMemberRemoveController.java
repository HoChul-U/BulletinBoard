package com.nhnacademy.controller.post;

import com.nhnacademy.command.Command;
import com.nhnacademy.repository.UserDataRepostiory;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminMemberRemoveController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        if (Objects.nonNull(session)) {
            String id = req.getParameter("id");
            UserDataRepostiory.getInstance().remove(id);
            session.setAttribute("userlist", UserDataRepostiory.getInstance().getUsers());
        }
        return "re:Admin.jsp";
    }
}
