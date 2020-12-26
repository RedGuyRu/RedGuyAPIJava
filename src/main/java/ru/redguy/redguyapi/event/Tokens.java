package ru.redguy.redguyapi.event;

import org.json.JSONObject;
import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.ApiRequest;
import ru.redguy.redguyapi.ValueChange;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Tokens {
    private final Map<String, String> options;

    public Tokens(Map<String, String> options) {
        this.options = options;
    }

    public int get(String nick) throws IOException, ApiError {
        return ApiRequest.mainGet("event/tokens/get",this.options,new HashMap<String, Object>() {{
            put("nick",nick);
        }}).getInt("tokens");
    }

    public ValueChange add(String nick, int tokens) throws IOException, ApiError {
        JSONObject json = ApiRequest.mainGet("event/tokens/add",this.options,new HashMap<String, Object>() {{
            put("nick",nick);
            put("tokens",tokens);
        }});
        return new ValueChange(json.getInt("oldTokens"),json.getInt("newTokens"));
    }

    public ValueChange set(String nick, int tokens) throws IOException, ApiError {
        JSONObject json = ApiRequest.mainGet("event/tokens/set",this.options,new HashMap<String, Object>() {{
            put("nick",nick);
            put("tokens",tokens);
        }});
        return new ValueChange(json.getInt("oldTokens"),json.getInt("newTokens"));
    }
}
