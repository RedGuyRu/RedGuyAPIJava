package ru.redguy.redguyapi.links;

import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.utils.RequestUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Links {
    private final Map<String, String> options;

    public Links(Map<String, String> options) {
        this.options = options;
    }

    /**
     * Checks links is it safe
     *
     * @return List of SafeEntries
     * @throws ApiError    Error from API
     * @throws IOException Network error
     */
    public List<SafeEntry> isSafe(String link) throws ApiError, IOException {
        return Objects.requireNonNull(RequestUtil.mainGet("v1/links/safe", SafeResponse.class, options, new HashMap<>() {{
            put("link", link);
        }})).getDomains();
    }

    public void report(String link) throws ApiError, IOException {
        RequestUtil.mainGet("v1/links/report", null, options, new HashMap<>() {{
            put("link", link);
        }});
    }
}
