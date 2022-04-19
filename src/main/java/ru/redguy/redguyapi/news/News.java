package ru.redguy.redguyapi.news;

import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.utils.GSON;
import ru.redguy.redguyapi.utils.RequestUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class News {
    private final Map<String, String> options;

    public News(Map<String, String> options) {
        this.options = options;
    }

    public List<NewsPost> get(String tag) throws ApiError, IOException {
        return RequestUtil.mainGet("v1/news/", NewsResponse.class, options, new HashMap<String, Object>() {{
            put("tag", tag);
        }}).getNews();
    }

    public List<NewsPost> get() throws ApiError, IOException {
        return RequestUtil.mainGet("v1/news/", NewsResponse.class, options, new HashMap<>()).getNews();
    }

    public int post(String name, String content, int author, List<String> tags) throws ApiError, IOException {
        return RequestUtil.mainPost(
                "v1/news/",
                NewsPost.class,
                options,
                GSON.GSON.toJson(new NewsPost(name, content, author, tags)), new HashMap<>()).getId();
    }
}
