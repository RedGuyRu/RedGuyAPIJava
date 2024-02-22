package ru.redguy.redguyapi.text;

import org.jetbrains.annotations.Nullable;
import ru.redguy.redguyapi.utils.ToStringBuilder;

public class DurationEntity extends TextEntity {
    public static class Value {
        private int value;
        private String type;
        private @Nullable Integer second;
        private @Nullable Integer minute;
        private @Nullable Integer hour;
        private @Nullable Integer day;
        private @Nullable Integer week;
        private @Nullable Integer month;
        private @Nullable Integer year;
        private String unit;
        private NormalizedValue normalized;

        public int getValue() {
            return value;
        }

        public String getType() {
            return type;
        }

        public String getUnit() {
            return unit;
        }

        @Nullable
        public Integer getMinute() {
            return minute;
        }

        @Nullable
        public Integer getSecond() {
            return second;
        }

        @Nullable
        public Integer getHour() {
            return hour;
        }

        @Nullable
        public Integer getDay() {
            return day;
        }

        @Nullable
        public Integer getWeek() {
            return week;
        }

        @Nullable
        public Integer getMonth() {
            return month;
        }

        @Nullable
        public Integer getYear() {
            return year;
        }

        public NormalizedValue getNormalized() {
            return normalized;
        }

        @Override
        public String toString() {
            return ToStringBuilder.of(this);
        }
    }

    public static class NormalizedValue {
        private long value;
        private String unit;

        public long getValue() {
            return value;
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
