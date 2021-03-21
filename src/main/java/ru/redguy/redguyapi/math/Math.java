package ru.redguy.redguyapi.math;

import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.ApiRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Math {

    private final Map<String, String> options;

    public Math(Map<String, String> options) {
        this.options = options;
    }

    public int get(NumberLevels level, int number) throws ApiError, IOException {
        return ApiRequest.mainGet("math/get",options,new HashMap<String, Object>() {{
            put("level",level.getLevel());
            put("number",String.valueOf(number));
        }}).getInt("result");
    }

    public int max(NumberLevels level) throws ApiError, IOException {
        return ApiRequest.mainGet("math/max",options,new HashMap<String, Object>() {{
            put("level",level.getLevel());
        }}).getInt("max");
    }
}
