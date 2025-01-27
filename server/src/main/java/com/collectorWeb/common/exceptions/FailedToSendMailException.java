package com.collectorWeb.common.exceptions;

public class FailedToSendMailException extends RuntimeException {
    public FailedToSendMailException(String message) {
        super(message);
    }
}
