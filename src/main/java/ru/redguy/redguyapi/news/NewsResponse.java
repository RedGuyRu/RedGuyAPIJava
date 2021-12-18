package ru.redguy.redguyapi.news;

import ru.redguy.redguyapi.utils.RequestUtil;

import java.util.ArrayList;

public class NewsResponse implements RequestUtil.ApiResponse {
    protected ArrayList<NewsPost> news;

    public ArrayList<NewsPost> getNews() {
        return news;
    }
}
