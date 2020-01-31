package main.ru.epam.javacore.homework_17_date_stream.common.solutions.comparator;

import java.util.Comparator;

public final class SimpleComparator {

    public static final Comparator<String> STRING_COMPARATOR = (s1, s2) -> {
        if (s1 == null && s2 == null) {
            return 0;
        } else if (s1 != null) {
            return s1.compareTo(s2);
        } else {
            return -1;
        }

    };

    public static final Comparator<Long> LONG_COMPARATOR = (l1, l2) -> {
        if (l1 == null && l2 == null) {
            return 0;
        } else if (l1 != null) {
            return l1.compareTo(l2);
        } else {
            return -1;
        }

    };

}
