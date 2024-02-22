package ru.redguy.redguyapi.text;

import ru.redguy.redguyapi.utils.ToStringBuilder;

import java.time.Instant;
import java.util.List;

public class TimeEntity extends TextEntity {
    public static class Value {
        private Instant value;
        private String type;
        private String grain;
        private List<InnerValue> values;

        public Instant getValue() {
            return value;
        }

        public String getType() {
            return type;
        }

        public String getGrain() {
            return grain;
        }

        public List<InnerValue> getValues() {
            return values;
        }

        @Override
        public String toString() {
            return ToStringBuilder.of(this);
        }
    }

    public static class InnerValue {
        private Instant value;
        private String type;
        private String grain;

        public Instant getValue() {
            return value;
        }

        public String getType() {
            return type;
        }

        public String getGrain() {
            return grain;
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
