import {Component, inject, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CarouselComponent} from "../share/carousel/carousel.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CarouselComponent
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit {
  http = inject(HttpClient)
  a: string = "";
  b:any={}

  ngOnInit() {
    this.hello()
    this.show()
  }

  hello() {
    this.http.get('api/hello',{responseType:'text'}).subscribe(e => {
      this.a=e
    })
  }

  show() {
    this.http.get<any>('api/Show').subscribe(e => {
      this.b=e
    })
  }
}
