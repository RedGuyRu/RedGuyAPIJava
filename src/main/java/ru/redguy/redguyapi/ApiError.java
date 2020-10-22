package ru.redguy.redguyapi;

public class ApiError extends Exception {

    public int code;
    public String comment;

    public ApiError(int code, String comment) {
        super();
        this.code = code;
        this.comment = comment;
    }
}
