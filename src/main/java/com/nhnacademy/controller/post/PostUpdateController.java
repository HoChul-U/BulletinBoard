package com.nhnacademy.controller.post;

import com.nhnacademy.board.Post;
import com.nhnacademy.board.PostData;
import com.nhnacademy.command.Command;
import com.nhnacademy.data.User;
import com.nhnacademy.data.UserData;
import com.nhnacademy.repository.PostDataRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PostUpdateController implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        String update_title = req.getParameter("update_title");
        String  context = req.getParameter("update_context");
        Post updatePost = (PostData) session.getAttribute("updatePost");
        updatePost.setContent(context);
        updatePost.setTitle(update_title);
        session.setAttribute("posts", PostDataRepository.getInstance().getPosts());
        return "board.jsp";
    }
}
