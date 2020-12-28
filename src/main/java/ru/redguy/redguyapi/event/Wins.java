package ru.redguy.redguyapi.event;

import org.json.JSONObject;
import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.ApiRequest;
import ru.redguy.redguyapi.ValueChange;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Wins {
    private final Map<String, String> options;

    public Wins(Map<String, String> options) {
        this.options = options;
    }

    public int get(String nick) throws IOException, ApiError {
        return ApiRequest.mainGet("event/wins/get",this.options,new HashMap<String, Object>() {{
            put("nick",nick);
        }}).getInt("wins");
    }

    public ValueChange add(String nick, int wins) throws IOException, ApiError {
        JSONObject json = ApiRequest.mainGet("event/wins/add",this.options,new HashMap<String, Object>() {{
            put("nick",nick);
            put("wins",wins);
        }});
        return new ValueChange(json.getInt("oldWins"),json.getInt("newWins"));
    }

    public ValueChange set(String nick, int wins) throws IOException, ApiError {
        JSONObject json = ApiRequest.mainGet("event/wins/set",this.options,new HashMap<String, Object>() {{
            put("nick",nick);
            put("wins",wins);
        }});
        return new ValueChange(json.getInt("oldWins"),json.getInt("newWins"));
    }
}
