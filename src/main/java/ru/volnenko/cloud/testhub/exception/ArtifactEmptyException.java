package ru.volnenko.cloud.testhub.exception;

public final class ArtifactEmptyException extends RuntimeException {

    public ArtifactEmptyException() {
        super("Ошибка! Поле \"artifact\" пустое...");
    }
}
