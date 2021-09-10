package ru.redguy.redguyapi.math;

import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.RequestUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Math {

    private final Map<String, String> options;

    public Math(Map<String, String> options) {
        this.options = options;
    }

    public GetResponse get(NumberLevels level, int number) throws ApiError, IOException {
        return RequestUtil.mainGet("math/get",GetResponse.class,options,new HashMap<String, Object>() {{
            put("level",level.getLevel());
            put("number",String.valueOf(number));
        }});
    }

    public static class GetResponse implements RequestUtil.ApiResponse {
        protected int result;

        public int getResult() {
            return result;
        }
    }

    public MaxResponse max(NumberLevels level) throws ApiError, IOException {
        return RequestUtil.mainGet("math/max",MaxResponse.class,options,new HashMap<String, Object>() {{
            put("level",level.getLevel());
        }});
    }

    public static class MaxResponse implements RequestUtil.ApiResponse {
        protected int max;

        public int getMax() {
            return max;
        }
    }
}
