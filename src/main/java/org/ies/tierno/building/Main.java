package org.ies.tierno.building;

import org.ies.tierno.building.components.ApartmentReader;
import org.ies.tierno.building.components.OwnerReader;
import org.ies.tierno.building.components.Reader;
import org.ies.tierno.building.model.Apartment;
import org.ies.tierno.building.model.Owner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {

    private final static Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var ownerReader = new OwnerReader();
        var apartmentReader = new ApartmentReader(scanner, ownerReader);

        var apartment = apartmentReader.read();

        log.info(apartment.toString());
    }

}