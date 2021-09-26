package ru.redguy.redguyapi.test;

import ru.redguy.redguyapi.RedGuyApi;

public class Main {
    public static void main(String[] args) throws Exception {
        RedGuyApi redGuyApi = new RedGuyApi(System.getenv("TOKEN"));
        System.out.println(redGuyApi.minecraft().serverinfo("redguy.ru").getHost());
    }
}
