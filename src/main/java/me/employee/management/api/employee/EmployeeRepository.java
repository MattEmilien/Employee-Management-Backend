package me.employee.management.api.employee;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    Optional<Employee> findByUsername(String username);
    Optional<Employee> findById(long id);

}
