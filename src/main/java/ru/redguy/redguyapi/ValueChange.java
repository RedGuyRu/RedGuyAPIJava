package ru.redguy.redguyapi;

public class ValueChange {
    private final Object newValue;
    private final Object oldValue;

    public ValueChange(Object oldValue, Object newValue) {
        this.newValue = newValue;
        this.oldValue = oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    public Object getOldValue() {
        return oldValue;
    }
}
