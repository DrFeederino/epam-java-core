package main.ru.epam.javacore.homework_6_repos_and_services.carrier.repo;

import main.ru.epam.javacore.homework_6_repos_and_services.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_6_repos_and_services.common.utils.ArrayUtils;
import main.ru.epam.javacore.homework_6_repos_and_services.storage.IdGenerator;

import java.util.Objects;

import static main.ru.epam.javacore.homework_6_repos_and_services.storage.Storage.carrierIndex;
import static main.ru.epam.javacore.homework_6_repos_and_services.storage.Storage.carriers;

public class CarrierRepoImpl implements CarrierRepo {
    @Override
    public Carrier[] getAll() {
        Carrier[] nonNullCarriers;
        int entries = 0;
        for (Carrier carrier : carriers) {
            if (carrier != null) {
                entries++;
            }
        }
        nonNullCarriers = new Carrier[entries];
        for (int i = 0, j = 0; i < carriers.length; i++) {
            Carrier carrier = carriers[i];
            if (carrier != null) {
                nonNullCarriers[j++] = carrier;
            }
        }
        return nonNullCarriers;
    }

    @Override
    public void add(Carrier carrier) {
        carrier.setId(IdGenerator.generateId());
        carriers[carrierIndex] = carrier;
        carrierIndex++;

        if (carrierIndex == carriers.length) {
            Carrier[] newCarriers = new Carrier[carriers.length * 2];
            ArrayUtils.copyArray(carriers, newCarriers);
            carriers = newCarriers;
        }
    }

    @Override
    public void delete(long id) {
        Carrier[] newCarriers = new Carrier[carriers.length];
        for (int i = 0, j = 0; i < carriers.length - 1; i++) {
            Carrier carrier = carriers[i];
            if (carrier != null && Long.valueOf(id).equals(carrier.getId())) {
                carrierIndex--;
            } else {
                newCarriers[j++] = carrier;
            }
        }
        carriers = newCarriers;
    }

    @Override
    public Carrier findById(long id) {
        for (Carrier carrier : carriers) {
            if (carrier != null && Long.valueOf(id).equals(carrier.getId())) {
                return carrier;
            }
        }

        return null;
    }

    @Override
    public Carrier[] findByName(String name) {
        Carrier[] result = new Carrier[carriers.length];

        int curIndex = 0;
        for (Carrier carrier : carriers) {
            if (carrier != null && Objects.equals(carrier.getName(), name)) {
                result[curIndex++] = carrier;
            }
        }
        Carrier[] trimmedResult = new Carrier[curIndex];
        ArrayUtils.copyOfRangeArray(result, trimmedResult, curIndex);
        return trimmedResult;
    }

    @Override
    public void printAll() {
        ArrayUtils.printArray(carriers);
    }
}
