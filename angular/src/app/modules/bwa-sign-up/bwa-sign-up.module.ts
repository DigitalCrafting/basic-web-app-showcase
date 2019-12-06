import {NgModule} from '@angular/core';
import {BwaSignUpComponent} from './components/bwa-sign-up.component';
import {BwaCoreModule} from "../../core/bwa-core.module";


@NgModule({
  imports: [
    BwaCoreModule
  ],
  exports: [
    BwaSignUpComponent
  ],
  declarations: [
    BwaSignUpComponent
  ],
  entryComponents: [
    BwaSignUpComponent
  ]
})
export class BwaSignUpModule { }
