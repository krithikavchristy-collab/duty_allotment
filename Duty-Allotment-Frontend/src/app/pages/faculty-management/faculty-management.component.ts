import { Component } from '@angular/core';

@Component({
  selector: 'app-faculty-management',
  templateUrl: './faculty-management.component.html',
  styleUrls: ['./faculty-management.component.css']
})
export class FacultyManagementComponent {

  facultyList = [
    {
      empId: 'EMP 011',
      name: 'Dr.John',
      department: 'Computer Science',
      designation: 'Professor',
      status: 'Pending'
    }
  ];

}