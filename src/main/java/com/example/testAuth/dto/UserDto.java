package com.example.testAuth.dto;

public class UserDto {
    private String firstname;
    private String login;
    private String pass;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public UserDto(String firstname, String login, String pass) {
        this.firstname = firstname;
        this.login = login;
        this.pass = pass;
    }

    public UserDto() {
    }
}
