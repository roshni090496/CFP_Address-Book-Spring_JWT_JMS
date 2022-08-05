package com.example.addressbookapp.repository;

import com.example.addressbookapp.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AddressRepository extends JpaRepository<AddressModel,Integer> {

}
