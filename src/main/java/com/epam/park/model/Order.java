package com.epam.park.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders")
public class Order implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "forester_id")
    private Forester forester;

    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plant plant;

    @Column(name = "number")
    private String amountOfPlants;

    @Column(name = "purpose")
    private String purpose;

    public Order(String amountOfPlants, String purpose) {
        this.amountOfPlants = amountOfPlants;
        this.purpose = purpose;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Forester getForester() {
        return forester;
    }

    public void setForester(Forester forester) {
        this.forester = forester;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public String getAmountOfPlants() {
        return amountOfPlants;
    }

    public void setAmountOfPlants(String amountOfPlants) {
        this.amountOfPlants = amountOfPlants;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
