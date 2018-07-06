package com.p2.jpa.basics.jpabasics.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String fName;
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
