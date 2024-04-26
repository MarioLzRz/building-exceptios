package org.ies.tierno.building.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Building {
    private String address;
    private String city;
    private int zipCode;
    private List<Apartment> apartments;


    public Apartment getApartment(int floor, String door) {
        for (Apartment apartment : apartments) {
            if (apartment.getDoor().equals(door)&&apartment.getFloor()==floor){
                return apartment;
            }

        }
        return null; //No es null, hay que poner la excepcion
    }

    public class ApartmentNotFoundException extends Exception{


    }

}

