import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-bwa-add-note',
  templateUrl: './bwa-add-note.component.html',
  styleUrls: ['./bwa-add-note.component.scss']
})
export class BwaAddNoteComponent {
  @Output("addClicked") addCLickedEventEmitter: EventEmitter<string> = new EventEmitter<string>();

  formGroup: FormGroup = new FormGroup({
    noteText: new FormControl('', Validators.required)
  });

  onAddClicked() {
    if (this.formGroup.valid) {
      this.addCLickedEventEmitter.emit(this.formGroup.get('noteText').value);
    }
  }

  clear() {
    this.formGroup.reset();
  }
}
