import {NgModule} from '@angular/core';
import {BwaCoreModule} from "../../core/bwa-core.module";
import {BwaNotesComponent} from './components/bwa-notes.component';
import { BwaSingleNoteComponent } from './components/bwa-single-note/bwa-single-note.component';
import { BwaAddNoteComponent } from './components/bwa-add-note/bwa-add-note.component';


@NgModule({
  imports: [
    BwaCoreModule
  ],
  exports: [
    BwaNotesComponent
  ],
  declarations: [
    BwaNotesComponent,
    BwaSingleNoteComponent,
    BwaAddNoteComponent
  ],
  entryComponents: [
    BwaNotesComponent
  ]
})
export class BwaNotesModule { }
