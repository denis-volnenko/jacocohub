package ru.volnenko.cloud.testhub.exception;

public final class NameEmptyException extends RuntimeException {

    public NameEmptyException() {
        super("Ошибка! Поле \"name\" пустое...");
    }
}
