import {Component, EventEmitter, Input, Output} from '@angular/core';
import {BwaNoteModel} from "../../models/bwa-note.model";

@Component({
  selector: 'app-bwa-single-note',
  templateUrl: './bwa-single-note.component.html',
  styleUrls: ['./bwa-single-note.component.scss']
})
export class BwaSingleNoteComponent {

  @Input() note: BwaNoteModel;
  @Output("deleteClicked") deleteClickedEventEmitter: EventEmitter<number> = new EventEmitter<number>();

  onDeleteClicked(noteId: number) {
    this.deleteClickedEventEmitter.emit(noteId);
  }
}
