import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {BwaSignUpRequest} from "./bwa-sign-up.request";

@Injectable({
  providedIn: 'root'
})
export class BwaSignUpService {

  private baseUrl = "http://localhost:8080/auth/";
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private _httpClient: HttpClient) { }

  public signUp(request: BwaSignUpRequest): Observable<any> {
    return this._httpClient.put(this.baseUrl, request, this.httpOptions).pipe();
  }
}
