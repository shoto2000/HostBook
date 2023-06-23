import { Component,OnInit } from '@angular/core';
import { Employee } from 'src/app/model/employee';
import { Router,ActivatedRoute} from '@angular/router'
import { EmployeeService } from 'src/app/service/employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit{

  empId:number;
  updatedEmployee: Employee = new Employee();

  constructor(private router:Router,private employeeService:EmployeeService,private route:ActivatedRoute){}

  ngOnInit(): void {
    this.empId = this.route.snapshot.params['empId']
    this.employeeService.viewEmployee(this.empId).subscribe(res=>{
      this.updatedEmployee = res;
    },err=>{
      console.log(err.error.message);
    })
  }

  onSubmit(){
    this.employeeService.updateEmployee(this.updatedEmployee,this.empId).subscribe(res=>{
      this.goToEmployeeList();
    })
  }


  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }
}
