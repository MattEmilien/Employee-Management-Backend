
# Employee Management System Backend

Spring Boot, Spring Security, JWT, MongoDB

## Employees
| HTTP Method | URL Path                         | Description                   |
|-------------|----------------------------------|-------------------------------|
| GET         | /api/employees/                  | Fetch All Employees           |
| GET         | /api/employees/{username}        | Fetch Employee with username  |
| GET         | /api/employees/{id}              | Fetch Employee with id        |
| POST        | /api/employees/add               | Add Employee                  |
| DELETE      | /api/employees/remove/{username} | Delete Employee               |
| PUT         | /api/employees/update/{username} | Update Employee               |


## Authentication (Coming Soon)
| HTTP Method | URL Path                         | Description                   |
|-------------|----------------------------------|-------------------------------|
| POST        | /api/auth/register          | User Registration     |
| POST        | /api/v1/auth/authenticate   | User Authentication   |
