import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms'
import { HttpClientModule } from "@angular/common/http"

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { ListEmployeeComponent } from './component/list-employee/list-employee.component';
import { EmployeeDetailsComponent } from './component/employee-details/employee-details.component';
import { UpdateEmployeeComponent } from './component/update-employee/update-employee.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    ListEmployeeComponent,
    EmployeeDetailsComponent,
    UpdateEmployeeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
