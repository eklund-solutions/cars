package com.erik.car;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Car {

    private String model;            // Namn på bilmodel
    private int constructedYear;     // Tillverkningsår
    private String licensePlate;     // Referens på registreringsskylt, t.ex. ABC123
    private boolean isLicensePlateSwedishStandard;   // Är registeringsskylten av svensk standardtyp


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }
    public String getModel() {
        return model;
    }
    public Integer getConstructedYear() {
        return constructedYear;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public boolean getIsLicensePlateSwedishStandard() {
        return isLicensePlateSwedishStandard;
    } 

    
    public void setModel(String v)
    {
        model = v;
    }
    public void setConstructedYear(int v)
    {
        constructedYear = v;
    }
    public void setLicensePlate(String v)
    {
        licensePlate = v;
        isLicensePlateSwedishStandard = isLicensePlateSwedishStandard();
    }


    // Innehåller strängen endast bokstäver (A-Z)
    public boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }
    // Innehåller strängen endast siffror (0-9)
    public boolean isNumber(String name) {
        return name.matches("[0-9]+");
    }
    // Avgör om registreringsskylten är av svensk standard
    public boolean isLicensePlateSwedishStandard()
    {
        boolean status = false;

        if (
            licensePlate != null
            && licensePlate.length() == 6
            && isAlpha(licensePlate.substring(0, 3))
            && isNumber(licensePlate.substring(3, 6))
        ) status = true;

        return status;            
    }
    
}

