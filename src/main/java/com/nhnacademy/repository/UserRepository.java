package com.nhnacademy.repository;

import com.nhnacademy.data.User;
import java.util.List;

public interface UserRepository {
    void add(User user);
    void modify(User user,String id);
    User remove(String id);

    User getUser(String id);
    List<User> getUsers();
}