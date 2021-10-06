package ru.redguy.redguyapi;

import ru.redguy.redguyapi.minecraft.Minecraft;

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
        return options;
    }

    public Minecraft minecraft() {return new Minecraft(options);}
}
