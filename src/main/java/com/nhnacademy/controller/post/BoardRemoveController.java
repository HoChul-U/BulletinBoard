package com.nhnacademy.controller.post;

import com.nhnacademy.board.Post;
import com.nhnacademy.board.PostData;
import com.nhnacademy.command.Command;
import com.nhnacademy.data.User;
import com.nhnacademy.data.UserData;
import com.nhnacademy.repository.PostDataRepository;
import java.util.Objects;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BoardRemoveController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        ServletContext servletContext = req.getServletContext();
        if (Objects.nonNull(session)) {
            String post_writer = req.getParameter("remove_btn");
            String postId = req.getParameter("postId");
            User user = (UserData) req.getSession().getAttribute("user");
            long max =0;
            if(user.getId().contains(post_writer) || user.getId().contains("admin")){
                PostDataRepository.getInstance().remove(Long.parseLong(postId));
                session.setAttribute("removePostId",postId);
                for (Post post : PostDataRepository.getInstance().getPosts()) {
                    if(post.getId() > Long.parseLong(postId)){
                        max= Math.max(max,post.getId()-1);
                        post.setId(post.getId() - 1);
                    }
                }
            }
            servletContext.setAttribute("count",max);
        }
        return "re:boardRemove.do";
    }
}
