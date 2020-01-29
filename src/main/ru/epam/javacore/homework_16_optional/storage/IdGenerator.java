package main.ru.epam.javacore.homework_16_optional.storage;

import java.util.concurrent.atomic.AtomicLong;

public final class IdGenerator {
    private static AtomicLong idGenerator = new AtomicLong(0);

    private IdGenerator() {
    }

    public static Long generateId() {
        return idGenerator.incrementAndGet();
    }
}
