package de.zebrajaeger.panocms;

/**
 * @author Lars Brandt on 07.12.2016
 */
public class PanocmsRuntimeException extends RuntimeException {

    public PanocmsRuntimeException() {
    }

    public PanocmsRuntimeException(String message) {
        super(message);
    }

    public PanocmsRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public PanocmsRuntimeException(Throwable cause) {
        super(cause);
    }

    public PanocmsRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
