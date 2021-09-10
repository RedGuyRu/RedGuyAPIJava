package ru.redguy.redguyapi.event;

import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.RequestUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Coins {
    private final Map<String, String> options;

    public Coins(Map<String, String> options) {
        this.options = options;
    }

    public GetResponse get(String nick) throws IOException, ApiError {
        return RequestUtil.mainGet("event/coins/get",GetResponse.class,this.options,new HashMap<String, Object>() {{
            put("nick",nick);
        }});
    }

    public static class GetResponse implements RequestUtil.ApiResponse {
        protected int coins;

        public int getCoins() {
            return coins;
        }
    }

    public AddResponse add(String nick, int coins) throws IOException, ApiError {
        return RequestUtil.mainGet("event/coins/add",AddResponse.class,this.options,new HashMap<String, Object>() {{
            put("nick",nick);
            put("coins",coins);
        }});
    }

    public static class AddResponse implements RequestUtil.ApiResponse {
        protected int oldCoins;
        protected int newCoins;

        public int getOldCoins() {
            return oldCoins;
        }

        public int getNewCoins() {
            return newCoins;
        }
    }

    public SetResponse set(String nick, int coins) throws IOException, ApiError {
        return RequestUtil.mainGet("event/coins/set",SetResponse.class,this.options,new HashMap<String, Object>() {{
            put("nick",nick);
            put("coins",coins);
        }});
    }

    public static class SetResponse implements RequestUtil.ApiResponse {
        protected int oldCoins;
        protected int newCoins;

        public int getOldCoins() {
            return oldCoins;
        }

        public int getNewCoins() {
            return newCoins;
        }
    }
}
