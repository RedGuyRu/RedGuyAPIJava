package ru.redguy.redguyapi;

import ru.redguy.redguyapi.math.Math;

import java.util.HashMap;
import java.util.Map;

public class RedGuyApi {

    private final Map<String, String> options;
    private final String token;

    public RedGuyApi(String token) {
        this.options = verifyOptions(new HashMap<>());
        this.token = token;
    }

    public RedGuyApi(String token, Map<String, String> options) {
        this.options = verifyOptions(options);
        this.token = token;
    }

    private Map<String, String> verifyOptions(Map<String, String> options) {
        if(!options.containsKey("v")) {
            options.put("v","1.0");
        }
        return options;
    }

    public Math math() {
        return new Math(token,options);
    }
}
