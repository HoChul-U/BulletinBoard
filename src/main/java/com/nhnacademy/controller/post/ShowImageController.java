package com.nhnacademy.controller.post;

import com.nhnacademy.command.Command;
import com.nhnacademy.data.User;
import com.nhnacademy.repository.UserDataRepostiory;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class ShowImageController implements Command {
    private String userid;

    public ShowImageController(String profileName) {
        this.userid = profileName;
    }
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = UserDataRepostiory.getInstance().getUser(userid);
        ServletOutputStream bout = resp.getOutputStream();
        FileInputStream f = new FileInputStream(user.getProfileFileName());
        int length;
        byte[] buffer = new byte[10];
        while((length=f.read(buffer))!= 1){
            bout.write(buffer,0,length);
        }
        return "/adminPage.do";
    }
}
