package com.atshop.user.entity;

import javax.persistence.*;

@Entity(name = "Phone")
public   class Phone {

    @Id
    private Long id;

    @Column(name = "phone_number")
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "phone_type")
    private PhoneType type;

    //Getters and setters are omitted for brevity

}