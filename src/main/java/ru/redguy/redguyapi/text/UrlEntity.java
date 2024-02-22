package ru.redguy.redguyapi.text;

import ru.redguy.redguyapi.utils.ToStringBuilder;

public class UrlEntity extends TextEntity {
    public static class Value {
        private int value;
        private String type;
        private String domain;

        public int getValue() {
            return value;
        }

        public String getType() {
            return type;
        }

        public String getDomain() {
            return domain;
        }

        @Override
        public String toString() {
            return ToStringBuilder.of(this);
        }
    }

    private Value value;

    public Value getValue() {
        return value;
    }
}
