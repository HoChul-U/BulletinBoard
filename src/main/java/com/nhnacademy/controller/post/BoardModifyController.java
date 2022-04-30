package com.nhnacademy.controller.post;

import com.nhnacademy.board.Post;
import com.nhnacademy.command.Command;
import com.nhnacademy.data.User;
import com.nhnacademy.data.UserData;
import com.nhnacademy.repository.PostDataRepository;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BoardModifyController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        User user = (UserData)session.getAttribute("user");
        String postId = req.getParameter("modifyId");
        String postWriter = req.getParameter("modify_btn");
        if (user.getId().contains(postWriter) || postWriter.contains("admin")) {
            Post updatePost = PostDataRepository.getInstance().getPost(
                Long.parseLong(postId));
            session.setAttribute("updatePost",updatePost);
            return "PostUpdate.jsp";
        }
        return "re:board.jsp";
    }
}
