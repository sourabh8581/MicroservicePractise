package com.example.employee.service;

import com.example.employee.EmployeeRepository;
import com.example.employee.Response.AddressResponse;
import com.example.employee.Response.EmployeeResponse;
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
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private WebClient webClient;
//    @Autowired
//    private RestTemplate restTemplate;

//    @Value("${addressservice.base.url}")
//    private String baseUrl;    //It gives IllegalArgumentException:URI is not absolute
//    bcz at the time of loading the EmployeeService base Url is not loaded yet so to avoid this
//    give it as a parameter in the constructor

//

//    @Autowired
//    public EmployeeService(EmployeeRepository employeeRepository,
//                           RestTemplateBuilder restTemplateBuilder,
//                           @Value("${addressservice.base.url}") String baseUrl) {
//        this.employeeRepository = employeeRepository;
//        this.restTemplate=restTemplateBuilder
//                .rootUri(baseUrl).build();
//    }

//    public EmployeeResponse getEmployeeById(Integer id){
//        Employee employee = employeeRepository.findById(id).get();// db call-> Rsponse time 10s
//        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
//        AddressResponse addressResponse = restTemplate.getForObject("/address/{id}", AddressResponse.class, id);
////        External rst api call 10s
////        RestTemplate is Synchronous ...it will take 20 s for the response
////        It is blocking in nature
//        employeeResponse.setAddressResponse(addressResponse);
//        return employeeResponse;
//    }
    public EmployeeResponse getEmployeeById(Integer id){
        Employee employee = employeeRepository.findById(id).get();// db call-> Rsponse time 10s
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        AddressResponse addressResponse = webClient.get()
                .uri("/address/" + id)
                .retrieve()
                .bodyToMono(AddressResponse.class)
                .block();

        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }
}
