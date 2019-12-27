package ru.epam.javacore.homework_11_file.storage;


import ru.epam.javacore.homework_11_file.cargo.domain.Cargo;
import ru.epam.javacore.homework_11_file.carrier.domain.Carrier;
import ru.epam.javacore.homework_11_file.transportation.domain.Transportation;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private static final int ARRAY_CAPACITY = 10;

    public static Cargo[] cargoArray = new Cargo[ARRAY_CAPACITY];
    public static int cargoIndex = 0;
    public static List<Cargo> cargoCollection = new ArrayList<>();

    public static Carrier[] carrierArray = new Carrier[ARRAY_CAPACITY];
    public static int carrierIndex = 0;
    public static List<Carrier> carrierCollection = new ArrayList<>();

    public static Transportation[] transportationArray = new Transportation[ARRAY_CAPACITY];
    public static int transportationIndex = 0;
    public static List<Transportation> transportationCollection = new ArrayList<>();
}
