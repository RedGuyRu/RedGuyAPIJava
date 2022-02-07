package ru.redguy.redguyapi.hashes;

import ru.redguy.redguyapi.utils.RequestUtil;

public class Hash implements RequestUtil.ApiResponse {
    protected String value;

    public String getValue() {
        return value;
    }
}
