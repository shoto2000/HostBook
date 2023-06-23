import { Injectable } from '@angular/core';
import { HttpClient,HttpClientModule } from '@angular/common/http'
import { Employee } from '../model/employee';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = "http://localhost:8080/employee";

  constructor(private http:HttpClient){}

  addEmployee(emp:Employee): Observable<Employee>{
    const addEmpUrl = `${this.baseUrl}/add`
    return this.http.post<Employee>(addEmpUrl,emp);
  }

  getAllEmployee():Observable<Employee[]>{
    const getAllEmpUrl = `${this.baseUrl}/`
    return this.http.get<Employee[]>(getAllEmpUrl);
  }

  updateEmployee(emp:Employee,empId:number):Observable<Employee>{
    const updateEmpUrl = `${this.baseUrl}/edit?id=${empId}`
    return this.http.post<Employee>(updateEmpUrl,emp);
  }

  deleteEmployee(empId:number) : Observable<any> {
    const deleteEmpUrl = `${this.baseUrl}/delete?id=${empId}`
    return this.http.delete<any>(deleteEmpUrl);
  }

  viewEmployee(empId:number) : Observable<Employee>{
    const viewEmployee = `${this.baseUrl}/${empId}`
    return this.http.get<Employee>(viewEmployee);
  }
}
