package hello.example.demo.service;

import hello.example.demo.dto.EmployeeDto;

public interface Service {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getByid(long id);
    EmployeeDto updateEmployee(long id , EmployeeDto employeeDto);
}
