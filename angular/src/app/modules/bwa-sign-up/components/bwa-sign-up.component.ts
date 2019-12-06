import {Component, EventEmitter} from '@angular/core';
import {BwaEnums} from "../../../utils/bwa-enums";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {BwaSignUpService} from "../services/bwa-sign-up.service";
import {BwaSignUpValidators} from "../utils/bwa-sing-up.validators";
import SignUpStatusEnum = BwaEnums.SignUpStatusEnum;

@Component({
  selector: 'app-bwa-sign-up',
  templateUrl: './bwa-sign-up.component.html',
  styleUrls: ['./bwa-sign-up.component.scss']
})
export class BwaSignUpComponent {

  signUpFinishedEventEmitter: EventEmitter<SignUpStatusEnum> = new EventEmitter();

  formGroup: FormGroup = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    passwordCheck: new FormControl('', Validators.required),
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required)
  }, BwaSignUpValidators.ValidatePassword);

  constructor(private _bwaSignUpService: BwaSignUpService) { }

  onCancelClicked() {
    this.signUpFinishedEventEmitter.emit(SignUpStatusEnum.CANCELLED);
  }

  onSignUpClicked() {
    if (this.formGroup.valid) {
      this._bwaSignUpService.signUp(this.formGroup.getRawValue()).subscribe((response: SignUpStatusEnum) => {
        this.signUpFinishedEventEmitter.emit(response);
      });
    }
  }
}
