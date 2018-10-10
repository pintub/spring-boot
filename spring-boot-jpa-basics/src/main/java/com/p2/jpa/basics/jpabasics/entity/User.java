package com.p2.jpa.basics.jpabasics.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@ApiModel(description="All details about the user.")//Doc for Model User class
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 2, message = "Name Should have 2 characters")
    @ApiModelProperty(notes="Name should have atleast 2 characters")
    private String fName;

    @NotNull
    private String hobby;

    /*JPA  expects Default Constructor for Entity*/
    protected User(){}

    @OneToMany(mappedBy="user")//Relationship column user
    private List<Post> posts;

    public User(String fName, String hobby) {
        this.fName = fName;
        this.hobby = hobby;
    }

    public Long getId() {
        return id;
    }

    public List<Post> getPosts() {
        return posts;
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
