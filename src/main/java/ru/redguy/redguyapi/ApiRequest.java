package ru.redguy.redguyapi;

import org.json.JSONObject;
import ru.redguy.rednetworker.clients.http.ApacheFluentAPI;
import ru.redguy.rednetworker.clients.http.exceptions.OpenConnectionException;
import ru.redguy.rednetworker.clients.http.exceptions.URLException;

import java.util.Map;

public class ApiRequest {
    static JSONObject mainGet(String path, Map<String, Object> options, Map<String, Object> params) throws OpenConnectionException, URLException, ApiError {
        params.put("token", options.get("token"));
        params.put("v", options.get("v"));
        ApacheFluentAPI apacheFluentAPI = new ApacheFluentAPI();
        JSONObject result = new JSONObject(apacheFluentAPI.getString("https://api.redguy.ru/" + path + "/", params));
        if (result.getInt("code") != 1) {
            throw new ApiError(result.getInt("code"), result.getString("comment"));
        } else {
            return result;
        }
    }

    static JSONObject mainPost(String path, Map<String, Object> options, String body, Map<String, Object> params) throws OpenConnectionException, URLException, ApiError {
        params.put("token", options.get("token"));
        params.put("v", options.get("v"));
        ApacheFluentAPI apacheFluentAPI = new ApacheFluentAPI();
        JSONObject result = new JSONObject(apacheFluentAPI.postString("https://api.redguy.ru/" + path + "/", params));//TODO: переделать RedNetWorker и сделать возможноть raw post
        if (result.getInt("code") != 1) {
            throw new ApiError(result.getInt("code"), result.getString("comment"));
        } else {
            return result;
        }
    }
}
