package ru.redguy.redguyapi.hashes;

import ru.redguy.redguyapi.utils.RequestUtil;

public class Hash implements RequestUtil.ApiResponse {
    protected String value;
    protected String hash;

    public String getValue() {
        return value;
    }

    public String getHash() {
        return hash;
    }
}
