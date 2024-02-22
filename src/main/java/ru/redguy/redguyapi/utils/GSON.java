package ru.redguy.redguyapi.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.redguy.redguyapi.text.TextEntity;
import ru.redguy.redguyapi.text.TextEntityDeserializer;

import java.time.Instant;

public class GSON {
    public static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(TextEntity.class, new TextEntityDeserializer())
            .registerTypeAdapter(Instant.class, new InstantDeserializer())
            .create();
}
