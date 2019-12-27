package ru.epam.javacore.homework_11_file.storage.initor;

import ru.epam.javacore.homework_11_file.application.serviceholder.ServiceHolder;
import ru.epam.javacore.homework_11_file.cargo.domain.Cargo;
import ru.epam.javacore.homework_11_file.cargo.domain.ClothesCargo;
import ru.epam.javacore.homework_11_file.cargo.domain.FoodCargo;
import ru.epam.javacore.homework_11_file.cargo.service.CargoService;
import ru.epam.javacore.homework_11_file.carrier.domain.Carrier;
import ru.epam.javacore.homework_11_file.carrier.domain.CarrierType;
import ru.epam.javacore.homework_11_file.carrier.service.CarrierService;
import ru.epam.javacore.homework_11_file.transportation.domain.Transportation;
import ru.epam.javacore.homework_11_file.transportation.service.TransportationService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static ru.epam.javacore.homework_11_file.common.solutions.utils.CollectionUtils.isNotEmpty;

public class FromFileStorageInitor implements StorageInitor {

    private static final int TOTAL_ENTITIES = 3;

    private final CarrierService carrierService;
    private final CargoService cargoService;
    private final TransportationService transportationService;

    private String pathname = getClass().getResource("Storage.txt").getPath();
    private List<String>[] arrayOfLists = new ArrayList[TOTAL_ENTITIES];

    public FromFileStorageInitor() {
        carrierService = ServiceHolder.getInstance().getCarrierService();
        cargoService = ServiceHolder.getInstance().getCargoService();
        transportationService = ServiceHolder.getInstance().getTransportationService();
    }

    public FromFileStorageInitor(String path) {
        carrierService = ServiceHolder.getInstance().getCarrierService();
        cargoService = ServiceHolder.getInstance().getCargoService();
        transportationService = ServiceHolder.getInstance().getTransportationService();
        pathname = path;
    }

    @Override
    public void initStorage() {
        initFileReader();
        initCargos();
        initCarriers();
        initTransportations();
        appendTransportationsToCargos();
    }

    private void initFileReader() {
        if (pathname != null && !pathname.isEmpty()) {
            readFile();
        } else {
            System.out.println("Pathname is not set, abort!");
        }
    }

    private void readFile() {
        File file = new File(pathname);
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(file)
        )) {
            List<String> list = new ArrayList<>();
            String line;
            int idx = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("BEGIN")) {
                    list = new ArrayList<>();
                    continue;
                }
                if (line.contains("END")) {
                    arrayOfLists[idx++] = list;
                    continue;
                }
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initCargos() {
        for (int i = 0; i < arrayOfLists[0].size(); i++) {
            String line = arrayOfLists[0].get(i);
            String[] props = line.split(" ");
            if (line.contains("CLOTHES")) {
                cargoService.save(createClothesCargo(props));
            } else {
                cargoService.save(createFoodCargo(props));
            }
        }
    }

    private ClothesCargo createClothesCargo(String[] props) {
        ClothesCargo cargo = new ClothesCargo();
        cargo.setName(props[1]);
        cargo.setWeight(Integer.parseInt(props[2]));
        cargo.setSize(props[props.length - 1]);

        return cargo;
    }

    private FoodCargo createFoodCargo(String[] props) {
        FoodCargo cargo = new FoodCargo();
        cargo.setName(props[1]);
        cargo.setWeight(Integer.parseInt(props[2]));
        cargo.setExpirationDate(new Date(props[3]));
        cargo.setStoreTemperature(Integer.parseInt(props[props.length - 1]));

        return cargo;
    }

    private void initCarriers() {
        for (int i = 0; i < arrayOfLists[1].size(); i++) {
            String[] props = arrayOfLists[1].get(i).split(" ");
            Carrier carrier = createCarrier(props);
            carrierService.save(carrier);
        }
    }

    private Carrier createCarrier(String[] props) {
        Carrier carrier = new Carrier();
        carrier.setName(props[0]);
        carrier.setAddress(props[1]);
        carrier.setCarrierType(CarrierType.valueOf(props[props.length - 1].toUpperCase()));
        return carrier;
    }

    private void initTransportations() {
        for (int i = 0; i < arrayOfLists[2].size(); i++) {
            String description = arrayOfLists[2].get(i);
            Transportation transportation = createTransportation(i + 1, i + 1 + arrayOfLists[0].size(), description);
            transportationService.save(transportation);
        }
    }

    private Transportation createTransportation(long cargoId, long carrierId, String description) {
        Transportation transportation = new Transportation();
        transportation.setCargo(cargoService.findById(cargoId));
        transportation.setCarrier(carrierService.findById(carrierId));
        transportation.setDescription(description);

        return transportation;
    }

    private void appendTransportationsToCargos() {
        List<Cargo> cargos = cargoService.getAll();
        List<Transportation> transportations = transportationService.getAll();

        if (isNotEmpty(cargos) && isNotEmpty(transportations)) {
            for (Cargo cargo : cargos) {
                appendTransportationsToCargo(cargo, transportations);
            }
        }
    }

    private void appendTransportationsToCargo(Cargo cargo,
                                              List<Transportation> transportations) {

        List<Transportation> cargoTransportations = cargo.getTransportations();
        if (cargoTransportations == null) {
            cargoTransportations = new ArrayList<>();
        }

        for (Transportation transportation : transportations) {
            if (transportation.getCargo() != null && transportation.getCargo().getId()
                    .equals(cargo.getId())) {
                cargoTransportations.add(transportation);
            }
        }

        cargo.setTransportations(transportations);
    }

    public String getPathname() {
        return pathname;
    }

    public void setPathname(String pathname) {
        this.pathname = pathname;
    }
}
