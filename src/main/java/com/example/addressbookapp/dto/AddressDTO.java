package com.example.addressbookapp.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@RequiredArgsConstructor

public class AddressDTO {
    @NotNull(message = "fullName cannot be null")
    @Pattern(regexp = "^[A-Z]{2}[a-zA-Z\\s]{2,}$",message ="fullName Invalid" )
    private String fullName;

    private String address;

    @NotNull(message = "Phone No cannot be null")
   // @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$",message = "Phone No Is Invalid")
    private long phoneNumber;

    @NotNull(message = "City cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "City Is Invalid")
    private String city;

    @NotNull(message = "State cannot be null")
    @Pattern(regexp = "^[a-zA-Z\\s]{2,}$", message = "State Is Invalid")
    private String state;

    @NotNull(message = "ZipCode Cannot Be Empty")
    @Pattern(regexp = "^[1-9]{2}[0-9]{4,6}$",message = "Zip Code Is Invalid")
    private String zipCode;

    @NotNull(message = "Email Cannot Be Empty")
    //@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Email Is Invalid")
    private String email;
}
