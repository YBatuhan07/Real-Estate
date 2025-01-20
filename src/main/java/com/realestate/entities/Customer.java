package com.realestate.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {
    private String name;
    private String lastName;
    private String tckn;
    private Date birthDate;
    @OneToOne
    private Address address;
    @OneToOne
    private Account account;
}
