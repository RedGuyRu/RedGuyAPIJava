package ru.redguy.redguyapi.links;

import ru.redguy.redguyapi.utils.RequestUtil;

import java.util.List;

public class SafeResponse implements RequestUtil.ApiResponse {
    public List<SafeEntry> getDomains() {
        return domains;
    }

    public void setDomains(List<SafeEntry> domains) {
        this.domains = domains;
    }

    private List<SafeEntry> domains;
}
