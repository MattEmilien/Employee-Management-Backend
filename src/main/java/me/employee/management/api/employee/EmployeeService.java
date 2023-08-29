package me.employee.management.api.employee;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);

    }

    public String deleteEmployee(String employeeUsername) {
        Optional<Employee> employee = employeeRepository.findByUsername(employeeUsername);
        return employee.map(e -> { employeeRepository.delete(e); return "Employee deleted successfully."; }).orElse("Employee not found.");
    }

    public String updateEmployee(String employeeUsername, Employee updatedEmployee) {
        Optional<Employee> employee = employeeRepository.findByUsername(employeeUsername);
        if (employee.isPresent()) {
            deleteEmployee(employeeUsername);
            employeeRepository.save(updatedEmployee);
            return "Updated Employee by the name of " + employeeUsername;
        }
       return "Unable to find employee by the name of " + employeeUsername;
    }

    public Optional<Employee> findByUsername(String username) { return employeeRepository.findByUsername(username); }
    public Optional<Employee> findByID(long id) { return employeeRepository.findById(id); }

}
