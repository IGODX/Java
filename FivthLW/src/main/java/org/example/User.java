package org.example;

public class User {
    private String userName;
    private String password;

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString(){
        return "userName: " + userName + " password : " + password;
    }
}
