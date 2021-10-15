package ru.redguy.redguyapi.token;

import ru.redguy.redguyapi.RequestUtil;

public class IssuedToken implements RequestUtil.ApiResponse {
    protected int id;
    protected String token;

    public int getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
