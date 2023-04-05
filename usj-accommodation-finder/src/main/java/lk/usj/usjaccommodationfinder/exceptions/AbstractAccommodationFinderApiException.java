package lk.usj.usjaccommodationfinder.exceptions;

import org.springframework.http.HttpStatus;

public abstract class AbstractAccommodationFinderApiException extends Exception {
    private final String errorCode;
    private final HttpStatus httpStatusCode;
    private final String additionalInfo;

    protected AbstractAccommodationFinderApiException(HttpStatus httpStatusCode, String errorCode) {
        this(httpStatusCode, errorCode, null);
    }

    protected AbstractAccommodationFinderApiException(HttpStatus httpStatusCode, String errorCode, String message) {
        this(httpStatusCode, errorCode, message, null);
    }

    protected AbstractAccommodationFinderApiException(HttpStatus httpStatusCode, String errorCode, String message, Throwable throwable) {
        this(httpStatusCode, errorCode, message, null, throwable);
    }

    protected AbstractAccommodationFinderApiException(HttpStatus httpStatusCode, String errorCode, String message, String additionalInfo, Throwable throwable) {
        super(message, throwable);
        this.httpStatusCode = httpStatusCode;
        this.errorCode = errorCode;
        this.additionalInfo = additionalInfo;
    }

    protected AbstractAccommodationFinderApiException(String errorCode, String message, Throwable throwable) {
        this(null, errorCode, null, message, throwable);
    }

    public HttpStatus getHttpStatusCode() {
        return (httpStatusCode != null) ? httpStatusCode : HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

}

