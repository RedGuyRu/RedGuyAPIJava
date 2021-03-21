package ru.redguy.redguyapi.event;

import org.json.JSONObject;
import ru.redguy.redguyapi.JSONUtil;

public class PlayerStats {

    private int coins,
            wins,
            tokens,
            kills;

    public PlayerStats(JSONObject jsonObject) {
        JSONUtil jsonUtil = new JSONUtil(jsonObject);
        coins = jsonUtil.getIntOrDefault("coins",0);
        wins = jsonUtil.getIntOrDefault("wins",0);
        tokens = jsonUtil.getIntOrDefault("tokens",0);
        kills = jsonUtil.getIntOrDefault("kills",0);
    }

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
