package com.nhnacademy.controller.get;

import com.nhnacademy.command.Command;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PostUploadGetController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        if (Objects.isNull(session)) {
            return "error.jsp";
        }
        return "board.jsp";
    }
}
