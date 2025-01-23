package com.realestate.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoRealEstateAgentHouseIU {
    @NotNull
    private Long realEstateAgentId;
    @NotNull
    private Long houseId;
}
