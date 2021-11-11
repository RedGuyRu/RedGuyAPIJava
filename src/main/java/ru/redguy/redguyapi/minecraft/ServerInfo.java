package ru.redguy.redguyapi.minecraft;

import ru.redguy.redguyapi.utils.RequestUtil;

import java.util.List;

public class ServerInfo implements RequestUtil.ApiResponse {
    protected String host;
    protected String description;
    protected List<Mod> mods;
    protected PlayersCount players;

    public String getHost() {
        return host;
    }

    public String getDescription() {
        return description;
    }

    public List<Mod> getMods() {
        return mods;
    }

    public PlayersCount getPlayers() {
        return players;
    }
}
