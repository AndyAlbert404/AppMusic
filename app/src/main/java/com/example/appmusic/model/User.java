package com.example.appmusic.model;

public class User {
    private String Username;
    private String Password;
    private String Email;

    public User() {

    }


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }




    public User(String username, String password, String email, String phonenumber) {
        this.Username = username;
        this.Password = password;
        this.Email = email;
    }


}
