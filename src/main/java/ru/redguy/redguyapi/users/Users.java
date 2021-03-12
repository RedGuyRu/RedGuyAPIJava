package ru.redguy.redguyapi.users;

import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.ApiRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Users {

    private Map<String, String> options;

    public Users(Map<String, String> options) {
        this.options = options;
    }

    public User get(int id, Additional additional) throws ApiError, IOException {
        return new User(ApiRequest.mainGet("users/get",options,new HashMap<String, Object>() {{
            put("id",id);
            put("additional",additional.getResult());
        }}));
    }

    public User get(int id) throws ApiError, IOException {
        return new User(ApiRequest.mainGet("users/get",options,new HashMap<String, Object>() {{
            put("id",id);
        }}));
    }
}