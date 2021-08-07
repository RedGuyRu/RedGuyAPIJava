package ru.redguy.redguyapi;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class ApiRequest {
    private static final OkHttpClient okHttpClient = new OkHttpClient();

    public static JSONObject mainGet(String path, Map<String, String> options, Map<String, Object> params) throws ApiError, IOException {
        params.put("token", options.get("token"));
        params.put("v", options.get("v"));

        Request request = new Request.Builder().url("https://api.redguy.ru/" + path + "/" + buildGet(params)).get().build();

        Response response = okHttpClient.newCall(request).execute();
        JSONObject result = new JSONObject(response.body().string());
        if (result.getInt("code") != 1) {
            throw new ApiError(result.getInt("code"), result.getString("comment"));
        } else {
            return result.getJSONObject("response");
        }
    }

    public static JSONObject mainPost(String path, Map<String, String> options, String body, Map<String, Object> params) throws ApiError, IOException {
        params.put("token", options.get("token"));
        params.put("v", options.get("v"));

        RequestBody rb = RequestBody.create(body, MediaType.get("application/json; charset=utf-8"));

        Request request = new Request.Builder().url("https://api.redguy.ru/" + path + "/" + buildGet(params)).post(rb).build();

        Response response = okHttpClient.newCall(request).execute();
        JSONObject result = new JSONObject(response.body().string());
        if (result.getInt("code") != 1) {
            throw new ApiError(result.getInt("code"), result.getString("comment"));
        } else {
            return result.getJSONObject("response");
        }
    }

        public static String buildGet(Map<String,Object> args) {
            if(args == null) {
                return "";
            } else {
                return ("?" + buildPost(args));
            }
        }

        public static String buildPost(Map<String, Object> args) {
            if (args == null) {
                return "";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                args.forEach((name, value) -> {
                    try {
                        stringBuilder.append(URLEncoder.encode(name, "UTF-8")).append('=').append(URLEncoder.encode(String.valueOf(value), "UTF-8")).append('&');
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                });
                String strResult = stringBuilder.toString();
                return !strResult.isEmpty()
                        ? stringBuilder.substring(0, stringBuilder.length() - 1)
                        : strResult;
            }
        }
}
