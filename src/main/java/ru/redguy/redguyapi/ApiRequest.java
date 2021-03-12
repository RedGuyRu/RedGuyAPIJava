package ru.redguy.redguyapi;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.redguy.rednetworker.clients.http.ApacheFluentAPI;
import ru.redguy.rednetworker.clients.http.HttpMethod;
import ru.redguy.rednetworker.clients.http.exceptions.HttpProtocolException;
import ru.redguy.rednetworker.clients.http.exceptions.InputStreamException;

import java.io.IOException;
import java.util.Map;

public class ApiRequest {
    public static JSONObject mainGet(String path, Map<String, String> options, Map<String, Object> params) throws ApiError, IOException {
        params.put("token", options.get("token"));
        params.put("v", options.get("v"));
        JSONObject result;
        try {
            result = new JSONObject(
                    new ApacheFluentAPI()
                            .url("https://api.redguy.ru/" + path + "/")
                            .setGetParams(params)
                            .execute()
                            .getString()
            );
        } catch (HttpProtocolException e) {
            throw new IOException(e);
        }
        if (result.getInt("code") != 1) {
            throw new ApiError(result.getInt("code"), result.getString("comment"));
        } else {
            return result.getJSONObject("response");
        }
    }

    public static JSONArray mainGetArray(String path, Map<String, String> options, Map<String, Object> params) throws ApiError, IOException {
        params.put("token", options.get("token"));
        params.put("v", options.get("v"));
        JSONObject result;
        try {
            result = new JSONObject(
                    new ApacheFluentAPI()
                            .url("https://api.redguy.ru/" + path + "/")
                            .setGetParams(params)
                            .execute()
                            .getString()
            );
        } catch (HttpProtocolException e) {
            throw new IOException(e);
        }
        if (result.getInt("code") != 1) {
            throw new ApiError(result.getInt("code"), result.getString("comment"));
        } else {
            return result.getJSONArray("response");
        }
    }

    public static JSONObject mainPost(String path, Map<String, String> options, String body, Map<String, Object> params) throws ApiError, IOException {
        params.put("token", options.get("token"));
        params.put("v", options.get("v"));
        JSONObject result;
        try {
            result = new JSONObject(
                    new ApacheFluentAPI()
                            .url("https://api.redguy.ru/" + path + "/")
                            .setGetParams(params)
                            .setPostBody(body)
                            .method(HttpMethod.POST)
                            .execute()
                            .getString()
            );
        }catch (HttpProtocolException e) {
                throw new IOException(e);
            }
        if (result.getInt("code") != 1) {
            throw new ApiError(result.getInt("code"), result.getString("comment"));
        } else {
            return result.getJSONObject("response");
        }
    }
}
