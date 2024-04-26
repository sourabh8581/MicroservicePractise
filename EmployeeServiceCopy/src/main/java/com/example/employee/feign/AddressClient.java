package com.example.employee.feign;

import com.example.employee.Response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "abc",url = "http://localhost:8082")
public interface AddressClient {
//    http://localhost:8082/address/1

    @GetMapping("/address/{id}")
    AddressResponse getAddressByEmployeeId(@PathVariable("id") Integer id);
//    Spring will create an internal implementation for this method and this method will act as a
//    proxy
}
