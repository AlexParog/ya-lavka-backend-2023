package ru.shbr.ya_lavka2023.exception;

/**
 * Кастомная ошибка NotFound
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
