import {NgModule} from '@angular/core';
import {BwaCoreModule} from "../../core/bwa-core.module";
import {BwaLoginComponent} from './components/bwa-login.component';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";


@NgModule({
  imports: [
    BwaCoreModule,
    NgbModule
  ],
  exports: [
    BwaLoginComponent
  ],
  declarations: [
    BwaLoginComponent
  ],
  entryComponents: [
    BwaLoginComponent
  ]
})
export class BwaLoginModule {
}
