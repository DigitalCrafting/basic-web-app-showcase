import {Component, ComponentFactoryResolver, ComponentRef, OnDestroy, ViewChild, ViewContainerRef} from "@angular/core";
import {ObjectsUtils} from "../utils/bwa-utils";

@Component({
  selector: 'bwa-dynamic-component-manager',
  template: `<ng-template #container></ng-template>`
})
// tslint:disable-next-line:component-class-suffix
export class BwaDynamicComponentManager implements OnDestroy {
  @ViewChild('container', { read: ViewContainerRef }) container;

  private _cmpRef: ComponentRef<any>;

  constructor(private resolver: ComponentFactoryResolver) {

  }

  public show(componentType: any): any {
    if (!ObjectsUtils.isNullOrUndefined(this._cmpRef)) {
      this._cmpRef.destroy();
    }

    const fact = this.resolver.resolveComponentFactory(componentType);
    this._cmpRef = this.container.createComponent(fact);

    return this._cmpRef.instance;
  }

  ngOnDestroy() {
    if (!ObjectsUtils.isNullOrUndefined(this._cmpRef)) {
      this._cmpRef.destroy();
    }
  }
}
