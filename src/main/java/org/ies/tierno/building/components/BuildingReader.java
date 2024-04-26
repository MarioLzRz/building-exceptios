package org.ies.tierno.building.components;

import lombok.AllArgsConstructor;
import org.ies.tierno.building.model.Apartment;
import org.ies.tierno.building.model.Building;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class BuildingReader implements Reader<Building> {
    private Scanner scanner;
    private final Reader<Apartment> apartmentReader;
    private final static Logger log = LoggerFactory.getLogger(BuildingReader.class);

    @Override
    public Building read() {
        log.info("Introduce la dirección");
        String address = scanner.nextLine();
        log.info("Introduce la ciudad");
        String city = scanner.nextLine();
        int zipCode = readInt("Introduce el codigo postal");
        List<Apartment> apartments = readApartments();

        return new Building(address, city, zipCode, apartments);

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
     public List<Apartment> readApartments() {
        List<Apartment> apartments = new ArrayList<>();
        boolean moreApartment = true;
        log.info("Apartamentos:");
        do {
            log.info("Introduce un apartamento");
            apartments.add(apartmentReader.read());
            log.info("¿Desea meter más apartamentos? (Y/n)");
            String response = scanner.nextLine();
            moreApartment = !response.equalsIgnoreCase("n");
        } while (moreApartment);
        return apartments;
     }






}
