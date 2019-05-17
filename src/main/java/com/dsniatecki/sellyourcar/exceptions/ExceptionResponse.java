package com.dsniatecki.sellyourcar.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
final class ExceptionResponse {

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime timestamp;
    private final String message;
    private final String details;

}
