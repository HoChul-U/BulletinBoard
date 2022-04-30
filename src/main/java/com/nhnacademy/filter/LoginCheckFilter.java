package com.nhnacademy.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*", initParams = {
    @WebInitParam(name = "blacklist", value = "/\n"
        + "/JoinMemberShip.jsp\n"
        + "/LoginFrom.jsp")
})
@Slf4j
public class LoginCheckFilter implements Filter {
    List<String> urls = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String blacklist = filterConfig.getInitParameter("blacklist");
        log.error("blacklist={}", blacklist);

        urls = Arrays.stream(blacklist.split("\n"))
                     .map(String::trim)
                     .collect(Collectors.toList());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        String requestUri = ((HttpServletRequest) servletRequest).getRequestURI();

        // blacklist
        if (urls.contains(requestUri)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
            if (Objects.isNull(session)) {
                ((HttpServletResponse) servletResponse).sendRedirect("/LoginForm.html");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
        }
}
