package main.ru.epam.javacore.homework_17_date_stream.storage;

import java.util.concurrent.atomic.AtomicLong;

public final class IdGenerator {
    private static AtomicLong idGenerator = new AtomicLong(0);

    private IdGenerator() {
    }

    public static Long generateId() {
        return idGenerator.incrementAndGet();
    }
}
