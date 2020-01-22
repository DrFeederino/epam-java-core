package main.ru.epam.javacore.homework_15_threads.storage;

public final class IdGenerator {

    private static Long id = 0L;

    private IdGenerator() {
    }

    public static Long generateId() {
        return ++id;
    }
}
