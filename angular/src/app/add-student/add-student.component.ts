import { Component, OnInit } from '@angular/core';
import { StudentService } from '../services/student.service';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {

  student = {
    name: '',
    standard: '',
    published: false,
    age:''
  };
  submitted = false;

  constructor(private studentlService: StudentService) { }

  ngOnInit(): void {
  }

  saveStudent(){
    const data = {
      name: this.student.name,
      standard: this.student.standard,
      published: this.student.published,
      age:this.student.age
    };

    this.studentlService.create(data)
    .subscribe(
      response => {
        console.log(response);
        this.submitted = true;
      },
      error => {
        console.log(error);
      });
  }
  
  newStudent() {
    this.submitted = false;
    this.student = {
      name: '',
      standard: '',
      published: false,
      age:''
    };
  }
}
