package ru.epam.javacore.homework_6_repos_and_services.common.domain;

public abstract class BaseEntity {
  protected Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
