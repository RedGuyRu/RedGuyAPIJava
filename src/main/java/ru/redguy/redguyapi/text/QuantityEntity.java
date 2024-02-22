package ru.redguy.redguyapi.text;

import ru.redguy.redguyapi.utils.ToStringBuilder;

public class QuantityEntity extends TextEntity {
    public static class Value {
        private long value;
        private String type;
        private String product;
        private String unit;

        public long getValue() {
            return value;
        }

        public String getType() {
            return type;
        }

        public String getProduct() {
            return product;
        }

        public String getUnit() {
            return unit;
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
