package ru.redguy.redguyapi.news;

import ru.redguy.redguyapi.utils.RequestUtil.ApiResponse;

import java.util.List;

public class NewsPost implements ApiResponse {
    public NewsPost(String name, String content, int author, List<String> tags) {
        this.name = name;
        this.content = content;
        this.author = author;
        this.tags = tags;
    }

    protected int id;
    protected String name;
    protected String content;
    protected int author;
    protected List<String> tags;
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

    public List<String> getTags() {
        return tags;
    }

    public String getPublished() {
        return published;
    }
}
