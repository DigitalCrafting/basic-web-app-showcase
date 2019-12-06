import {EventEmitter, Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BwaTranslationsObject} from "./bwa-translations.utils";

@Injectable()
export class BwaTranslationsService {
  public translations: BwaTranslationsObject;
  public languageChangedEventEmitter: EventEmitter<BwaTranslationsObject> = new EventEmitter<BwaTranslationsObject>();

  private loadingTranslations: Observable<any>;
  private pending: boolean = false;

  constructor(private _httpClient: HttpClient,
              private _translationsUrl: string) {
  }

  public getTranslations(): Observable<BwaTranslationsObject> {
    this.pending = true;
    this.loadingTranslations = this.dispatchGetTranslations();
    this.loadingTranslations.subscribe((res: BwaTranslationsObject) => {
      if (res !== null && res !== undefined) {
        this.translations = res;
      }
      this.onLangChanged();
      this.pending = false;
    }, (err: any) => {
      this.pending = false;
    });
    return this.loadingTranslations;
  }

  private dispatchGetTranslations(): Observable<any> {
    return this._httpClient.get(
      `${this._translationsUrl}`,
      {
        withCredentials: true
      }
    );
  }

  private onLangChanged(): void {
    this.languageChangedEventEmitter.emit(this.translations);
  }
}
