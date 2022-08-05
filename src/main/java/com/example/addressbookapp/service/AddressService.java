package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressDTO;
import com.example.addressbookapp.exception.AddressException;
import com.example.addressbookapp.model.AddressModel;
import com.example.addressbookapp.repository.AddressRepository;
import com.example.addressbookapp.util.EmailSenderService;
import com.example.addressbookapp.util.TokenUtil;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
   private AddressRepository addressRepository;

    @Autowired
    TokenUtil tokenutil;

    @Autowired
    EmailSenderService senderService;

   public String AddressMessage(){
        return "Hello World!";
   }

    public AddressModel saveAddress(AddressDTO address) {
        AddressModel addressModel=new AddressModel(address);
        addressRepository.save(addressModel);
        String token=tokenutil.createToken(addressModel.getId());
        Optional<AddressModel> address1 = addressRepository.findById(addressModel.getId());
        address1.get().setToken(token);
        return addressRepository.save(address1.get());

   }

    public AddressModel getRecord(String token)
    {
        int id = tokenutil.decodeToken(token);
        Optional<AddressModel> address = addressRepository.findById(id);
        return address.get();
    }


    public AddressModel findaddressById(Integer id) {
    Optional<AddressModel> addmodelold=addressRepository.findById(id);
        if (addmodelold.isPresent()) {
            return addmodelold.get();
        }
        else {

            throw new AddressException("error user not found");
        }
    }

    public AddressModel addRecord(AddressDTO address)
    {
        AddressModel entity = new AddressModel(address);
        addressRepository.save(entity);
        String token=tokenutil.createToken(entity.getId());
        entity.setToken(token);
        addressRepository.save(entity);
        senderService.sendEmail(entity.getEmail(),"Registered SuccessFully","message done");
        return entity;
    }

    //   public String addRecord(AddressDTO address) throws Exception
//    {
//        int id = tokenutil.decodeToken();
//        AddressModel entity = new AddressModel(address);
//        addressRepository.save(entity);
//        String token=tokenutil.createToken(entity.getId());
//        return token;
//    }

    public AddressModel getAddressPayRollData( String token)
    {
        int id = tokenutil.decodeToken(token);
     Optional<AddressModel> model= addressRepository.findById(id);
        return model.get();
    }

    public List<AddressModel> findAddress() {

       return addressRepository.findAll();
    }

    public AddressModel editAddress(AddressDTO addressNew, Integer id) {
        AddressModel addmodelold = addressRepository.findById(id).orElse(null);
        AddressModel newAddress = new AddressModel(addressNew,id);
        return addressRepository.save(newAddress);
    }

//    public String deleteAddress(Integer id) {
//        addressRepository.deleteById(id);
//        return "data deleted";
//    }

    public String deleteAddress(String token)
    {
        int id = tokenutil.decodeToken(token);
        AddressModel entity = getAddressPayRollData(token);
        if(entity!=null){
        addressRepository.deleteById(id);
        senderService.sendEmail(entity.getEmail(),"Deleted SuccessFully","Data Deleted");
       return "Data Deleted";
        }
        else{
            return "Wrong Token";
        }
    }
}

