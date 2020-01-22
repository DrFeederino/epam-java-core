package test.ru.epam.javacore.homework_14_tests;

import main.ru.epam.javacore.homework_13_sax.cargo.domain.ClothersCargo;
import main.ru.epam.javacore.homework_13_sax.cargo.domain.FoodCargo;
import main.ru.epam.javacore.homework_13_sax.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_13_sax.carrier.domain.CarrierType;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static main.ru.epam.javacore.homework_13_sax.common.solutions.comparator.SimpleComparator.LONG_COMPARATOR;
import static main.ru.epam.javacore.homework_13_sax.common.solutions.comparator.SimpleComparator.STRING_COMPARATOR;

public class SerializationTest {
    private final int SAMPLE_SIZE = 10;
    private Path temporaryFile = null;

    @BeforeEach
    public void createTemporaryFile() throws IOException {
        temporaryFile = Files.createTempFile("temp", ".bin");
    }

    @AfterEach
    public void deleteTemporaryFile() {
        deleteFile(temporaryFile);
    }

    @Test
    public void testFoodCargo() throws Exception {
        FoodCargo foodCargo = prepareFood();
        String pathToFile = temporaryFile.toAbsolutePath().toString();

        serializeToFile(foodCargo, pathToFile);
        FoodCargo foodCargoFromFile = readSerializedObjectFromFile(pathToFile);

        Assertions.assertTrue(areFoodEntitiesEqual(foodCargo, foodCargoFromFile));
    }

    @Test
    public void testCollectionFoodCargo() throws Exception {
        List<FoodCargo> food = new ArrayList<>();
        String pathToFile = temporaryFile.toAbsolutePath().toString();

        for (int i = 0; i < SAMPLE_SIZE; i++) {
            food.add(prepareFood());
        }

        serializeToFile(food, pathToFile);
        List<FoodCargo> foodFromFile = readSerializedObjectFromFile(pathToFile);

        Assertions.assertTrue(areFoodEntitiesEqual(food, foodFromFile));
    }

    @Test
    public void testClothesCargo() throws Exception {
        ClothersCargo clothersCargo = prepareClothes();
        String pathToFile = temporaryFile.toAbsolutePath().toString();

        serializeToFile(clothersCargo, pathToFile);
        ClothersCargo clothersCargoFromFile = readSerializedObjectFromFile(pathToFile);

        Assertions.assertTrue(areClothesEqual(clothersCargo, clothersCargoFromFile));
    }

    @Test
    public void testCollectionClothesCargo() throws Exception {
        List<ClothersCargo> list = new ArrayList<>();
        String pathToFile = temporaryFile.toAbsolutePath().toString();

        for (int i = 0; i < SAMPLE_SIZE; i++) {
            list.add(prepareClothes());
        }

        serializeToFile(list, pathToFile);
        List<ClothersCargo> listFromFile = readSerializedObjectFromFile(pathToFile);
        Assertions.assertTrue(areClothesEqual(list, listFromFile));
    }

    @Test
    public void testCarrier() throws Exception {
        Carrier carrier = prepareCarrier();
        String pathToFile = temporaryFile.toAbsolutePath().toString();

        serializeToFile(carrier, pathToFile);
        Carrier carrierFromFile = readSerializedObjectFromFile(pathToFile);

        Assertions.assertTrue(areCarriersEqual(carrier, carrierFromFile));
    }

    @Test
    public void testCollectionCarrier() throws Exception {
        List<Carrier> list = new ArrayList<>();
        String pathToFile = temporaryFile.toAbsolutePath().toString();

        for (int i = 0; i < SAMPLE_SIZE; i++) {
            list.add(prepareCarrier());
        }

        serializeToFile(list, pathToFile);
        List<Carrier> listFromFile = readSerializedObjectFromFile(pathToFile);

        Assertions.assertTrue(areCarriersEqual(list, listFromFile));
    }

    private Carrier prepareCarrier() {
        Carrier carrier = new Carrier();
        carrier.setId(randLong());
        carrier.setName(randString());
        carrier.setCarrierType(randType());
        carrier.setAddress(randString());

        return carrier;
    }


    private ClothersCargo prepareClothes() {
        ClothersCargo clothersCargo = new ClothersCargo();
        clothersCargo.setName(randString());
        clothersCargo.setId(randLong());
        clothersCargo.setSize(randString());
        clothersCargo.setWeight(randInt());
        clothersCargo.setMaterial(randString());

        return clothersCargo;
    }


    private FoodCargo prepareFood() {
        FoodCargo food = new FoodCargo();
        food.setId(randLong());
        food.setName(randString());
        food.setWeight(randInt());
        food.setStoreTemperature(randInt());
        food.setExpirationDate(new Date());

        return food;
    }

    private <T> void serializeToFile(T entity, String path) throws Exception {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(entity);
        }
    }


    private <T> T readSerializedObjectFromFile(String path) throws Exception {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            return (T) objectInputStream.readObject();
        }
    }

    private boolean areFoodEntitiesEqual(FoodCargo a, FoodCargo b) {
        if (a == null && b == null) {
            return true;
        } else if (a != null && b == null) {
            return false;
        } else if (a == null) {
            return false;
        } else {
            return STRING_COMPARATOR.compare(a.getName(), b.getName()) == 0
                    && LONG_COMPARATOR.compare(a.getId(), b.getId()) == 0
                    && a.getWeight() == b.getWeight()
                    && a.getStoreTemperature() == b.getStoreTemperature();
        }
    }

    private boolean areFoodEntitiesEqual(List<FoodCargo> a, List<FoodCargo> b) {
        if (a == null && b == null) {
            return true;
        } else if (a != null && b == null) {
            return false;
        } else if (a == null) {
            return false;
        } else if (a.size() != b.size()) {
            return false;
        } else {
            for (int i = 0; i < a.size(); i++) {
                if (!areFoodEntitiesEqual(a.get(i), b.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    private boolean areClothesEqual(ClothersCargo a, ClothersCargo b) {
        if (a == null && b == null) {
            return true;
        } else if (a != null && b == null) {
            return false;
        } else if (a == null) {
            return false;
        } else {
            return STRING_COMPARATOR.compare(a.getName(), b.getName()) == 0
                    && LONG_COMPARATOR.compare(a.getId(), b.getId()) == 0
                    && STRING_COMPARATOR.compare(a.getMaterial(), b.getMaterial()) == 0;
        }
    }

    private boolean areClothesEqual(List<ClothersCargo> a, List<ClothersCargo> b) {
        if (a == null && b == null) {
            return true;
        } else if (a != null && b == null) {
            return false;
        } else if (a == null) {
            return false;
        } else if (a.size() != b.size()) {
            return false;
        } else {
            for (int i = 0; i < a.size(); i++) {
                if (!areClothesEqual(a.get(i), b.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    private boolean areCarriersEqual(Carrier a, Carrier b) {
        if (a == null && b == null) {
            return true;
        } else if (a != null && b == null) {
            return false;
        } else if (a == null) {
            return false;
        } else {
            return STRING_COMPARATOR.compare(a.getName(), b.getName()) == 0
                    && LONG_COMPARATOR.compare(a.getId(), b.getId()) == 0
                    && STRING_COMPARATOR.compare(a.getAddress(), b.getAddress()) == 0
                    && a.getCarrierType() == b.getCarrierType();
        }
    }

    private boolean areCarriersEqual(List<Carrier> a, List<Carrier> b) {
        if (a == null && b == null) {
            return true;
        } else if (a != null && b == null) {
            return false;
        } else if (a == null) {
            return false;
        } else if (a.size() != b.size()) {
            return false;
        } else {
            for (int i = 0; i < a.size(); i++) {
                if (!areCarriersEqual(a.get(i), b.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    private CarrierType randType() {
        return Arrays.asList(CarrierType.values()).get(RandomUtils.nextInt(0, 4));
    }

    private String randString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    private int randInt() {
        return RandomUtils.nextInt();
    }

    private long randLong() {
        return RandomUtils.nextLong();
    }

    private void deleteFile(Path file) {
        if (file != null && file.toFile().isFile()) {
            try {
                Files.delete(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
