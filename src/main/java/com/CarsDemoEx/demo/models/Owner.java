package com.CarsDemoEx.demo.models;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Owner {

    //= имена
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_owner;

    // @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name = "id_car")
    // private Owner owner;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Car> carOwned;

    @Column
    private String nameOwner;


    //= дата на раждане DD/MM/YYYY

    @Column
    private String dateBirthOwner;


    public Owner() {

    }

    public String getNameOwner() {
        return nameOwner;
    }

    public String getDateBirthOwner() {
        return dateBirthOwner;
    }

    public void setNameOwner(String nameOwner) {
        this.nameOwner = nameOwner;
    }

    public void setDateBirthOwner(String dateBirthOwner) {
        this.dateBirthOwner = dateBirthOwner;
    }

    @Override
    public String toString(){
        return "Owner" +
                "id= " + id_owner +
                ", name= " + nameOwner +
                ", date of birth= " + dateBirthOwner;
    }
}



