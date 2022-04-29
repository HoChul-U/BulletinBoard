package com.nhnacademy.data;

public class UserData implements User{
    private String id;
    private String pwd;
    private String name;
    private String profileName;

    public UserData(String id, String pwd, String name, String profileName) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.profileName = profileName;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        return this.pwd;
    }

    @Override
    public void setPassword(String password) {
        this.pwd = password;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getProfileFileName() {
        return this.profileName;
    }

    @Override
    public void setProfileFileName(String profileFileName) {
        this.profileName = profileFileName;
    }
}
