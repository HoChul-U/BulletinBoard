package com.nhnacademy.controller.post;

import com.nhnacademy.command.Command;
import com.nhnacademy.repository.PostDataRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class showContentController implements Command {
    private String content;

    public showContentController(String content) {
        this.content = content;
    }
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.parseLong(content);
        PostDataRepository.getInstance().getPost(id).increaseViewCount();
        HttpSession session = req.getSession(false);
        session.setAttribute("postTitle",PostDataRepository.getInstance().getPost(id).getTitle());
        session.setAttribute("postContent",PostDataRepository.getInstance().getPost(id).getContent());
        session.setAttribute("posts", PostDataRepository.getInstance().getPosts());
        return "showContent.jsp";
    }
}
