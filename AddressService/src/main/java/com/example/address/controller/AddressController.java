package com.example.address.controller;

import com.example.address.response.AddressResponse;
import com.example.address.service.AddressService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;
    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable Integer employeeId){
        AddressResponse addressByEmployeeId = addressService.findAddressByEmployeeId(employeeId);
        return new ResponseEntity<>(addressByEmployeeId, HttpStatus.OK);
    }
}
