package ru.epam.javacore.homework_9_delete_exception.cargo.service;

import ru.epam.javacore.homework_9_delete_exception.cargo.domain.Cargo;
import ru.epam.javacore.homework_9_delete_exception.cargo.repo.CargoRepo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CargoServiceImpl implements CargoService {

    private CargoRepo cargoRepo;

    public CargoServiceImpl(CargoRepo cargoRepo) {
        this.cargoRepo = cargoRepo;
    }

    @Override
    public void updateCargo(Cargo cargo) {
        cargoRepo.updateCargo(cargo);
    }

    @Override
    public void add(Cargo cargo) {
        cargoRepo.add(cargo);
    }

    @Override
    public Cargo getById(Long id) {
        if (id != null) {
            return cargoRepo.getById(id);
        }
        return null;
    }

    @Override
    public List<Cargo> getAll() {
        return cargoRepo.getAll();
    }

    @Override
    public List<Cargo> getByName(String name) {
        Cargo[] found = cargoRepo.getByName(name);
        return (found == null || found.length == 0) ? Collections.emptyList() : Arrays.asList(found);
    }

    @Override
    public boolean deleteById(Long id) {
        return cargoRepo.deleteById(id);
    }

    @Override
    public void printAll() {
        List<Cargo> allCargos = cargoRepo.getAll();

        for (Cargo cargo : allCargos) {
            System.out.println(cargo);
        }
    }

    @Override
    public void sortCargosByName() {
        List<Cargo> cargos = getAll();
        cargos.sort((Cargo o1, Cargo o2) ->
                o1.getName().compareTo(o2.getName()));
    }

    @Override
    public void sortCargosByWeight() {
        List<Cargo> cargos = getAll();
        cargos.sort((Cargo o1, Cargo o2) ->
                Integer.compare(o1.getWeight(), o2.getWeight()));
    }

    @Override
    public void sortCargosByWeightAndName() {
        List<Cargo> cargos = getAll();
        cargos.sort(new Comparator<Cargo>() {
            @Override
            public int compare(Cargo o1, Cargo o2) {
                String o1Name = o1.getName();
                String o2Name = o2.getName();
                int namesComparison = o1Name.compareTo(o2Name);
                if (namesComparison != 0) {
                    return namesComparison;
                }
                Integer o1Weight = o1.getWeight();
                Integer o2Weight = o2.getWeight();
                return o1Weight.compareTo(o2Weight);
            }
        });
    }
}
