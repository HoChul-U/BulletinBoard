package com.nhnacademy.controller.post;

import com.nhnacademy.board.Post;
import com.nhnacademy.board.PostData;
import com.nhnacademy.command.Command;
import com.nhnacademy.data.User;
import com.nhnacademy.data.UserData;
import com.nhnacademy.repository.PostDataRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class BoardRemoveController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        ServletContext servletContext = req.getServletContext();
        if (Objects.nonNull(session)) {
            String post_writer = req.getParameter("remove_btn");
            String postId = req.getParameter("postId");
            User user = (UserData) req.getSession().getAttribute("user");
            if(user.getId().contains(post_writer) || user.getId().contains("admin")){
                PostDataRepository.getInstance().remove(Long.parseLong(postId));
                session.setAttribute("removePostId",postId);
                log.error(PostDataRepository.getInstance().getPostRepository().entrySet()+"");
                for (Post post : PostDataRepository.getInstance().getPosts()) {
                    if(post.getId() > Long.parseLong(postId)){
                        post.setId(post.getId()-1);
                        PostDataRepository.getInstance().modify(post,post.getId()+1);
                    }
                    log.error("post "+post.getId());
                }
                servletContext.setAttribute("count", (long)PostDataRepository.getInstance().getPostRepository().size());
            }
        }
        return "re:boardRemove.do";
    }
}
