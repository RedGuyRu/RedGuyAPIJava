package ru.redguy.redguyapi.event;

import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.RequestUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Wins {
    private final Map<String, String> options;

    public Wins(Map<String, String> options) {
        this.options = options;
    }

    public GetResponse get(String nick) throws IOException, ApiError {
        return RequestUtil.mainGet("event/wins/get",GetResponse.class,this.options,new HashMap<String, Object>() {{
            put("nick",nick);
        }});
    }

    public static class GetResponse implements RequestUtil.ApiResponse {
        protected int wins;

        public int getWins() {
            return wins;
        }
    }

    public AddResponse add(String nick, int wins) throws IOException, ApiError {
        return RequestUtil.mainGet("event/wins/add",AddResponse.class,this.options,new HashMap<String, Object>() {{
            put("nick",nick);
            put("wins",wins);
        }});
    }

    public static class AddResponse implements RequestUtil.ApiResponse {
        protected int oldWins;
        protected int newWins;

        public int getOldWins() {
            return oldWins;
        }

        public int getNewWins() {
            return newWins;
        }
    }

    public SetResponse set(String nick, int wins) throws IOException, ApiError {
        return RequestUtil.mainGet("event/wins/set",SetResponse.class,this.options,new HashMap<String, Object>() {{
            put("nick",nick);
            put("wins",wins);
        }});
    }

    public static class SetResponse implements RequestUtil.ApiResponse {
        protected int oldWins;
        protected int newWins;

        public int getOldWins() {
            return oldWins;
        }

        public int getNewWins() {
            return newWins;
        }
    }
}
