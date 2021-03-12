package ru.redguy.redguyapi.teams;

public class TeamPosition {
    public Team team;
    public String nick;
    public String position;

    protected TeamPosition(Team team, String nick, String position) {
        this.team = team;
        this.nick = nick;
        this.position = position;
    }
}
