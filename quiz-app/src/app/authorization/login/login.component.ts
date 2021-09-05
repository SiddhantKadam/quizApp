import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { HttpmethodsService } from 'src/app/services/httpmethods.service';
import { LoginClass } from '../authorizationModel';
import { postLogin } from '../authorizationURL';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  loginModel = new LoginClass();

  fieldTextType: boolean = false;
  submitted = false;

  constructor(private formBuilder: FormBuilder, private httpService: HttpmethodsService, private router: Router, public toastr: ToastrService) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      registrationMail: new FormControl('', [Validators.required]),
      registrationPassword: new FormControl('', [Validators.required]),
    });
  }

  get f() { return this.loginForm.controls; }

  onSubmit() {
    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }

    // ==== Post Login ====
    this.httpService.postRequest(postLogin, this.loginModel).subscribe((data: any) => {
      if (data.registrationId != null) {
        sessionStorage.setItem("registrationId", data.registrationId);
        this.toastr.success('Have fun!', 'Login Succesfull');
        this.router.navigateByUrl("/quiz/quiz-home");
      }
      else {
        this.toastr.error('Please check again!', 'Login Falied');

      }
    });
  }

  toggleFieldTextType() {
    this.fieldTextType = !this.fieldTextType;
  }

}
