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
     * @return Value
     * @throws ApiError    Error from API
     * @throws IOException Network error
     */
    public Hash get(String hash) throws ApiError, IOException {
        return RequestUtil.mainGet("v1/hashes/md5", Hash.class, options, new HashMap<String, Object>() {{
            put("hash", hash);
        }});
    }
}
