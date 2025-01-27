package com.collectorWeb.common.exceptions;

import com.collectorWeb.model.dto.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(DataDuplicationException.class)
    public ResponseEntity<ErrorResponse> handleDataDuplicationException(DataDuplicationException ex) {
        logger.error(ex.getMessage());

        ErrorResponse response = ErrorResponse.builder()
                .message(ex.getMessage())
                .error(ex.getClass().getName())
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(DebtorNotExistException.class)
    public ResponseEntity<ErrorResponse> handleDebtorNotExistException(DebtorNotExistException ex) {
        logger.error(ex.getMessage());

        ErrorResponse response = ErrorResponse.builder()
                .error(ex.getClass().getName())
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DebtNotExistException.class)
    public ResponseEntity<ErrorResponse> handleDebtNotExistException(DebtNotExistException ex) {
        logger.error(ex.getMessage());

        ErrorResponse response = ErrorResponse.builder()
                .error(ex.getClass().getName())
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FailedToSendMailException.class)
    public ResponseEntity<ErrorResponse> handleFailedToSendMailException(FailedToSendMailException ex) {
        logger.error(ex.getMessage());

        ErrorResponse response = ErrorResponse.builder()
                .error(ex.getClass().getName())
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
