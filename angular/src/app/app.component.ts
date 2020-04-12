import {Component, OnInit, ViewChild} from '@angular/core';
import {BwaDynamicComponentManager} from "./core/dynamic-components/bwa-dynamic-component-manager";
import {BwaLoginComponent} from "./modules/bwa-login/components/bwa-login.component";
import {BwaEnums} from "./utils/bwa-enums";
import {BwaNotesComponent} from "./modules/bwa-notes/components/bwa-notes.component";
import {BwaSignUpComponent} from "./modules/bwa-sign-up/components/bwa-sign-up.component";
import {Subscription} from "rxjs";
import {ObjectsUtils} from "./core/utils/bwa-utils";
import LoginStatusEnum = BwaEnums.LoginStatusEnum;
import SignUpStatusEnum = BwaEnums.SignUpStatusEnum;
import {BwaLoginVerifyService} from "./utils/bwa-login-verify.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  @ViewChild("dynamicComponentManager") dynamicComponentManager: BwaDynamicComponentManager;

  private loginFinishedSubscriber: Subscription;
  private signUpFinishedSubscriber: Subscription;

  constructor(private _loginVerifyService: BwaLoginVerifyService) {
  }

  ngOnInit() {
    setTimeout(() => {
      this._loginVerifyService.isUserLoggedIn().subscribe((response: LoginStatusEnum) => {
        if (response === LoginStatusEnum.LOGGED_IN) {
          this.showNotesComponent();
        } else {
          this.showLoginComponent();
        }
      });
    });
  }

  private showLoginComponent() {
    this.cleanUp();
    const loginComponent: BwaLoginComponent = this.dynamicComponentManager.show(BwaLoginComponent);
    loginComponent.loginFinishedEventEmitter.subscribe((status) => {
      if (status === LoginStatusEnum.LOGGED_IN) {
        this.showNotesComponent();
      } else if (status === LoginStatusEnum.NOT_EXISTS) {
        this.showSignUpComponent();
      } else {
        throw new Error("Should not have happened");
      }
    });
  }

  private showNotesComponent() {
    this.cleanUp();
    const notesComponent: BwaNotesComponent = this.dynamicComponentManager.show(BwaNotesComponent);
  }

  private showSignUpComponent() {
    this.cleanUp();
    const signUpDesktop: BwaSignUpComponent = this.dynamicComponentManager.show(BwaSignUpComponent);
    this.signUpFinishedSubscriber = signUpDesktop.signUpFinishedEventEmitter.subscribe((status) => {
      if (status === SignUpStatusEnum.CREATED) {
        this.showLoginComponent();
      } else {
        throw new Error("Should not have happened");
      }
    });
  }

  private cleanUp() {
    if (!ObjectsUtils.isNullOrUndefined(this.loginFinishedSubscriber)) {
      this.loginFinishedSubscriber.unsubscribe();
      delete this.loginFinishedSubscriber;
    }
    if (!ObjectsUtils.isNullOrUndefined(this.signUpFinishedSubscriber)) {
      this.signUpFinishedSubscriber.unsubscribe();
      delete this.signUpFinishedSubscriber;
    }
  }
}
