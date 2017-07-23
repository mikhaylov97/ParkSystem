package com.epam.park.model;

import com.epam.park.model.roles.OrderStatusEnum;

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
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "forester_id", referencedColumnName = "user_id")
    private User forester;

    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plant plant;

    @Column(name = "number")
    private String amountOfPlants;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "status")
    private String status;

    @Column(name = "description")
    private String description;

    public Order() {

    }


    public Order(Plant plant, String amountOfPlants, String purpose) {
        this.amountOfPlants = amountOfPlants;
        this.purpose = purpose;
        this.plant = plant;
        this.status = OrderStatusEnum.IN_PROGRESS.name();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getForester() {
        return forester;
    }

    public void setForester(User forester) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
