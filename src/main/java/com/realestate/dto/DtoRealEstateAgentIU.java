package com.realestate.dto;

import com.realestate.entities.Address;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoRealEstateAgentIU {
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    @NotNull
    private Long addressId;
}
