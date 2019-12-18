package ru.epam.javacore.homework_7_arrays_and_lists.storage;

public final class IdGenerator {

    private static Long id = 0L;

    private IdGenerator() {
    }

    public static Long generateId() {
        return ++id;
    }
}
