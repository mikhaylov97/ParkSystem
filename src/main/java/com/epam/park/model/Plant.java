package com.epam.park.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "plants")
public class Plant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plant_id")
    private long id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image", nullable = false, length = 60)
    private String image;

    public Plant() {
    }

    public Plant(String name, String type, String description, String image) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
