package main.ru.epam.javacore.homework_7_arrays_and_lists.storage;


import main.ru.epam.javacore.homework_7_arrays_and_lists.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_7_arrays_and_lists.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_7_arrays_and_lists.transportation.domain.Transportation;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private static final int ARRAY_CAPACITY = 10;

    public static Cargo[] cargos = new Cargo[ARRAY_CAPACITY];
    public static int cargoIndex = 0;
    public static List<Cargo> listOfCargos = new ArrayList<>();

    public static Carrier[] carriers = new Carrier[ARRAY_CAPACITY];
    public static int carrierIndex = 0;
    public static List<Carrier> listOfCarriers = new ArrayList<>();

    public static Transportation[] transportations = new Transportation[ARRAY_CAPACITY];
    public static int transportationIndex = 0;
    public static List<Transportation> listOfTransportations = new ArrayList<>();
}
