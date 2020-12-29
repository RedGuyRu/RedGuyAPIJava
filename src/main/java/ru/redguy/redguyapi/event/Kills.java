package ru.redguy.redguyapi.event;

import org.json.JSONObject;
import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.ApiRequest;
import ru.redguy.redguyapi.ValueChange;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Kills {
    private final Map<String, String> options;

    public Kills(Map<String, String> options) {
        this.options = options;
    }

    public int get(String nick) throws IOException, ApiError {
        return ApiRequest.mainGet("event/kills/get",this.options,new HashMap<String, Object>() {{
            put("nick",nick);
        }}).getInt("kills");
    }

    public ValueChange add(String nick, int kills) throws IOException, ApiError {
        JSONObject json = ApiRequest.mainGet("event/kills/add",this.options,new HashMap<String, Object>() {{
            put("nick",nick);
            put("kills",kills);
        }});
        return new ValueChange(json.getInt("oldKills"),json.getInt("newKills"));
    }

    public ValueChange set(String nick, int kills) throws IOException, ApiError {
        JSONObject json = ApiRequest.mainGet("event/kills/set",this.options,new HashMap<String, Object>() {{
            put("nick",nick);
            put("kills",kills);
        }});
        return new ValueChange(json.getInt("oldKills"),json.getInt("newKills"));
    }
}
