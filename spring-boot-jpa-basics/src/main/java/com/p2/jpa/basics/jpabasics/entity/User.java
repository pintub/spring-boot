package com.p2.jpa.basics.jpabasics.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 2, message = "Name Should have 2 characters")
    private String fName;

    @NotNull
    private String hobby;

    /*JPA  expects Default Constructor for Entity*/
    protected User(){}

    public User(String fName, String hobby) {
        this.fName = fName;
        this.hobby = hobby;
    }

    public Long getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getHobby() {
        return hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
