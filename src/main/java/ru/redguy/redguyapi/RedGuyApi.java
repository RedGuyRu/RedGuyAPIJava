package ru.redguy.redguyapi;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import ru.redguy.redguyapi.hashes.Hashes;
import ru.redguy.redguyapi.links.Links;
import ru.redguy.redguyapi.minecraft.Minecraft;
import ru.redguy.redguyapi.news.News;
import ru.redguy.redguyapi.token.Token;
import ru.redguy.redguyapi.users.Users;

import java.util.HashMap;
import java.util.Map;

public class RedGuyApi {

    private final Map<String, String> options;

    private RedGuyApi() {
        this.options = new HashMap<>();
    }

    /**
     * Constructs main api object.
     *
     * @param token Your api token.
     */
    public RedGuyApi(String token) {
        this.options = verifyOptions(new HashMap<>(), token);
    }

    /**
     * Constructs main api object with specified params.
     *
     * @param token   Your api token.
     * @param options Additional client params
     */
    public RedGuyApi(String token, Map<String, String> options) {
        this.options = verifyOptions(options, token);
    }

    @NotNull
    @Contract("_, _ -> param1")
    private Map<String, String> verifyOptions(@NotNull Map<String, String> options, String token) {
        options.put("token", token);
        return options;
    }

    /**
     * Returns new instance of Minecraft API section
     *
     * @return Minecraft API section
     */
    public Minecraft minecraft() {
        return new Minecraft(options);
    }

    /**
     * Returns new instance of Token API section
     *
     * @return Token API section
     */
    public Token token() {
        return new Token(options);
    }

    /**
     * Returns new instance of Users API section
     *
     * @return Users API section
     */
    public Users users() {
        return new Users(options);
    }

    /**
     * Returns new instance of News API section
     *
     * @return News API section
     */
    public News news() {
        return new News(options);
    }

    /**
     * Returns new instance of Hashes API section
     *
     * @return Hashes API section
     */
    public Hashes hashes() {
        return new Hashes(options);
    }

    /**
     * Returns new instance of Links API section
     *
     * @return Links API section
     */
    public Links links() {
        return new Links(options);
    }
}
