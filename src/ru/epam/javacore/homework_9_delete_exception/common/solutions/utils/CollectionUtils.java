package ru.epam.javacore.homework_9_delete_exception.common.solutions.utils;

import java.util.Collection;

public final class CollectionUtils {

    private CollectionUtils() {

    }

    public static void printCollection(Collection<?> collection) {
        for (Object obj : collection) {
            System.out.println(obj.toString());
        }
    }

}
