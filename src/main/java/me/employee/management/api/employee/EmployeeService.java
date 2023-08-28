package me.employee.management.api.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    private void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    private void updateEmployee(Employee employee, Employee updatedEmployee) {
        employeeRepository.delete(employee);
        employeeRepository.save(updatedEmployee);
    }

    public Optional<Employee> findByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }

    public Optional<Employee> findByID(long id) {
        return employeeRepository.findById(id);
    }

}
