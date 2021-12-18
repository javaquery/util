package com.javaquery.util.exception;

/**
 * @author vicky.thakor
 * @since 1.0.7
 */
public abstract class AbstractRuntimeException extends RuntimeException {
    static final long serialVersionUID = -1497632070387643027L;
    private final String errorCode;

    public AbstractRuntimeException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public AbstractRuntimeException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public AbstractRuntimeException(String errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
