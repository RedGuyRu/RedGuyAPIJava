package ru.redguy.redguyapi.news;

import java.util.ArrayList;

public class NewsPost {
    protected int id;
    protected String name;
    protected String content;
    protected int author;
    protected ArrayList<String> tags;
    protected String published;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public int getAuthor() {
        return author;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public String getPublished() {
        return published;
    }
}
