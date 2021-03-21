package ru.redguy.redguyapi.users;

import org.json.JSONObject;
import ru.redguy.redguyapi.JSONUtil;

public class User {

    private int id;
    private String first_name,
            last_name,
            mine_nick,
            avatar_url,
            background_url;

    public User(JSONObject jsonObject) {
        JSONUtil jsonUtil = new JSONUtil(jsonObject);
        id = jsonObject.getInt("id");
        first_name = jsonUtil.getStringOrDefault("first_name","");
        last_name = jsonUtil.getStringOrDefault("last_name","");
        mine_nick = jsonUtil.getStringOrDefault("mine_nick","");
        avatar_url = jsonUtil.getStringOrDefault("avatar_url","");
        background_url = jsonUtil.getStringOrDefault("background_url","");
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getMineNick() {
        return mine_nick;
    }

    public String getAvatarUrl() {
        return avatar_url;
    }

    public String getBackgroundUrl() {
        return background_url;
    }
}
