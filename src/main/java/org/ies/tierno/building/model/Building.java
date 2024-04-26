package org.ies.tierno.building.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ies.tierno.Exceptions.ApartmentNotFoundException;

import java.util.List;

@Data
@AllArgsConstructor
public class Building {
    private String address;
    private String city;
    private int zipCode;
    private List<Apartment> apartments;


    public Apartment getApartment(int floor, String door) throws ApartmentNotFoundException {
        for (Apartment apartment : apartments) {
            if (apartment.getDoor().equals(door) && apartment.getFloor() == floor) {
                return apartment;
            }
        }
        throw new ApartmentNotFoundException(floor, door);
    }
    public Owner getOwners(int floor, String door) throws ApartmentNotFoundException{
        for (Apartment apartment : apartments) {
            for (Owner owner: apartment.getOwners())
                if (apartment.getDoor().equals(door) && apartment.getFloor() == floor) {
                    return owner;
                }
        }
        throw new ApartmentNotFoundException(floor, door);
    }

}






