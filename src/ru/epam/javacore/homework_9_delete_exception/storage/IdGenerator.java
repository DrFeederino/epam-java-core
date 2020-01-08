package ru.epam.javacore.homework_9_delete_exception.storage;

public final class IdGenerator {

    private static Long id = 0L;

    private IdGenerator() {
    }

    public static Long generateId() {
        return ++id;
    }
}
