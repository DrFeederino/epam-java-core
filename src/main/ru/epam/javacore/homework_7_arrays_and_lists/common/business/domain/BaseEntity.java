package main.ru.epam.javacore.homework_7_arrays_and_lists.common.business.domain;

public abstract class BaseEntity {
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
