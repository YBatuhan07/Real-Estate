package com.realestate.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"realEstateAgent","house"})})
@NoArgsConstructor
@AllArgsConstructor
public class ReasEstateAgentHouse extends BaseEntity {

    @ManyToOne
    private RealEstateAgent realEstateAgent;
    @ManyToOne
    private House house;
}
