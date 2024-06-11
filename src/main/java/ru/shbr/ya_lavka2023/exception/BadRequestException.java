package ru.shbr.ya_lavka2023.exception;

/**
 * Кастомная ошибка BadRequest
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
