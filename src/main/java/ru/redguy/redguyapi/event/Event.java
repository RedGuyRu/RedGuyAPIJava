package ru.redguy.redguyapi.event;

import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.RequestUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Event {

    private final Map<String, String> options;

    public Event(Map<String, String> options) {
        this.options = options;
    }

    public StatsResponse getStats(String nick) throws IOException, ApiError {
        return RequestUtil.mainGet("event/stats/get",StatsResponse.class,this.options, new HashMap<String, Object>() {{
            put("nick",nick);
        }});
    }

    public static class StatsResponse implements RequestUtil.ApiResponse {
        protected int coins;
        protected int wins;
        protected int tokens;
        protected int kills;

        public int getCoins() {
            return coins;
        }

        public int getWins() {
            return wins;
        }

        public int getTokens() {
            return tokens;
        }

        public int getKills() {
            return kills;
        }
    }

    public Coins coins() {
        return new Coins(this.options);
    }

    public Tokens tokens() {
        return new Tokens(this.options);
    }

    public Wins wins() {
        return new Wins(this.options);
    }

    public Kills kills() {
        return new Kills(this.options);
    }
}
