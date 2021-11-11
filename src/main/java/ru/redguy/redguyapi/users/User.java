package ru.redguy.redguyapi.users;

import ru.redguy.redguyapi.utils.RequestUtil;

public class User implements RequestUtil.ApiResponse {

    protected int id;
    protected String login;
    protected String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
