package me.employee.management.api.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() { return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK); }

    @GetMapping("/{username}")
    public ResponseEntity<Employee> getEmployeeByUsername(@PathVariable String username) {
        Optional<Employee> employee = employeeService.findByUsername(username);
        return employee.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable long id) {
        Optional<Employee> employee = employeeService.findByID(id);
        return employee.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    public Employee createEmployee(@RequestBody Employee employee) { return employeeService.addEmployee(employee); }

    @DeleteMapping("/remove/{username}")
    public String removeEmployee(@PathVariable String username) { return  employeeService.deleteEmployee(username); }

    @PutMapping("/update/{username}")
    public String updateEmployee(@PathVariable String username, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(username, updatedEmployee);
    }

}


