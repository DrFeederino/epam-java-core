package main.ru.epam.javacore.homework_10_generics.common.business.exception.unchecked;

public class OurCompanyException extends RuntimeException {

    public OurCompanyException(String message) {
        super(message);
    }
}
