package lk.usj.usjaccommodationfinder.controller;

import lk.usj.usjaccommodationfinder.common.ErrorCodes;
import lk.usj.usjaccommodationfinder.error.ErrorResponse;
import lk.usj.usjaccommodationfinder.exceptions.AbstractAccommodationFinderApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.MessageFormat;
import java.util.Locale;


/**
 * The Abstract controller class
 */
public abstract class AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractController.class);

    private static final String ERROR_PLACEHOLDER = "errors.{0}";
    private static final String UNKNOWN_ERROR = "Unknown Error";

    @Qualifier("messageSource")
    @Autowired
    private MessageSource messages;

    @ExceptionHandler(AbstractAccommodationFinderApiException.class)
    @ResponseBody
    private ResponseEntity<ErrorResponse> handleCheckedException(AbstractAccommodationFinderApiException ex) {
        LOGGER.error("Handling AbstractDeliveryApiException errorCode: {}, error details: {}", ex.getErrorCode(), ex.getAdditionalInfo(), ex);

        return handleException(ex.getErrorCode(), ex.getAdditionalInfo(), ex.getMessage(), ex.getHttpStatusCode());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    private ResponseEntity<ErrorResponse> handleException(Exception ex) {
        LOGGER.error("Handling unknown Exception", ex);

        String message = this.messages.getMessage(
              MessageFormat.format(ERROR_PLACEHOLDER, ErrorCodes.ERR_CODE_GENERIC_INTERNAL_SRV_ERR), new Object[]{}, UNKNOWN_ERROR, Locale.getDefault());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ErrorResponse errorResponse = createError(ErrorCodes.ERR_CODE_GENERIC_INTERNAL_SRV_ERR, message, ex.getMessage());
        return new ResponseEntity<>(errorResponse, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse> handleException(String errorCode, String additionalInfo, String message2, HttpStatus httpStatusCode) {
        String message =
              this.messages.getMessage(
                    MessageFormat.format(ERROR_PLACEHOLDER, (errorCode)), new Object[]{}, UNKNOWN_ERROR, Locale.getDefault());
        ErrorResponse errorResponse;
        if (additionalInfo != null) {
            errorResponse = createError(errorCode, message, additionalInfo);
        } else {
            errorResponse = createError(errorCode, message, message2);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(errorResponse, headers, httpStatusCode);
    }

    private ErrorResponse createError(String errorCode, String description, String additionalInfo) {
        return new ErrorResponse(errorCode, description, additionalInfo);
    }
}
