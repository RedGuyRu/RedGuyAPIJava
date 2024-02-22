package ru.redguy.redguyapi.text;

import com.google.gson.JsonObject;
import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.utils.RequestUtil;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Text {
    private final Map<String, String> options;

    public Text(Map<String, String> options) {
        this.options = options;
    }

    /**
     * Parses text and returns a json object with found entities, requires text:parse permission
     *
     * @throws ApiError    Error from API
     * @throws IOException Network error
     */
    public TextParseResponse parse(String text, String lang) throws ApiError, IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("text", text);
        jsonObject.addProperty("lang", lang);
        return RequestUtil.mainPost("v1/text/parse", TextParseResponse.class, options, jsonObject);
    }

    /**
     * Parses text and returns a json object with found entities with ru_ru language, requires text:parse permission
     *
     * @throws ApiError    Error from API
     * @throws IOException Network error
     */
    public TextParseResponse parse(String text) throws ApiError, IOException {
        return parse(text, "ru_ru");
    }
}
