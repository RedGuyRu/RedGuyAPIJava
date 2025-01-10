package ru.redguy.redguyapi.utils;

import com.google.gson.JsonElement;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import ru.redguy.redguyapi.ApiError;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class RequestUtil {
    private static final OkHttpClient okHttpClient = new OkHttpClient();

    public static <T extends ApiResponse> T mainGet(String path, Class<T> responseType, @NotNull Map<String, String> options, @NotNull Map<String, Object> params) throws ApiError, IOException {
        params.put("token", options.get("token"));

        Request request = new Request.Builder().url("https://api.redguy.ru/" + path + "/" + buildGet(params)).get().build();

        Response response = okHttpClient.newCall(request).execute();
        String str = response.body().string();
        ApiResult result = GSON.GSON.fromJson(str, ApiResult.class);
        if (result.getCode() != 1) {
            throw new ApiError(result.getCode(), result.getComment());
        } else {
            if(responseType == null) return null;
            return GSON.GSON.fromJson(result.getResponse(), responseType);
        }
    }

    public static <T extends ApiResponse> T mainPost(String path, Class<T> responseType, @NotNull Map<String, String> options, JsonElement body) throws ApiError, IOException {
        return mainPost(path, responseType, options, GSON.GSON.toJson(body), new HashMap<>());
    }

    public static <T extends ApiResponse> T mainPost(String path, Class<T> responseType, @NotNull Map<String, String> options, String body, @NotNull Map<String, Object> params) throws ApiError, IOException {
        params.put("token", options.get("token"));

        RequestBody rb = RequestBody.create(body, MediaType.get("application/json; charset=utf-8"));

        Request request = new Request.Builder().url("https://api.redguy.ru/" + path + "/" + buildGet(params)).post(rb).build();

        Response response = okHttpClient.newCall(request).execute();
        String str = response.body().string();
        ApiResult result = GSON.GSON.fromJson(str, ApiResult.class);
        if (result.getCode() != 1) {
            throw new ApiError(result.getCode(), result.getComment());
        } else {
            if(responseType == null) return null;
            return GSON.GSON.fromJson(result.getResponse(), responseType);
        }
    }

    @NotNull
    public static String buildGet(Map<String, Object> args) {
        if (args == null) {
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

    static class ApiResult {
        protected int code;
        protected String comment;
        protected JsonElement response;

        public int getCode() {
            return code;
        }

        public String getComment() {
            return comment;
        }

        public JsonElement getResponse() {
            return response;
        }
    }

    public interface ApiResponse {

    }

    interface ApiRequest {

    }
}
