package ru.redguy.redguyapi.links;

public class SafeEntry {
    private String domain;
    private boolean safe;
    private String source;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "SafeEntry{" +
                "domain='" + domain + '\'' +
                ", safe=" + safe +
                ", source='" + source + '\'' +
                '}';
    }
}
