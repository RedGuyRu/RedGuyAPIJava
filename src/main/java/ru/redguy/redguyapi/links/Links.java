package ru.redguy.redguyapi.links;

import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.hashes.Hash;
import ru.redguy.redguyapi.utils.RequestUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Links {
    private final Map<String, String> options;

    public Links(Map<String, String> options) {
        this.options = options;
    }

    /**
     * Checks links is it safe
     *
     * @return Array of SafeEntries
     * @throws ApiError    Error from API
     * @throws IOException Network error
     */
    public List<SafeEntry> isSafe(String link) throws ApiError, IOException {
        return RequestUtil.mainGet("v1/links/safe", SafeResponse.class, options, new HashMap<String, Object>() {{
            put("link", link);
        }}).getDomains();
    }
}
