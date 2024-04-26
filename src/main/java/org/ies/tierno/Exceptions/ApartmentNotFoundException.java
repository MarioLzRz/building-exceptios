package org.ies.tierno.Exceptions;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApartmentNotFoundException extends Exception{
    private int floor;
    private String door;
}
