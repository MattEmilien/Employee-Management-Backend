package me.employee.management.api.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Document (collection = "employees")
public class Employee {
    private String username;
    private String password;
    private String role;
    @Id private long id;
    private boolean admin;

}
