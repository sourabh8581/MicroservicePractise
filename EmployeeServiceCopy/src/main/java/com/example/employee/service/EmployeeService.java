package com.example.employee.service;

import com.example.employee.EmployeeRepository;
import com.example.employee.Response.AddressResponse;
import com.example.employee.Response.EmployeeResponse;
import com.example.employee.config.AddressClient;
import com.example.employee.entity.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AddressClient addressClient;

    public EmployeeResponse getEmployeeById(Integer id){
        Employee employee = employeeRepository.findById(id).get();// db call-> Rsponse time 10s
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        ResponseEntity<AddressResponse> addressByEmployeeId = addressClient.getAddressByEmployeeId(id);
        AddressResponse addressResponse = addressByEmployeeId.getBody();
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }
}
