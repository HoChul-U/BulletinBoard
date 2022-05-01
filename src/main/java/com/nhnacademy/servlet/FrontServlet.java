package com.nhnacademy.servlet;

import com.nhnacademy.command.Command;
import com.nhnacademy.controller.get.*;
import com.nhnacademy.controller.post.*;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@MultipartConfig(
        location = "C:\\Users\\koohh\\tmp",
        maxFileSize = -1L,
        maxRequestSize = -1L,
        fileSizeThreshold = 1024
)
@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "re:";
    private String content;
    private String userid;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 공통 처리 - 응답 content-type, character encoding 지정.
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        content = req.getParameter("content");
        userid = req.getParameter("file");
        try {
            Command command = resolveCommand(req.getServletPath(), req.getMethod());
            String view = command.execute(req, resp);
            if (view.startsWith(REDIRECT_PREFIX)) {
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
            } else {
                RequestDispatcher rd = rd = req.getRequestDispatcher(view);
                rd.include(req, resp);
            }
        } catch (Exception ex) {
            log.error("", ex);
            req.setAttribute("exception", ex);
            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req, resp);
        }
    }

    private Command resolveCommand(String servletPath, String method) {
        Command command = null;

        if ("/board.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new LoginProcessController();
        } else if (("/board.do").equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new LoginPostController();
        } else if (("/logout.do").equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new LogoutController();
        } else if ("/membership.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new MemberShipPostController();
        } else if (("/postUpload.do").equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new PostUploadPostController();
        } else if (("/postUpload.do").equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new PostUploadGetController();
        } else if ("/adminPage.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new AdminPageGetController();
        } else if ("/adminMembership.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new AdminMemberShipController();
        } else if ("/adminMembershipFix.do".equals(servletPath) &&
                "POST".equalsIgnoreCase(method)) {
            command = new AdminMemberModifyController();
        } else if ("/adminMembershipRemove.do".equals(servletPath) &&
                "POST".equalsIgnoreCase(method)) {
            command = new AdminMemberRemoveController();
        } else if ("/boardRemove.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new BoardRemoveController();
        } else if ("/boardRemove.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new BoardRemoveGetController();
        } else if ("/boardModify.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new BoardModifyController();
        } else if ("/postUpdate.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new PostUpdateController();
        } else if ("/showContent.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new showContentController(content);
        } else if ("/lang.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new CheckLang();
        } else if ("/loadImage.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new ShowImageController(userid);
        } else if ("/showUsers.do".equals(servletPath) && "GET".equalsIgnoreCase(method)){
            command = new ShowUserController();
        }
        return command;
    }
}
