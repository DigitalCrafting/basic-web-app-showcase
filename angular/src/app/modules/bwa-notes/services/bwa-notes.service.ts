import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class BwaNotesService {

  private baseUrl = "http://localhost:8080/notes/";
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private _httpClient: HttpClient) {
  }

  public getNotes() {
    return this._httpClient.get(this.baseUrl, this.httpOptions).pipe();
  }

  public createNote(noteText: string) {
    return this._httpClient.put(this.baseUrl, noteText, this.httpOptions).toPromise();
  }

  public deleteNote(noteId: number) {
    return this._httpClient.delete(this.baseUrl + noteId, this.httpOptions).toPromise();
  }
}
