import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {BwaLoginRequest} from "./bwa-login.request";

@Injectable({
  providedIn: 'root'
})
export class BwaLoginService {

  private baseUrl = "http://localhost:8080/auth/";
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private _httpClient: HttpClient) { }

  public login(request: BwaLoginRequest): Observable<any> {
    return this._httpClient.post(this.baseUrl, request, this.httpOptions).pipe();
  }
}
