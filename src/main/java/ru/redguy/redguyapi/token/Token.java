package ru.redguy.redguyapi.token;

import com.google.gson.JsonObject;
import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.HashUtils;
import ru.redguy.redguyapi.RequestUtil;
import ru.redguy.redguyapi.minecraft.ServerInfo;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Token {
    public static IssuedToken issue(int appId, String secret, List<String> scope, Map<String, String> options) throws ApiError, IOException, NoSuchAlgorithmException {
        JsonObject obj = new JsonObject();
        obj.addProperty("app", appId);
        long ts = Instant.now().getEpochSecond();
        obj.addProperty("secret", HashUtils.md5(secret + ts));
        obj.addProperty("ts", ts);
        obj.addProperty("scope", String.join(",", scope));
        return RequestUtil.mainPost("v1/token/issue", IssuedToken.class, options, obj.toString(), new HashMap<>());
    }

    public static IssuedToken issue(int appId, String secret, List<String> scope) throws ApiError, IOException, NoSuchAlgorithmException {
        return issue(appId, secret, scope, new HashMap<>());
    }

    private final Map<String, String> options;

    public Token(Map<String, String> options) {
        this.options = options;
    }

    public AppToken info() throws ApiError, IOException {
        return RequestUtil.mainGet("v1/token/info", AppToken.class,options,new HashMap<String, Object>());
    }

    public RevokedToken revoke() throws ApiError, IOException {
        return RequestUtil.mainGet("v1/token/revoke", RevokedToken.class,options,new HashMap<String, Object>());
    }
}
