package ru.redguy.redguyapi.users;

import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.utils.RequestUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Users {
    private final Map<String, String> options;

    public Users(Map<String, String> options) {
        this.options = options;
    }

    public User info() throws ApiError, IOException {
        return RequestUtil.mainGet("v1/users/get", User.class,options, new HashMap<>());
    }
}
