package com.example.employee.config;

import com.example.employee.Response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AddressService",url = "http://localhost:8082")
public interface AddressClient {
//    http://localhost:8082/address/1
//      Copy the method signature from address controller
    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable Integer employeeId);
        //    Spring will create an internal implementation for this method and this method will act as a
//    proxy
//      It is declarative in nature , we just need to declare the method and implementation will be
//    provided by spring internally
}
