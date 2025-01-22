package com.realestate.dto;

import com.realestate.entities.BaseEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DtoCustomer extends BaseEntity {
    private String name;
    private String lastName;
    private String tckn;
    private Date birthDate;
    private DtoAddress address;
    private DtoAccount account;
}
