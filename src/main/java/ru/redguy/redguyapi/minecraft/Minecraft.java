package ru.redguy.redguyapi.minecraft;

import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.RequestUtil;
import ru.redguy.redguyapi.math.Math;
import ru.redguy.redguyapi.math.NumberLevels;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Minecraft {

    private final Map<String, String> options;

    public Minecraft(Map<String, String> options) {
        this.options = options;
    }

    public ServerInfo serverinfo(String host) throws ApiError, IOException {
        return RequestUtil.mainGet("v1/minecraft/serverinfo", ServerInfo.class,options,new HashMap<String, Object>() {{
            put("host",host);
        }});
    }
}
