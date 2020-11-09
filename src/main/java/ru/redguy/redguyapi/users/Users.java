package ru.redguy.redguyapi.users;

import org.json.JSONObject;
import ru.redguy.redguyapi.ApiError;
import ru.redguy.rednetworker.clients.http.ApacheFluentAPI;
import ru.redguy.rednetworker.clients.http.exceptions.OpenConnectionException;
import ru.redguy.rednetworker.clients.http.exceptions.URLException;

import java.util.HashMap;
import java.util.Map;

public class Users {

    private Map<String, String> options;
    private ApacheFluentAPI apacheFluentAPI;

    public Users(Map<String, String> options) {
        this.options = options;
        apacheFluentAPI = new ApacheFluentAPI();
    }

    public User get(int id, Additional additional) throws OpenConnectionException, URLException, ApiError {
        String data = apacheFluentAPI.getString("https://api.redguy.ru/users/get/", new HashMap<String, Object>() {{
            put("token", options.get("token"));
            put("v", options.get("v"));
            put("id",id);
            put("additional",additional.getResult());
        }});
        JSONObject json = new JSONObject(data);
        if (json.getInt("code") != 1) {
            throw new ApiError(json.getInt("code"),json.getString("comment"));
        } else {
            return new User(json.getJSONObject("response"));
        }
    }

    public User get(int id) throws OpenConnectionException, URLException, ApiError {
        String data = apacheFluentAPI.getString("https://api.redguy.ru/users/get/", new HashMap<String, Object>() {{
            put("token", options.get("token"));
            put("v", options.get("v"));
            put("id",id);
        }});
        JSONObject json = new JSONObject(data);
        if (json.getInt("code") != 1) {
            throw new ApiError(json.getInt("code"),json.getString("comment"));
        } else {
            return new User(json.getJSONObject("response"));
        }
    }
}