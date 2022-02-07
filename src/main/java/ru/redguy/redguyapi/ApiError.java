package ru.redguy.redguyapi;

public class ApiError extends Exception {

    private final int code;
    private final String comment;

    /**
     * The error returned by the api server, to clarify the reason, see https://wiki.redguy.ru/Api/Errors
     * @param code Error id
     * @param comment Error name
     */
    public ApiError(int code, String comment) {
        super();
        this.code = code;
        this.comment = comment;
    }

    @Override
    public String getMessage() {
        return comment;
    }

    /**
     * Returns error id, to clarify the reason, see https://wiki.redguy.ru/Api/Errors
     * @return Error id
     */
    public int getCode() {
        return code;
    }
}
