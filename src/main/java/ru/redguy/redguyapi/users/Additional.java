package ru.redguy.redguyapi.users;

public class Additional {

    private StringBuilder result;

    public Additional() {
        this.result = new StringBuilder();
    }

    public Additional mine_nick() {
        if(this.result.length() != 0) this.result.append(",");
        this.result.append("mine_nick");
        return this;
    }

    public Additional avatar() {
        if(this.result.length() != 0) this.result.append(",");
        this.result.append("avatar");
        return this;
    }

    public Additional background() {
        if(this.result.length() != 0) this.result.append(",");
        this.result.append("background");
        return this;
    }

    public String getResult() {
        return this.result.toString();
    }
}
