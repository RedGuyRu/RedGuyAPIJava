package ru.redguy.redguyapi;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import ru.redguy.redguyapi.minecraft.Minecraft;
import ru.redguy.redguyapi.news.News;
import ru.redguy.redguyapi.token.Token;
import ru.redguy.redguyapi.users.Users;

import java.util.HashMap;
import java.util.Map;

public class RedGuyApi {

    private final Map<String, String> options;

    public RedGuyApi() {
        this.options = new HashMap<>();
    }

    public RedGuyApi(String token) {
        this.options = verifyOptions(new HashMap<>(), token);
    }

    public RedGuyApi(String token, Map<String, String> options) {
        this.options = verifyOptions(options, token);
    }

    @NotNull
    @Contract("_, _ -> param1")
    private Map<String, String> verifyOptions(@NotNull Map<String, String> options, String token) {
        options.put("token", token);
        return options;
    }

    public Minecraft minecraft() {return new Minecraft(options);}

    public Token token() {return new Token(options);}

    public Users users() {return new Users(options);}

    public News news() {return new News(options);}
}
