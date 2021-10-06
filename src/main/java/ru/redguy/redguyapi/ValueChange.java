package ru.redguy.redguyapi;

public class ValueChange<K,V> {
    private final V newValue;
    private final K oldValue;

    public ValueChange (K oldValue, V newValue) {
        this.newValue = newValue;
        this.oldValue = oldValue;
    }

    public V getNewValue() {
        return newValue;
    }

    public K getOldValue() {
        return oldValue;
    }
}
