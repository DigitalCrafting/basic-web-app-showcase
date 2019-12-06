import {ChangeDetectorRef, OnDestroy, Pipe, PipeTransform} from "@angular/core";
import {isNullOrUndefined} from "util";
import {BwaTranslationsObject} from "./bwa-translations.utils";
import {BwaTranslationsService} from "./bwa-translations.service";
import {Subscription} from "rxjs";
import {BwaCompareUtils} from "../utils/bwa-utils";

@Pipe({
  name: 'translate',
  pure: false
})
export class BwaTranslationsPipe implements OnDestroy, PipeTransform {
  private paramsTemplate: RegExp = /{\s?([^{}\s]*)\s?}/g;
  private value: string = '';
  private lastKey: string;
  private lastParams: any;
  private subscribed: boolean = false;
  private onLangChange: Subscription = null;

  constructor(private _translateService: BwaTranslationsService,
              private _ref: ChangeDetectorRef) {
  }

  transform(query: any, args?: Array<string>): any {
    if (isNullOrUndefined(query) || query.length === 0) {
      return query;
    }

    if (BwaCompareUtils.equals(query, this.lastKey) && BwaCompareUtils.equals(args, this.lastParams)) {
      return this.value;
    }

    this.updateValue(query, args, this._translateService.translations);

    if (isNullOrUndefined(this.value)) {
      return query;
    }

    this.lastKey = query;
    this.lastParams = args;

    this.dispose();

    if (!this.subscribed) {
      this.onLangChange = this._translateService.languageChangedEventEmitter.subscribe((event: BwaTranslationsObject) => {
        this.updateValue(query, args, event.translations);
        this._ref.markForCheck();
      });
      this.subscribed = true;
    }

    return this.value;
  }

  ngOnDestroy(): void {
    this.dispose();
  }

  private dispose() {
    if (this.subscribed) {
      this.onLangChange.unsubscribe();
      delete this.onLangChange;
      this.subscribed = false;
    }
  }

  private updateValue(key: string, args?: Array<string>, translations?: any) {
    const message = !isNullOrUndefined(translations) && !isNullOrUndefined(translations[key]) ? translations[key] : key;
    this.value = this.interpolateTranslation(message, args);
  }

  private interpolateTranslation(value: string, args: Array<string>): string {
    if (!isNullOrUndefined(value)) {
      return value.replace(this.paramsTemplate, (substring: string, b: string) => {
        const r = args[b];
        return !isNullOrUndefined(r) ? r : substring;
      });
    }
    return value;
  }
}
