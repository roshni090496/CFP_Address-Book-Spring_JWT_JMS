package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressDTO;
import com.example.addressbookapp.dto.ResponseDTO;
import com.example.addressbookapp.model.AddressModel;
import com.example.addressbookapp.service.AddressService;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated

public class AddressController {
    @Autowired
    AddressService service;

    @RequestMapping("/welcome")
   public String displayMessage()
    {
        return "Hello World!";
    }

//    @PostMapping("/addUser")
//    public ResponseEntity<ResponseDTO> addUser(@Valid @RequestBody AddressDTO address){
//        AddressModel addressModel1= service.saveAddress(address);
//        ResponseDTO response = new ResponseDTO("add all Users",addressModel1);
//        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
//    }

    @PostMapping(value = "/insert")
    public ResponseEntity<String> addAddressPayRollData(@Valid @RequestBody AddressDTO address) throws Exception {
       AddressModel addressModel = service.addRecord(address);
        ResponseDTO dto = new ResponseDTO("Record added successfully",addressModel);
        return new ResponseEntity(dto,HttpStatus.CREATED);
    }


    @GetMapping(value = "/insert/{token}")
    public ResponseEntity<String> addAddressPayRollData(@PathVariable String token) throws Exception {
        ResponseDTO dto = new ResponseDTO("Record added successfully",service.getRecord(token));
        return new ResponseEntity(dto,HttpStatus.OK);
    }

    @GetMapping("/addressById/{id}")
    public ResponseEntity<ResponseDTO> getAddressById(@PathVariable Integer id){
        AddressModel addressModel1=service.findaddressById(id);
        ResponseDTO response = new ResponseDTO("get address By Id",addressModel1);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/retrive/{token}")
    public ResponseEntity<ResponseDTO> getAddressPayRollData(@PathVariable String token)
    {
    AddressModel entity = service.getAddressPayRollData(token);
        ResponseDTO dto = new ResponseDTO("Data retrived successfully (:",entity);
        return new ResponseEntity(dto,HttpStatus.OK);
    }

    @GetMapping("/allAddress")
    public ResponseEntity<ResponseDTO> findAllAddress() {
        List<AddressModel> addressModel1 = service.findAddress();
        ResponseDTO response = new ResponseDTO("get all Address", addressModel1);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @PutMapping("/editAddress/{id}")
    public ResponseEntity<ResponseDTO> editAddress(@Valid @RequestBody AddressDTO address, @PathVariable Integer id){
        AddressModel addressModel1=service.editAddress(address,id);
        ResponseDTO response = new ResponseDTO("Data is Modified",addressModel1);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAddress/{token}")
    public ResponseEntity<ResponseDTO> deleteAddress(@PathVariable String token){
        ResponseDTO response = new ResponseDTO("Delete Address By Id",service.deleteAddress(token));
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

}
