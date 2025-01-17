package ru.redguy.redguyapi.text;

import ru.redguy.redguyapi.utils.ToStringBuilder;

public class CreditCardNumberEntity extends TextEntity {
    public static class Value {
        private String value;
        private String issuer;

        public String getValue() {
            return value;
        }

        public String getIssuer() {
            return issuer;
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
