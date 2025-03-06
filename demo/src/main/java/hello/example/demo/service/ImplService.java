package hello.example.demo.service;

import hello.example.demo.dto.EmployeeDto;
import hello.example.demo.entity.Employee;
import hello.example.demo.repository.Empolyeerepository;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ImplService implements Service{
    @Autowired
    private Empolyeerepository employeerepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto){
        Employee employee=new Employee(
                employeeDto.getId(),
                employeeDto.getName(),
                employeeDto.getSalary()
        );
        Employee saveemployee= employeerepository.save(employee);
        EmployeeDto saveemployeeDto=new EmployeeDto(
              saveemployee.getId(),
                saveemployee.getName(),
                saveemployee.getSalary()
        );
        return saveemployeeDto;
    }
    @Override
    public EmployeeDto getByid(long id) {
        Employee employee = employeerepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not found: " + id));

        return new EmployeeDto(employee.getId(), employee.getName(), employee.getSalary());
    }
    public EmployeeDto updateEmployee(long id, EmployeeDto employeeDto){
        Employee existingEmployee=employeerepository.findById(id)
                .orElseThrow(()->new RuntimeException("Employee not found with id:"+id));

        existingEmployee.setName(employeeDto.getName());
        existingEmployee.setSalary(employeeDto.getSalary());

        Employee updateEmployee= employeerepository.save(existingEmployee);

        return new EmployeeDto(
                updateEmployee.getId(),
                updateEmployee.getName(),
                updateEmployee.getSalary()
        );
    }
  public  Employee deleteEmployee(long id){
        Employee existingEmployee=employeerepository.findById(id)
                .orElseThrow(()->new RuntimeException("Employee not found with id:"+id));
        employeerepository.deleteById(id);
        return existingEmployee;
  }
}
