package main.ru.epam.javacore.homework_6_repos_and_services.storage;

public final class IdGenerator {

    private static Long id = 0L;

    private IdGenerator() {
    }

    public static Long generateId() {
        return ++id;
    }
}
