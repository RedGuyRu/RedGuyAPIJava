package ru.redguy.redguyapi.users;

import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.RequestUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Users {

    private Map<String, String> options;

    public Users(Map<String, String> options) {
        this.options = options;
    }

    public GetResponse get(int id, Additional additional) throws ApiError, IOException {
        return RequestUtil.mainGet("users/get",GetResponse.class,options,new HashMap<String, Object>() {{
            put("id",id);
            put("additional",additional.getResult());
        }});
    }

    public GetResponse get(int id) throws ApiError, IOException {
        return RequestUtil.mainGet("users/get",GetResponse.class,options,new HashMap<String, Object>() {{
            put("id",id);
        }});
    }

    public static class GetResponse implements RequestUtil.ApiResponse {
        protected int id;
        protected String first_name;
        protected String last_name;
        protected String mine_nick;
        protected String avatar_url;
        protected String background_url;

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
}