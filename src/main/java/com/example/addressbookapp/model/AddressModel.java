package com.example.addressbookapp.model;

import com.example.addressbookapp.dto.AddressDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor

public class AddressModel {
    @Id
    @GeneratedValue

    private int id;
    private String fullName;
    private String address;
    private long phoneNumber;
    private String city;
    private String state;
    private String zipCode;
    private String email;

    private String token;


    public AddressModel(AddressDTO addressDTO) {
        this.fullName = addressDTO.getFullName();
        this.address = addressDTO.getAddress();
        this.phoneNumber = addressDTO.getPhoneNumber();
        this.city = addressDTO.getCity();
        this.state = addressDTO.getState();
        this.zipCode = addressDTO.getZipCode();
        this.email = addressDTO.getEmail();
    }

        public AddressModel(int id, AddressDTO addressDTO) {
            this.id= id;
            this.fullName=addressDTO.getFullName();
            this.address=addressDTO.getAddress();
            this.phoneNumber=addressDTO.getPhoneNumber();
            this.city=addressDTO.getCity();
            this.state=addressDTO.getState();
            this.zipCode=addressDTO.getZipCode();
            this.email=addressDTO.getEmail();
    }

    public AddressModel(AddressModel addressModel, Integer id) {
        this.id= id;
        this.fullName=addressModel.getFullName();
        this.address=addressModel.getAddress();
        this.phoneNumber=addressModel.getPhoneNumber();
        this.city=addressModel.getCity();
        this.state=addressModel.getState();
        this.zipCode=addressModel.getZipCode();
        this.email=addressModel.getEmail();

    }

    public AddressModel(AddressDTO addressNew, Integer id) {
        this.id=id;
        this.fullName=addressNew.getFullName();
        this.address=addressNew.getAddress();
        this.phoneNumber=addressNew.getPhoneNumber();
        this.city=addressNew.getCity();
        this.state=addressNew.getState();
        this.zipCode=addressNew.getZipCode();
        this.email=addressNew.getEmail();

    }
}
