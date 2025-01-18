package com.spring.Springtutorial.controllers;


import com.spring.Springtutorial.Entity.EmployeeEntity;
import com.spring.Springtutorial.dto.EmployeeDTO;
import com.spring.Springtutorial.repositories.EmployeeRepository;
import com.spring.Springtutorial.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name ="employeeId" ) Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                                @RequestParam(required = false) String sortBy) {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeEntity inputEmployee) {
        return employeeService.createNewEmployee(inputEmployee);
    }

}
