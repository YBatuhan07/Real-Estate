package com.realestate.dto;

import com.realestate.entities.Account;
import com.realestate.entities.Address;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DtoCustomerIU {
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    @NotNull
    private String tckn;
    @NotNull
    private Date birthDate;
    @NotNull
    private Long addressId;
    @NotNull
    private Long accountId;
}
