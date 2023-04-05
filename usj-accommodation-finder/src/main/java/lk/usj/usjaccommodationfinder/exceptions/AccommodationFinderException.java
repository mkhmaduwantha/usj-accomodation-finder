package lk.usj.usjaccommodationfinder.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class AccommodationFinderException extends AbstractAccommodationFinderApiException {

    @Serial
    private static final long serialVersionUID = 1946117764883415421L;

    public AccommodationFinderException(HttpStatus httpStatusCode, String errorCode, String message) {
        super(httpStatusCode, errorCode, message);
    }

    public AccommodationFinderException(HttpStatus httpStatusCode, String errorCode, String message, Throwable throwable) {
        super(httpStatusCode, errorCode, message, throwable);
    }

    public AccommodationFinderException(HttpStatus httpStatusCode, String errorCode, String message, String additionalInfo, Throwable throwable) {
        super(httpStatusCode, errorCode, message, additionalInfo, throwable);
    }
}
