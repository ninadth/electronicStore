package com.electronic.store.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String userId;

    @Column(name="NAME",length = 30,nullable = false)
    private String name;

    @Column(name="EMAIL",length = 30,nullable = false)
    private String email;

    @Column(name="PASSWORD",nullable = false)
    private String password;

    @Column(name="GENDER",length = 10,nullable = false)
    private String gender;

    @Column(name="ABOUT",length = 100)
    private String about;

    @Column(name="IMAGE",nullable = false)
    private String imageName;

}
