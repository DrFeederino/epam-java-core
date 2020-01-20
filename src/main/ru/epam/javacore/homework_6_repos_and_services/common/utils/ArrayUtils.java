package main.ru.epam.javacore.homework_6_repos_and_services.common.utils;

public final class ArrayUtils {

    private ArrayUtils() {
    }

    public static void copyArray(Object[] src, Object[] dest) {
        System.arraycopy(src, 0, dest, 0, src.length);
    }

    public static void printArray(Object[] arr) {
        for (Object obj : arr) {
            if (obj != null) {
                System.out.println(obj);
            }
        }
    }

    public static void copyOfRangeArray(Object[] src, Object[] dest, int range) {
        System.arraycopy(src, 0, dest, 0, range);
    }
}