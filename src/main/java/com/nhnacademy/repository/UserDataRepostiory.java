package com.nhnacademy.repository;

import com.nhnacademy.data.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserDataRepostiory implements UserRepository{
    private static final UserDataRepostiory user = new UserDataRepostiory();

    private static final Map<String, User> userDataMap = new ConcurrentHashMap<>();

    private UserDataRepostiory(){}

    public static UserDataRepostiory getInstance(){
        return user;
    }

    public Map<String, User> getUserDataMap() {
        return userDataMap;
    }

    @Override
    public void add(User user) {
        getUserDataMap().put(user.getId(),user);
    }

    @Override
    public void modify(User user,String id){
        if(userDataMap.containsKey(id)){
            getUserDataMap().put(user.getId(), user);
            getUserDataMap().remove(id);
        }
        else throw new IllegalStateException();
    }

    @Override
    public User remove(String id) {
        return getUserDataMap().remove(id);
    }

    @Override
    public User getUser(String id) {
        return getUserDataMap().get(id);
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(getUserDataMap().values());
    }
}
