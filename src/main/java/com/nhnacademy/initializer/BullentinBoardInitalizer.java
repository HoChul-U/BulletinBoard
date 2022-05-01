package com.nhnacademy.initializer;

import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

import com.nhnacademy.repository.UserDataRepostiory;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@HandlesTypes({
    javax.servlet.http.HttpServlet.class,
    javax.servlet.Filter.class,
    javax.servlet.ServletContextListener.class,
    javax.servlet.http.HttpSessionListener.class
})
public class BullentinBoardInitalizer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext)
        throws ServletException {
        servletContext.setAttribute("count",0L);
        servletContext.setAttribute("lang","en");
        servletContext.setAttribute("loginCount",0);
    }
}
