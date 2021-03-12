package ru.redguy.redguyapi.teams;

public class Team {
    public int id;
    public String name;

    protected Team(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
