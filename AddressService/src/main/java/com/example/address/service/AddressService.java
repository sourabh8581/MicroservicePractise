package com.example.address.service;

import com.example.address.entity.Address;
import com.example.address.repo.AddressRepository;
import com.example.address.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ModelMapper modelMapper;

    public AddressResponse findAddressByEmployeeId(Integer employeeId){
        Address addressByEmployeeId = addressRepository.findAddressByEmployeeId(employeeId);
        AddressResponse addressResponse = modelMapper.map(addressByEmployeeId, AddressResponse.class);
        return addressResponse;
    }

}
