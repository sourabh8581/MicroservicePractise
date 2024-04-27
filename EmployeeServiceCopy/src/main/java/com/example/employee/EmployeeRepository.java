package com.example.employee;

import com.example.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
    public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
