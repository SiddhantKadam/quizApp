import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { HttpmethodsService } from 'src/app/services/httpmethods.service';
import { RegistrationClass } from '../authorizationModel';
import { postRegister } from '../authorizationURL';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  registrationForm: FormGroup;
  registrationModel = new RegistrationClass();

  fieldTextType: boolean = false;
  errormsg!: string;

  submitted = false;
  confirmPassword: String;

  constructor(private formBuilder: FormBuilder, private router: Router, private httpService: HttpmethodsService, public toastr: ToastrService) { }

  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group({
      registrationMail: new FormControl('', [Validators.required, Validators.email]),
      registrationName: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z ]*')]),
      registrationPassword: new FormControl('', [Validators.required, Validators.minLength(8),Validators.maxLength(15)]),
    });
  }

  get f() { return this.registrationForm.controls; }

  onSubmit() {
    this.submitted = true;
    if (this.registrationForm.invalid) {
        return;
    }

    // ==== Post Register ====
        this.httpService.postRequest(postRegister, this.registrationModel).subscribe((data: any) => {
        sessionStorage.setItem("registrationId", data.registrationId);
        this.toastr.success('Have fun!', 'Register Succesfull');
        this.router.navigateByUrl("/quiz/quiz-home"); 
      },
      error => {
        this.toastr.error('Please check again!','Registration Falied');  
      });
  }

  toggleFieldTextType() {
    this.fieldTextType = !this.fieldTextType;
  }

}
