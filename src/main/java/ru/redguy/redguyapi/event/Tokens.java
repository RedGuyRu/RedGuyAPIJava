package ru.redguy.redguyapi.event;

import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.RequestUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Tokens {
    private final Map<String, String> options;

    public Tokens(Map<String, String> options) {
        this.options = options;
    }

    public GetResponse get(String nick) throws IOException, ApiError {
        return RequestUtil.mainGet("event/tokens/get",GetResponse.class,this.options,new HashMap<String, Object>() {{
            put("nick",nick);
        }});
    }

    public static class GetResponse implements RequestUtil.ApiResponse {
        protected int tokens;

        public int getTokens() {
            return tokens;
        }
    }

    public AddResponse add(String nick, int tokens) throws IOException, ApiError {
        return RequestUtil.mainGet("event/tokens/add",AddResponse.class,this.options,new HashMap<String, Object>() {{
            put("nick",nick);
            put("tokens",tokens);
        }});
    }

    public static class AddResponse implements RequestUtil.ApiResponse {
        protected int oldTokens;
        protected int newTokens;

        public int getOldCoins() {
            return oldTokens;
        }

        public int getNewCoins() {
            return newTokens;
        }
    }

    public SetResponse set(String nick, int tokens) throws IOException, ApiError {
        return RequestUtil.mainGet("event/tokens/set",SetResponse.class,this.options,new HashMap<String, Object>() {{
            put("nick",nick);
            put("tokens",tokens);
        }});
    }

    public static class SetResponse implements RequestUtil.ApiResponse {
        protected int oldTokens;
        protected int newTokens;

        public int getOldTokens() {
            return oldTokens;
        }

        public int getNewTokens() {
            return newTokens;
        }
    }
}
