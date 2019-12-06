import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BwaCoreModule} from "./core/bwa-core.module";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {BwaLoginModule} from "./modules/bwa-login/bwa-login.module";
import {BwaSignUpModule} from "./modules/bwa-sign-up/bwa-sign-up.module";
import {BwaNotesModule} from "./modules/bwa-notes/bwa-notes.module";
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {BwaAuthInterceptor} from "./utils/bwa-auth-interceptor";

@NgModule({
  imports: [
    BwaCoreModule,
    AppRoutingModule,
    NgbModule,
    BwaLoginModule,
    BwaSignUpModule,
    BwaNotesModule
  ],
  declarations: [
    AppComponent
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: BwaAuthInterceptor,
      multi: true,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
