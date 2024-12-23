package com.collectorWeb.common.exceptions;

public class DebtorNotExistException extends RuntimeException {
    public DebtorNotExistException(String message) {
        super(message);
    }
}
