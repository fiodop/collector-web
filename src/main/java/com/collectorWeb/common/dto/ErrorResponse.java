package com.collectorWeb.common.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class ErrorResponse {
    private String error;
    private String message;
    private LocalDateTime timestamp;

}
