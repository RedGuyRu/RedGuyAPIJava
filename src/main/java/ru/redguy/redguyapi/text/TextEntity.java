package ru.redguy.redguyapi.text;

import ru.redguy.redguyapi.utils.RequestUtil;
import ru.redguy.redguyapi.utils.ToStringBuilder;

public class TextEntity implements RequestUtil.ApiResponse {
    private String body;
    private int start;
    private int end;
    private String dim;
    private boolean latent;

    public String getBody() {
        return body;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getDim() {
        return dim;
    }

    public boolean isLatent() {
        return latent;
    }

    @Override
    public String toString() {
        return ToStringBuilder.of(this);
    }
}
