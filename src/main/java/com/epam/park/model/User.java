package com.epam.park.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Column(name = "role")
    private String role;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
//    private List<Order> orderList;

    @Column(name = "email", nullable = false, length = 30)
    private String email;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "surname", nullable = false, length = 20)
    private String surname;

    public User() {
    }

    public User(String role, String email, String password, String name, String surname) {
        this.role = role;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
