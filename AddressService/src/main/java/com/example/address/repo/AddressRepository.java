package com.example.address.repo;

import com.example.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query(value = "SELECT ea.id, ea.lane1, ea.lane2, ea.state, ea.zip FROM selenium.address ea\n" +
            "join\n" +
            "selenium.employee e\n" +
            "on e.id=ea.employee_id\n" +
            "where ea.employee_id=:employeeId",nativeQuery = true)
    Address findAddressByEmployeeId(@Param("employeeId") Integer employeeId);
}
