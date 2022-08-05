package com.example.addressbookapp.dto;

import com.example.addressbookapp.model.AddressModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@NoArgsConstructor
@ToString

public class ResponseDTO {

    private String message;
    private Object data;

    public ResponseDTO(String message, AddressModel data) {
        this.message=message;
        this.data = data;

    }
    public ResponseDTO(String message, List<AddressModel> data) {
        this.message=message;
        this.data = data;

    }
    public ResponseDTO(String message, String data) {
        this.message=message;
        this.data = data;

    }

    public ResponseDTO(String message) {
        this.message = message;
    }
}
