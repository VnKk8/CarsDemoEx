package com.CarsDemoEx.demo.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Engine {
    //= уникален номер


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id_car")
    private Long id_engine;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_car")
    private Car car;

    @Column
    private int numberEngine;
    //= кубатура
    @Column
    private int volumeEngine;
    //= конски сили
    @Column
    private int horsePower;


    public Engine() {

    }

    public int getNumberEngine() {
        return numberEngine;
    }

    public int getVolumeEngine() {
        return volumeEngine;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setNumberEngine(int numberEngine) {
        this.numberEngine = numberEngine;
    }

    public void setVolumeEngine(int volumeEngine) {
        this.volumeEngine = volumeEngine;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString(){
        return "Engine" +
                "id= " + numberEngine +
                ", volme of engine= " + volumeEngine +
                ", horse power= " + horsePower;
    }
}

