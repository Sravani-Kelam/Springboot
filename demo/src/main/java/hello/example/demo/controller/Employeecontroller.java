package hello.example.demo.controller;

import hello.example.demo.dto.EmployeeDto;
import hello.example.demo.entity.Employee;
import hello.example.demo.service.ImplService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor

public class Employeecontroller {
    @Autowired
    private ImplService Service;

    @PostMapping("/saveEmployee")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto saveEmployee=Service.saveEmployee( employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable long id){
        EmployeeDto employee=Service.getByid(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<EmployeeDto> updateEmployee(@PathVariable long id,@RequestBody EmployeeDto employeeDto){
        EmployeeDto updateEmployee=Service.updateEmployee(id,employeeDto);
        return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable long id){
        Employee employee=Service.deleteEmployee(id);
        return  new ResponseEntity<>(employee,HttpStatus.OK);
    }
}
