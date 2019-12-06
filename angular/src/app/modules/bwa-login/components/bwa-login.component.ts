import {Component, EventEmitter} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {BwaEnums} from "../../../utils/bwa-enums";
import {BwaLoginService} from "../services/bwa-login.service";
import LoginStatusEnum = BwaEnums.LoginStatusEnum;

@Component({
  selector: 'app-bwa-login',
  templateUrl: './bwa-login.component.html',
  styleUrls: ['./bwa-login.component.scss']
})
export class BwaLoginComponent {

  loginFinishedEventEmitter: EventEmitter<LoginStatusEnum> = new EventEmitter();

  formGroup: FormGroup = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });

  constructor(private _loginService: BwaLoginService) {
  }

  onLoginClicked() {
    if (this.formGroup.valid) {
      this._loginService.login(this.formGroup.value).subscribe((resp: LoginStatusEnum) => {
        this.loginFinishedEventEmitter.emit(resp);
      });
    }
  }

  onSignUpClicked() {
    this.loginFinishedEventEmitter.emit(LoginStatusEnum.NOT_EXISTS);
  }
}
