import {Component, effect, inject, OnInit, signal, WritableSignal} from '@angular/core';
import {NgbActiveModal, NgbPagination} from '@ng-bootstrap/ng-bootstrap';
import {CreateModalService} from "../share/modal/create-modal/create-modal.service";
import {HttpClient, HttpParams} from "@angular/common/http";
import {CareerDto, Page, PagedResult, PositionArray} from "../../../generated-model/model";
import {CareerService} from "./career.service";
import {DecimalPipe} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {IgnoreNullHttpParams} from "../share/IgnoreNullHttpParams";

@Component({
  selector: 'app-career',
  standalone: true,
  imports: [
    NgbPagination,
    DecimalPipe,
    FormsModule
  ],
  templateUrl: './career.component.html',
  styleUrl: './career.component.scss'
})
export class CareerComponent implements OnInit {
  public modalService = inject(CreateModalService)
  careerService = inject(CareerService)

  positions: WritableSignal<string[]> = signal(PositionArray)
  position: WritableSignal<string> = signal('')
  http = inject(HttpClient)
  page: number = 1;
  sortField: string = 'id';
  sortOrder: string = 'asc';


  constructor() {
    effect(() => {
      console.log("test",this.careerService.careers())
    });

  }

  ngOnInit() {
    console.log("ng")
    this.fetchCareers()

  }


  get careers() {
    return this.careerService.careers;
  }

  get totalElements(): number {
    return this.careers().totalElements || 0;
  }


  fetchCareers(): void {
    this.careerService.getCareers(this.page - 1)
  }


  onPageChange(page: number): void {
    this.page = page ;
    this.fetchCareers();
  }


  open() {
    this.modalService.open({crudMode: "CREATE", title: "Create Career"})
  }

  edit(career: CareerDto) {
    this.modalService.open({crudMode: "UPDATE", title: "Edit Career", career: career})
  }

  delete(id: any) {
    this.careerService.delete(id)
    console.log("testt")
    // this.fetchCareers()
  }

  search(e:any){
    this.position.set(e.target.value)
    console.log(this.position())
    let params =  IgnoreNullHttpParams.fromObject({page: this.page - 1, size: 10, sort: 'id,desc'})
      .set("sort", "id,desc")
      .set("position",this.position())
      .set("statusPosition",true)
      .toHttpParam();
    this.careerService.search(params)
  }
}
