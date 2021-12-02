package com.javaquery.util.exception;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Use this exception to log parameters you sent to method for debugging.
 * Make sure you do not log any confidential details.
 * @author vicky.thakor
 * @since 1.0.7
 */
public class ParameterAwareException extends AbstractRuntimeException {
    static final long serialVersionUID = 4721842774212273469L;
    private static final String PARAMETERS = "Parameters: ";
    private final Object[] parameters;

    /**
     * @param errorCode error code of exception to distinguish your project specific exception
     * @param message exception message
     * @param parameters parameters to log
     */
    public ParameterAwareException(String errorCode, String message, Object... parameters) {
        super(errorCode, message + "\n" + PARAMETERS + Stream.of(parameters).map(String::valueOf).collect(Collectors.toList()));
        this.parameters = parameters;
    }

    /**
     * @param errorCode error code of exception to distinguish your project specific exception
     * @param cause an exception
     * @param parameters parameters to log
     */
    public ParameterAwareException(String errorCode, Throwable cause, Object... parameters){
        super(errorCode, PARAMETERS + Stream.of(parameters).map(String::valueOf).collect(Collectors.toList()), cause);
        this.parameters = parameters;
    }

    /**
     * @param errorCode error code of exception to distinguish your project specific exception
     * @param message exception message
     * @param cause an exception
     * @param parameters parameters to log
     */
    public ParameterAwareException(String errorCode, String message, Throwable cause, Object... parameters){
        super(errorCode, message + "\n" + PARAMETERS + Stream.of(parameters).map(String::valueOf).collect(Collectors.toList()), cause);
        this.parameters = parameters;
    }

    /**
     * @return parameters provided in exception
     */
    public Object[] getParameters() {
        return parameters;
    }
}
