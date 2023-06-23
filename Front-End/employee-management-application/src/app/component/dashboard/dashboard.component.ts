import { Component,OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl} from '@angular/forms'
import { Employee } from 'src/app/model/employee';
import { EmployeeService } from 'src/app/service/employee.service';
import { HttpErrorResponse } from '@angular/common/http'

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit{

  empDetail !: FormGroup;
  empObj : Employee = new Employee();
  empList : Employee[] = [];



  constructor(private formBuilder : FormBuilder,private empService : EmployeeService){}

  ngOnInit(): void {
    this.getAllEmployee();

    this.empDetail = this.formBuilder.group({
      employeeId:[''],
      employeeFirstName : [''],
      employeeLastName : [''],
      employeeEmailId : [''],
      createdTime:[''],
      updatedTime:['']
    });
    
  }

  addEmployee(){
    console.log(this.empDetail)
    this.empObj.employeeId = this.empDetail.value.employeeId;
    this.empObj.employeeFirstName = this.empDetail.value.employeeFirstName;
    this.empObj.employeeLastName = this.empDetail.value.employeeLastName;
    this.empObj.employeeEmailId = this.empDetail.value.employeeEmailId;

    this.empService.addEmployee(this.empObj).subscribe(res=>{
      console.log(res);
      this.getAllEmployee();
    },err=>{
      alert(err.error.message)
      console.log(err);
    })
  }

  getAllEmployee() {
    console.log(this.empService.getAllEmployee())
    this.empService.getAllEmployee().subscribe(res=>{
      this.empList = res;
    },err=>{
      console.log(err);
    });
    console.log(this.empService.getAllEmployee())
  }

  editEmployee(emp: Employee){
    this.empDetail.controls['employeeId'].setValue(emp.employeeId);
    this.empDetail.controls['employeeFirstName'].setValue(emp.employeeFirstName);
    this.empDetail.controls['employeeLastName'].setValue(emp.employeeLastName);
    this.empDetail.controls['employeeEmailId'].setValue(emp.employeeEmailId);
  }

  updateEmployee(){
    this.empObj.employeeId = this.empDetail.value.employeeId;
    this.empObj.employeeFirstName = this.empDetail.value.employeeFirstName;
    this.empObj.employeeLastName = this.empDetail.value.employeeLastName;
    this.empObj.employeeEmailId = this.empDetail.value.employeeEmailId;

    console.log(typeof(this.empObj.employeeId))

    this.empService.updateEmployee(this.empObj,this.empObj.employeeId).subscribe(res=>{
      console.log(res);
      this.getAllEmployee();
    },err=>{
      console.log(err);
    })
  }

  deleteEmployee(emp : Employee) {

    this.empService.deleteEmployee(emp.employeeId).subscribe(res=>{
      console.log(res);
      alert('Employee deleted successfully');
      this.getAllEmployee();
    },err => {
      console.log(err);
    });

  }

  
  viewEmployee(emp: Employee){
    this.empObj.employeeId = emp.employeeId;
    this.empObj.employeeFirstName = emp.employeeFirstName;
    this.empObj.employeeLastName = emp.employeeLastName;
    this.empObj.employeeEmailId = emp.employeeEmailId;
    this.empObj.createdTime = emp.createdTime;
    this.empObj.updatedTime = emp.updatedTime;

    this.empService.viewEmployee(emp.employeeId).subscribe(res=>{
      console.log(res);
      this.getAllEmployee();
    },err=>{
      console.log(err);
    })
  }

}
