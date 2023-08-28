package me.employee.management.api.utils;
import me.employee.management.api.employee.Employee;
import me.employee.management.api.employee.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration

public class LoadDatabase {

    @Bean
        CommandLineRunner initDatabase(EmployeeService employeeService) {

            return args -> {
                employeeService.addEmployee(new Employee("Bilbo Baggins", "burglar", "default", 1, false));
                employeeService.addEmployee(new Employee("Frodo Baggins", "thief", "admin", 2, true));
            };
        }
    }


