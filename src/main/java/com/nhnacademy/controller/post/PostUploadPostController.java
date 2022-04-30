package com.nhnacademy.controller.post;

import com.nhnacademy.board.PostData;
import com.nhnacademy.command.Command;
import com.nhnacademy.data.User;
import com.nhnacademy.data.UserData;
import com.nhnacademy.repository.PostDataRepository;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nhnacademy.repository.UserDataRepostiory;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.format.DateTimeFormatter;

//게시물 업로드 Post
@Slf4j
public class PostUploadPostController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        ServletContext servletContext = req.getServletContext();
        Long count = (Long) servletContext.getAttribute("count");

        if (Objects.nonNull(session)) {
            User userData = (UserData) session.getAttribute("user");
            String title = req.getParameter("title");
            String context = req.getParameter("context");
            log.error("count"+count);
            makePostData(title, context, userData, count);
            session.setAttribute("posts", PostDataRepository.getInstance().getPosts());
            for (User user : UserDataRepostiory.getInstance().getUsers()) {
                log.error(user.getId());
            }
        }
        return "re:/postUpload.do";
    }

    public void makePostData(String title, String context, User userdata, Long count) {
        PostData postData =
            new PostData(LocalDateTime.now(), title, context, userdata.getId(), count, 0);
        PostDataRepository.getInstance().register(postData);
    }
}