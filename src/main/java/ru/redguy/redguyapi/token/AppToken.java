package ru.redguy.redguyapi.token;

import ru.redguy.redguyapi.RequestUtil;

public class AppToken implements RequestUtil.ApiResponse {
    protected int id;
    protected String[] scopes;
    protected App app;

    public int getId() {
        return id;
    }

    public String[] getScopes() {
        return scopes;
    }

    public App getApp() {
        return app;
    }
}
