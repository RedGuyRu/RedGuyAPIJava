package ru.redguy.redguyapi;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import ru.redguy.redguyapi.minecraft.Minecraft;

import java.util.HashMap;
import java.util.Map;

public class RedGuyApi {

    private final Map<String, String> options;

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
}
