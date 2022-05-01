package com.nhnacademy.controller.post;

import com.nhnacademy.command.Command;
import com.nhnacademy.data.User;
import com.nhnacademy.data.UserData;
import com.nhnacademy.repository.UserDataRepostiory;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
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
public class AdminMemberModifyController implements Command {
    private static final String CONTENT_DISPOSITION = "Content-Disposition";
    private static final String UPLOAD_DIR = "C:\\Users\\koohh\\tmp";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession(false);
        String id = req.getParameter("id");
        if (Objects.nonNull(session)) {
            if ((UserDataRepostiory.getInstance().getUser(id).getId()).contains(id)) {
                User user = new UserData(req.getParameter("c_id"), req.getParameter("pwd"), req.getParameter("name"), "");
                Part part = req.getPart("profile");
                log.error(part + "");

                String contentDisposition = part.getHeader(CONTENT_DISPOSITION);
                if (contentDisposition.contains("filename=")) {
                    String fileName = extractFileName(contentDisposition);

                    if (part.getSize() > 0) {
                        part.write(UPLOAD_DIR + File.separator + fileName);
                        user.setProfileFileName(UPLOAD_DIR + File.separator + fileName);
                        UserDataRepostiory.getInstance().modify(user, id);
                        log.error("파일경로 : " + user.getProfileFileName());
                        log.error("파일경로 : " + UPLOAD_DIR + File.separator + fileName);
                        part.delete();
                    }
                } else {
                    String formValue = req.getParameter(part.getName());
                    log.error("{}={}", part.getName(), formValue);
                }
            }
            session.setAttribute("userlist", UserDataRepostiory.getInstance().getUsers());
        }
        return "re:Admin.jsp";
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
