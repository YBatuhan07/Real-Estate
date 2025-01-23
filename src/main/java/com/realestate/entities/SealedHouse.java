package com.realestate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"realEstateAgent","house","customer"})})
@NoArgsConstructor
@AllArgsConstructor
public class SealedHouse extends BaseEntity {

    @ManyToOne
    private RealEstateAgent realEstateAgent;
    @ManyToOne
    private House house;
    @ManyToOne
    private Customer customer;
}
