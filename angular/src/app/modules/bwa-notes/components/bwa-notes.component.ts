import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {BwaNoteModel} from "../models/bwa-note.model";
import {BwaNotesService} from "../services/bwa-notes.service";
import {BwaAddNoteComponent} from "./bwa-add-note/bwa-add-note.component";

@Component({
  selector: 'app-bwa-notes',
  templateUrl: './bwa-notes.component.html',
  styleUrls: ['./bwa-notes.component.scss']
})
export class BwaNotesComponent implements AfterViewInit {
  @ViewChild('addNoteComponent', {static: false}) addNoteComponent: BwaAddNoteComponent;

  notesList: Array<BwaNoteModel> = [];

  constructor(private _notesService: BwaNotesService) {
  }

  ngAfterViewInit() {
    setTimeout(() => {
      this.getNotes();
    });
  }

  private getNotes() {
    this._notesService.getNotes().subscribe((response: Array<BwaNoteModel>) => {
      this.notesList = response;
    });
  }

  onDeleteClicked(noteId: number) {
    this._notesService.deleteNote(noteId).then(() => {
      this.getNotes();
    });
  }

  onAddCLicked(noteText: string) {
    this._notesService.createNote(noteText).then(() => {
      this.addNoteComponent.clear();
      this.getNotes();
    });
  }
}
