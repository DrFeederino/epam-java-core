package main.ru.epam.javacore.homework_16_optional.common.business.domain;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
