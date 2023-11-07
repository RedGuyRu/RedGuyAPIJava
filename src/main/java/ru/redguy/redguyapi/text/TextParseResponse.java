package ru.redguy.redguyapi.text;

import ru.redguy.redguyapi.links.SafeEntry;
import ru.redguy.redguyapi.utils.RequestUtil;

import java.util.List;

public class TextParseResponse implements RequestUtil.ApiResponse {
    private String body;
    private int start;
    private int end;
    private String dim;
    private boolean latent;
}
