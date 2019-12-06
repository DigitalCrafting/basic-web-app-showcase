import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class BwaLoginVerifyService {
  private baseUrl = "http://localhost:8080/auth/";
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private _httpClient: HttpClient) {
  }

  public isUserLoggedIn() {
    return this._httpClient.get(this.baseUrl, this.httpOptions).pipe();
  }
}
