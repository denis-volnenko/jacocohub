package ru.volnenko.cloud.testhub.exception;

public final class GroupEmptyException extends RuntimeException {

    public GroupEmptyException() {
        super("Ошибка! поле \"group\" пустое...");
    }

}
