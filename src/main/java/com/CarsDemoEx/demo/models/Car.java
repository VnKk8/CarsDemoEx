package com.CarsDemoEx.demo.models;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Car{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_car;
    //= двигател
    @Column
    private int numberEngine;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_engine")
    private Engine engine;

    //= собственик
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_owner")
    private Owner owner;


    //= марка
    @Column
    private String branCar;
    //= модел
    @Column
    private String modelCar;
    //= година на производство
    @Column
    private int yearMade;
    //= номер на автомобил
    @Column
    private String plateNumber;



    public Car() {

    }

    public int getNumberEngine() {
        return numberEngine;
    }

    public String getOwner() {
        return owner.getNameOwner();
    }

    public String getBranCar() {
        return branCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public int getYearMade() {
        return yearMade;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setNumberEngine(int numberEngine) {
        this.numberEngine = numberEngine;
    }

    /*public void setOwner(String owner) {
        this.owner = owner.;
    } */

    public void setBranCar(String branCar) {
        this.branCar = branCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }


    @Override
    public String toString(){
        return "Car" +
                "brand= " + branCar +
                ", model= " + modelCar +
                ", engine number= " + numberEngine +
                ", year made= " + yearMade +
                ", plate number= " + plateNumber;
    }
}
