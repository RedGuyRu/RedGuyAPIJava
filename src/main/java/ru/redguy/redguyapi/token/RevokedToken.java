package ru.redguy.redguyapi.token;

import ru.redguy.redguyapi.utils.RequestUtil;

public class RevokedToken implements RequestUtil.ApiResponse {
    protected int id;

    public int getId() {
        return id;
    }
}
