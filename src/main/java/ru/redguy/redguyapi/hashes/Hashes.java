package ru.redguy.redguyapi.hashes;

import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.utils.RequestUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Hashes {
    private final Map<String, String> options;

    public Hashes(Map<String, String> options) {
        this.options = options;
    }

    /**
     * Gets decrypted md5 by hash
     *
     * @return decrypted string
     * @throws ApiError    Error from API
     * @throws IOException Network error
     */
    public String get(String hash) throws ApiError, IOException {
        return RequestUtil.mainGet("v1/hashes/md5", Hash.class, options, new HashMap<String, Object>() {{
            put("hash", hash);
        }}).getValue();
    }

    /**
     * Requests server to count, return and save hash of value
     *
     * @return Hash on target String
     * @throws ApiError    Error from API
     * @throws IOException Network error
     */
    public String post(String value) throws ApiError, IOException {
        return RequestUtil.mainPost("v1/hashes/md5", Hash.class, options, "", new HashMap<String, Object>() {{
            put("value", value);
        }}).getHash();
    }
}
