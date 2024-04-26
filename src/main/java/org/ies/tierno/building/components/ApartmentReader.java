package org.ies.tierno.building.components;

import org.ies.tierno.building.model.Apartment;
import org.ies.tierno.building.model.Owner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class ApartmentReader implements Reader<Apartment> {
    private final static Logger log = LoggerFactory.getLogger(ApartmentReader.class);

    private final Scanner scanner;
    private final Reader<Owner> ownerReader;

    public ApartmentReader(Scanner scanner, Reader<Owner> ownerReader) {
        this.scanner = scanner;
        this.ownerReader = ownerReader;
    }

    @Override
    public Apartment read() {
        int floor = readInt("Introduce la planta");
        log.info("Introduce la puerta");
        String door = scanner.nextLine();
        List<Owner> owners = readOwners();

        return new Apartment(floor, door, owners);
    }

    public List<Owner> readOwners() {
        List<Owner> owners = new ArrayList<>();
        boolean moreOwners = true;
        log.info("Propietarios");
        do {
            log.info("Introduce propietario");
            owners.add(ownerReader.read());
            log.info("¿Desea meter más propietarios? (Y/n)");
            String response = scanner.nextLine();
            moreOwners = !response.equalsIgnoreCase("n");

        } while(moreOwners);
        return owners;
    }

    public int readInt(String message) {
        Integer number = null;
        do {
            try {
                log.info(message);
                number = scanner.nextInt();
            } catch (InputMismatchException e) {
                log.error("El valor introducido no es un entero");
            } finally {
                scanner.nextLine();
            }
        } while (number == null);
        return number;
    }
}
