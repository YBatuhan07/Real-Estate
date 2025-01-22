package com.realestate.dto;

import com.realestate.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoRealEstateAgent extends DtoBase{
    private String name;
    private String lastName;
    private DtoAddress dtoAddress;
}
