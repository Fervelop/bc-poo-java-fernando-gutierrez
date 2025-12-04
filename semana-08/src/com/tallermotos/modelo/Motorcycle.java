package com.tallermotos.modelo;

public class Motorcycle {

    //Atributos
    private String plate; // placa de la moto
    private String carBrand; // marca de la moto
    private String model; // modelo de la moto
    private int year; // año de la moto

    //Constructor
    public Motorcycle(String plate, String carBrand, String model, int year) {
        this.plate = plate;
        this.carBrand = carBrand;
        this.model = model;
        this.year = year;
    }

    // Getters y Setters
    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    @Override
    public String toString() {
        return "Motorcycle{" +
                "plate='" + plate + '\'' +
                ", carBrand='" + carBrand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
