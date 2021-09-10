package ru.redguy.redguyapi.event;

import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.RequestUtil;
import ru.redguy.redguyapi.ValueChange;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Kills {
    private final Map<String, String> options;

    public Kills(Map<String, String> options) {
        this.options = options;
    }

    public GetResponse get(String nick) throws IOException, ApiError {
        return RequestUtil.mainGet("event/kills/get",GetResponse.class,this.options,new HashMap<String, Object>() {{
            put("nick",nick);
        }});
    }

    public static class GetResponse implements RequestUtil.ApiResponse {
        protected int kills;

        public int getKills() {
            return kills;
        }
    }

    public AddResponse add(String nick, int kills) throws IOException, ApiError {
        return RequestUtil.mainGet("event/kills/add",AddResponse.class,this.options,new HashMap<String, Object>() {{
            put("nick",nick);
            put("kills",kills);
        }});
    }

    public static class AddResponse implements RequestUtil.ApiResponse {
        protected int oldKills;
        protected int newKills;

        public int getOldKills() {
            return oldKills;
        }

        public int getNewKills() {
            return newKills;
        }
    }

    public SetResponse set(String nick, int kills) throws IOException, ApiError {
        return RequestUtil.mainGet("event/kills/set",SetResponse.class,this.options,new HashMap<String, Object>() {{
            put("nick",nick);
            put("kills",kills);
        }});
    }

    public static class SetResponse implements RequestUtil.ApiResponse {
        protected int oldKills;
        protected int newKills;

        public int getOldKills() {
            return oldKills;
        }

        public int getNewKills() {
            return newKills;
        }
    }
}
