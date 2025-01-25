package com.realestate.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoSealedHouseIU {
    @NotNull
    private Long realEstateAgentId;
    @NotNull
    private Long houseId;
    @NotNull
    private Long customerId;
}
