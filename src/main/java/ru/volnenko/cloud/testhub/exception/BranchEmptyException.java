package ru.volnenko.cloud.testhub.exception;

public final class BranchEmptyException extends RuntimeException {

    public BranchEmptyException() {
        super("Ошибка! Поле \"branch\" пустое...");
    }
}
