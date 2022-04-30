//package com.nhnacademy.filter;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@WebFilter(filterName = "minCountFilter", urlPatterns = "/boardRemove.do")
//public class MinCountFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
//                         FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        if (request.getMethod().equals("GET")) {
//            ServletContext servletContext = servletRequest.getServletContext();
//            Long count = (Long) servletContext.getAttribute("count");
//            if(count!=0){
//                servletContext.setAttribute("count",--count);
//            }
//            log.error("count :"+ count);
//        }
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//}