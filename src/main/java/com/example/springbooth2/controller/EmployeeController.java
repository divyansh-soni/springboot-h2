package com.example.springbooth2.controller;

import com.example.springbooth2.entity.Employee;
import com.example.springbooth2.repository.EmployeeRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * com.example.springbooth2.controlle
 *
 * @author divyanshsoni on 14/01/25
 */

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/saveEmployee")
    public ResponseEntity<String> addEmployee(@RequestBody @NonNull final Employee employee) {
        employeeRepository.save(employee);
        return new ResponseEntity<>("DONE", HttpStatus.OK);
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/getAllByDept/{dept}")
    public ResponseEntity<List<Employee>> getAllEmployeesFromDept(@PathVariable String dept) {
        List<Employee> employeeList = employeeRepository.findAllByDept(dept);
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }
}
