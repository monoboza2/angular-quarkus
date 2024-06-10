import {inject, Injectable} from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import {CreateModalComponent} from "./create-modal.component";
import {from, Observable} from "rxjs";
import {CareerDto} from "../../../../../generated-model/model";
export type CRUD = 'CREATE' | 'READ' | 'UPDATE' | 'DELETE';

@Injectable({
  providedIn: 'root'
})
export class CreateModalService {
  modalService = inject(NgbModal)

  open(options?: { disabled?: boolean, crudMode?: CRUD,title?:string,confirmDialog?:boolean ,career?:CareerDto}): Observable<any> {

    const modalRef = this.modalService.open(CreateModalComponent, {
      // fullscreen: true,
      size: "xl",
      windowClass: 'custom-modal-content',
      backdrop: 'static',
      keyboard: false
    });
    if (options?.title) {
      modalRef.componentInstance.title = options.title;
    }

    if (options?.confirmDialog !== undefined) {
      modalRef.componentInstance.confirmDialog = options.confirmDialog;
    }

    if (options?.crudMode === 'UPDATE' && options?.career) {
      modalRef.componentInstance.career.set(options.career);
      modalRef.componentInstance.isEditMode.set(true);
      modalRef.componentInstance.title = 'Edit Career';
    }

    return from(modalRef.result);
  }
}
