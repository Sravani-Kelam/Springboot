package hello.example.demo.repository;

import hello.example.demo.dto.EmployeeDto;
import hello.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Empolyeerepository extends JpaRepository<Employee, Long> {
   Optional<EmployeeDto> findByid(long id);
}
