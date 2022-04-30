package com.nhnacademy.controller.get;

import com.nhnacademy.board.Post;
import com.nhnacademy.command.Command;
import com.nhnacademy.repository.PostDataRepository;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BoardRemoveGetController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        ServletContext servletContext = req.getServletContext();
//        long count = 1;
//        for (Post post : PostDataRepository.getInstance().getPosts()) {
//            post.setId(count++);
//        }
//        servletContext.setAttribute("count", count);
        session.setAttribute("posts", PostDataRepository.getInstance().getPosts());

        return "/board.jsp";
    }
}
