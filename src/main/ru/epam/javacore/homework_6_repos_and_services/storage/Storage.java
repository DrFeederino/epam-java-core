package main.ru.epam.javacore.homework_6_repos_and_services.storage;


import main.ru.epam.javacore.homework_6_repos_and_services.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_6_repos_and_services.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_6_repos_and_services.transportation.domain.Transportation;

public class Storage {

    private static final int ARRAY_CAPACITY = 10;

    public static Cargo[] cargos = new Cargo[ARRAY_CAPACITY];
    public static int cargoIndex = 0;

    public static Carrier[] carriers = new Carrier[ARRAY_CAPACITY];
    public static int carrierIndex = 0;

    public static Transportation[] transportations = new Transportation[ARRAY_CAPACITY];
    public static int transportationIndex = 0;

}
