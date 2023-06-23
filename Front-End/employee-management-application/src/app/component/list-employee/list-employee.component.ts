import { Component,OnInit} from '@angular/core';
import { Employee } from 'src/app/model/employee';
import { Router } from '@angular/router'
import { EmployeeService } from 'src/app/service/employee.service';

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit{

  employeeList: Employee[];

  constructor(private router:Router,private employeeService:EmployeeService){}

  ngOnInit(): void {
    this.getEmployees();
  }

  getEmployees(){
    this.employeeService.getAllEmployee().subscribe(res=>{
      this.employeeList = res;
    })
  }

  employeeDetails(empId:number){
    this.router.navigate(['employee-details',empId])
  }

  updateEmployee(empId:number){
    this.router.navigate(['update-employee',empId])
  }

  deleteEmployee(empId:number){
    this.router.navigate(['delete-employee',empId])
    this.getEmployees();
  }



}
