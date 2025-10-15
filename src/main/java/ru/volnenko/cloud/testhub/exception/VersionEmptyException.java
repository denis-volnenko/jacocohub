package ru.volnenko.cloud.testhub.exception;

public final class VersionEmptyException extends RuntimeException {

    public VersionEmptyException() {
        super("Ошибка! поле \"version\" пустое...");
    }

}
