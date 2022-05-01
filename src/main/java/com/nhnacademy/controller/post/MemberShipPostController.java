package com.nhnacademy.controller.post;

import com.nhnacademy.command.Command;
import com.nhnacademy.data.User;
import com.nhnacademy.data.UserData;
import com.nhnacademy.repository.UserDataRepostiory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@MultipartConfig(
        location = "C:\\Users\\koohh\\tmp",
        maxFileSize = -1L,
        maxRequestSize = -1L,
        fileSizeThreshold = 1024
)
public class MemberShipPostController implements Command {
    private static final String CONTENT_DISPOSITION = "Content-Disposition";
    private static final String UPLOAD_DIR = "C:\\Users\\koohh\\tmp";
    private User user;

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (CheckOverLap(req)) {
            UserDataRepostiory
                    .getInstance()
                    .add(user);
            log.error("part:"+req.getPart("profile"));
            for (Part part : req.getParts()) {
                log.error(part+"");
                String contentDisposition = part.getHeader(CONTENT_DISPOSITION);

                if (contentDisposition.contains("filename=")) {
                    String fileName = extractFileName(contentDisposition);

                    if (part.getSize() > 0) {
                        part.write(UPLOAD_DIR + File.separator + fileName);
                        user.setProfileFileName(UPLOAD_DIR + File.separator + fileName);
                        log.error("파일경로 : "+user.getProfileFileName());
                        log.error("파일경로 : "+ UPLOAD_DIR + File.separator + fileName);
                        part.delete();
                    }
                } else {
                    String formValue = req.getParameter(part.getName());
                    log.error("{}={}", part.getName(), formValue);
                }
            }
            return "LoginForm.jsp";
        }
        return "re:JoinMemberShip.jsp";
    }

    private boolean CheckOverLap(HttpServletRequest req) {
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        String name = req.getParameter("name");
        String profile = req.getParameter("profile");
        for (User user : UserDataRepostiory.getInstance().getUsers()) {
            if (user.getId().equals(id) || pwd.equals("") || name.equals("")) {
                log.error("잘못된 입력입니다.");
                return false;
            }
        }
        ;
        this.user = new UserData(id, pwd, name, profile);
        return true;
    }

    private String extractFileName(String contentDisposition) {
        for (String token : contentDisposition.split(";")) {
            if (token.trim().startsWith("filename")) {
                String fileName = token.substring(token.indexOf("=") + 1).trim().replace("\"", "");
                int index = fileName.lastIndexOf(File.separator);

                return fileName.substring(index + 1);
            }
        }

        return null;
    }
}
