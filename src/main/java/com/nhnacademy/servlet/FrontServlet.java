package com.nhnacademy.servlet;

import com.nhnacademy.command.Command;
import com.nhnacademy.controller.get.AdminPageGetController;
import com.nhnacademy.controller.get.BoardRemoveGetController;
import com.nhnacademy.controller.get.LoginProcessController;
import com.nhnacademy.controller.get.PostUploadGetController;
import com.nhnacademy.controller.post.AdminMemberModifyController;
import com.nhnacademy.controller.post.AdminMemberRemoveController;
import com.nhnacademy.controller.post.AdminMemberShipController;
import com.nhnacademy.controller.post.BoardModifyController;
import com.nhnacademy.controller.post.BoardRemoveController;
import com.nhnacademy.controller.post.LoginPostController;
import com.nhnacademy.controller.post.LogoutController;
import com.nhnacademy.controller.post.MemberShipPostController;
import com.nhnacademy.controller.post.PostUpdateController;
import com.nhnacademy.controller.post.PostUploadPostController;
import com.nhnacademy.controller.post.showContentController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "re:";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        // 공통 처리 - 응답 content-type, character encoding 지정.
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try {
            Command command = resolveCommand(req.getServletPath(), req.getMethod());
            String view = command.execute(req, resp);
            if (view.startsWith(REDIRECT_PREFIX)) {
                // `redirect:`로 시작하면 redirect 처리.
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
            } else {
                // redirect 아니면 JSP에게 view 처리를 위임하여 그 결과를 include시킴.
                RequestDispatcher rd = rd = req.getRequestDispatcher(view);
                rd.include(req, resp);
            }
        } catch (Exception ex) {
            // 에러가 발생한 경우는 error page로 지정된 `/error.jsp`에게 view 처리를 위임.
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
        } else if ("/showContent.do".equals(servletPath) && "GET".equalsIgnoreCase(method)){
            command= new showContentController();
        }
        return command;
    }
}
