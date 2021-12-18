package ru.redguy.redguyapi.news;

import ru.redguy.redguyapi.ApiError;
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
        return RequestUtil.mainGet("v1/news/get", NewsResponse.class,options,new HashMap<String, Object>() {{
            put("tag",tag);
        }}).getNews();
    }

    public List<NewsPost> get() throws ApiError, IOException {
        return RequestUtil.mainGet("v1/news/get", NewsResponse.class,options, new HashMap<>()).getNews();
    }
}
