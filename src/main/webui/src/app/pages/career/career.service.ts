import {inject, Injectable, signal, WritableSignal} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {single} from "rxjs";
import {CareerDto, Page, PagedResult} from "../../../generated-model/model";
import {IgnoreNullHttpParams} from "../share/IgnoreNullHttpParams";

@Injectable({
  providedIn: 'root'
})
export class CareerService {
  http = inject(HttpClient)
  careers: WritableSignal<PagedResult<CareerDto>> = signal({
    content: [],
    totalPages: 0,
    totalElements: 0,
    size: 10,  // Default size
    number: 0
  });

  getCareers(page: number = 0) {
    let params = new HttpParams()
      .set('page', page)
      .set('size', 10)
      .set('sort', 'id,asc')
    return this.http.get<PagedResult<CareerDto>>(`api/career`, {params}).subscribe(e => {
      this.careers.set(e)
    })
  }

  addCareer(career: CareerDto) {
    return this.http.post<CareerDto>('api/career', career, {headers: {'Content-Type': 'application/json'}}).subscribe(()=>{
      this.getCareers()
    })
  }

  update(career: CareerDto) {
    return this.http.put<CareerDto>(`api/career/${career.id}`, career, {headers: {'Content-Type': 'application/json'}}).subscribe(()=>{
      this.getCareers()
    })
  }

  delete(id: number) {
    return this.http.delete(`api/career/${id}`, {headers: {'Content-Type': 'application/json'}}).subscribe(()=>{
      this.getCareers()
    })
  }

  search(param:any){
    return this.http.get<PagedResult<CareerDto>>(`/api/career/search`,{params:param}).subscribe(e=>{
      this.careers.set(e)
    })
  }
}
