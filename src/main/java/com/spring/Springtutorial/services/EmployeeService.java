package com.spring.Springtutorial.services;


import com.spring.Springtutorial.Entity.EmployeeEntity;
import com.spring.Springtutorial.dto.EmployeeDTO;
import com.spring.Springtutorial.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapperMapper;


    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapperMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapperMapper = modelMapperMapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity=employeeRepository.findById(id).orElse(null);
        return  modelMapperMapper.map(employeeEntity,EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities= employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapperMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeEntity inputEmployee) {
        // to check if user is admin
        // log something
        EmployeeEntity toSaveEntity=modelMapperMapper.map(inputEmployee,EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity=employeeRepository.save(inputEmployee);
        return modelMapperMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }
}
