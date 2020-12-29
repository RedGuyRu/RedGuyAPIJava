package ru.redguy.redguyapi;

import ru.redguy.redguyapi.event.Event;
import ru.redguy.redguyapi.math.Math;
import ru.redguy.redguyapi.users.Users;

import java.util.HashMap;
import java.util.Map;

public class RedGuyApi {

    private final Map<String, String> options;

    public RedGuyApi(String token) {
        this.options = verifyOptions(new HashMap<>(), token);
    }

    public RedGuyApi(String token, Map<String, String> options) {
        this.options = verifyOptions(options, token);
    }

    private Map<String, String> verifyOptions(Map<String, String> options, String token) {
        options.put("token", token);
        if(!options.containsKey("v")) {
            options.put("v","1.0");
        }
        return options;
    }

    public Math math() {
        return new Math(options);
    }

    public Users users() {return new Users(options); }

    public Event event() {return new Event(options); }
}
