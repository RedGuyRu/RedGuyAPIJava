package ru.redguy.redguyapi.gamesintegration;

import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.RequestUtil;
import ru.redguy.redguyapi.HashUtils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class GamesIntegration {

    private final Map<String, String> options;

    public GamesIntegration(Map<String, String> options) {
        this.options = options;
    }

    public LinkAccountResponse linkAccount(String nick, String game, int appId, String secretKey) throws ApiError, IOException, NoSuchAlgorithmException {
        long ts = System.currentTimeMillis()/1000;
        String hash = HashUtils.md5(appId+""+ts+secretKey);
        return RequestUtil.mainGet("gamesintegration/linkaccount",LinkAccountResponse.class,options,new HashMap<String, Object>() {{
            put("nick",nick);
            put("game",game);
            put("ts",ts);
            put("secret",hash);
            put("appid",appId);
        }});
    }

    public static class LinkAccountResponse implements RequestUtil.ApiResponse {
        protected String code;

        public String getCode() {
            return code;
        }
    }
}
