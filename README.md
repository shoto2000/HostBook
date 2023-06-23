<h1 align="center">HostBook-Assignment</h1>
 
## Description
A Mini Full-stack Employee Mangement Platform with basic Crud Operation build using Springboot and Angular.

## Teckstack
1. Java
2. MySql
3. SpringBoot
4. Hibernate
5. JavaScript
6. TypeScript
7. Angular
8. BootStrap CSS

## Prerequisites
Before running the application, make sure you have the following prerequisites installed on your machine:
1. Back-End
   - Java Development Kit (JDK) 1.8 or higher
   - MySql
   - Any compatible Java IDE or text editor (e.g., IntelliJ, Eclipse, VS Code)
     
2. Front-End
   - Angular(Latest Version)
   - BootStrap CSS
   - Node and NPM
   - Any compatible Java IDE or text editor (e.g. VS Code)
     
## Installation and Setup
1. Clone the repository:
   ```
   https://github.com/shoto2000/HostBook.git
   ```
2. Navigate to the project directory:
   - Back-End
   ```
   cd Back-End/EmployeeManagementPlatform
   ```
   use any IDE to run the program
   
   - Front-End (enter these commands in powershell or VS code terminal)
   ```
   cd Front-End/employee-management-application

   npm i

   ng serve
   ```
   
4. Compile the code and run it.
   

## API Endpoints

- Add Employee
   ```
   http://localhost:8080/employee/add

   Request Body:-
   {
      "employeeFirstName": "firstname",
      "employeeLastName": "secondname",
      "employeeEmailId": "email"
   }
   ```
- List All Employee
   ```
   http://localhost:8080/employee/
   ```
- Edit Employee Details
   ```
   http://localhost:8080/employee/edit?id=empId

   Request Body:-
   {
      "employeeFirstName": "firstname",
      "employeeLastName": "secondname",
      "employeeEmailId": "email"
   }
   ```
- Delete Employee
   ```
   http://localhost:8080/employee/delete?id=empId
   ```
- View Employee
   ```
   http://localhost:8080/employee/{empId}
   ```

Here is the video tutorial to setup and run the Application [Tutorial](https://drive.google.com/file/d/1UBrcrdhfcFPKg4s8xHpUNRzE711f1q_v/view?usp=sharing)

<h1 align="center"> Thank You</h1>
