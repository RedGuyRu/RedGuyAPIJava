package ru.redguy.redguyapi.utils;

import java.lang.reflect.Field;
import java.util.HashMap;

public interface ToStringBuilder {
    public static String of(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        StringBuilder builder = new StringBuilder();
        builder.append(object.getClass().getSimpleName()).append("{");
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                builder.append(field.getName()).append("=").append(field.get(object).toString()).append(", ");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (builder.length() > 2 && builder.substring(builder.length() - 2).equals(", ")) {
            builder.setLength(builder.length() - 2);
        }
        builder.append("}");
        return builder.toString();
    }
}
