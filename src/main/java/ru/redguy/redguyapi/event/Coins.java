package ru.redguy.redguyapi.event;

import org.json.JSONObject;
import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.ApiRequest;
import ru.redguy.redguyapi.ValueChange;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Coins {
    private final Map<String, String> options;

    public Coins(Map<String, String> options) {
        this.options = options;
    }

    public int get(String nick) throws IOException, ApiError {
        return ApiRequest.mainGet("event/coins/get",this.options,new HashMap<String, Object>() {{
            put("nick",nick);
        }}).getInt("coins");
    }

    public ValueChange add(String nick, int coins) throws IOException, ApiError {
        JSONObject json = ApiRequest.mainGet("event/coins/add",this.options,new HashMap<String, Object>() {{
            put("nick",nick);
            put("coins",coins);
        }});
        return new ValueChange(json.getInt("oldCoins"),json.getInt("newCoins"));
    }

    public ValueChange set(String nick, int coins) throws IOException, ApiError {
        JSONObject json = ApiRequest.mainGet("event/coins/set",this.options,new HashMap<String, Object>() {{
            put("nick",nick);
            put("coins",coins);
        }});
        return new ValueChange(json.getInt("oldCoins"),json.getInt("newCoins"));
    }
}
