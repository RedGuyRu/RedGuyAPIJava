package ru.redguy.redguyapi;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtil extends JSONObject {

    public JSONObject jsonObject;

    public JSONUtil(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public String getStringOrDefault(String key, String defaultValue) {
        try {
            return jsonObject.getString(key);
        } catch (JSONException exception) {
            return defaultValue;
        }
    }

    public int getIntOrDefault(String key, int defaultValue) {
        try {
            return jsonObject.getInt(key);
        } catch (JSONException exception) {
            return defaultValue;
        }
    }
}
