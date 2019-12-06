import {NgModule} from "@angular/core";
import {HttpClientModule} from "@angular/common/http";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {BwaI18nTranslationsModule} from "./i18n-translations/bwa-i18n-translations.module";
import {BwaDynamicComponentsModule} from "./dynamic-components/bwa-dynamic-components.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    HttpClientModule,
    BwaI18nTranslationsModule,
    BwaDynamicComponentsModule
  ],
  exports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    HttpClientModule,
    BwaI18nTranslationsModule,
    BwaDynamicComponentsModule
  ]
})
export class BwaCoreModule {}
