package com.nhnacademy.listener;

import com.nhnacademy.data.User;
import com.nhnacademy.data.UserData;
import com.nhnacademy.repository.PostDataRepository;
import com.nhnacademy.repository.UserDataRepostiory;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        User admin = new UserData("admin", "12345", "admin", "admin");
        UserDataRepostiory.getInstance().add(admin);
    }
}
