package ru.redguy.redguyapi.text;

import ru.redguy.redguyapi.utils.ToStringBuilder;

public class PhoneNumberEntity extends TextEntity {
    public static class Value {
        private String value;
        private String type;

        public String getValue() {
            return value;
        }

        public String getType() {
            return type;
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
