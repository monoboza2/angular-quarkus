import {Component, inject, input, signal, ViewChild, ViewEncapsulation, WritableSignal} from '@angular/core';
import bootstrap from 'bootstrap';
import {FormsModule, NgForm} from "@angular/forms";
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {Career, CareerDto, Position, PositionArray} from "../../../../../generated-model/model";
import {HttpClient} from "@angular/common/http";
import {CareerService} from "../../../career/career.service";

@Component({
  selector: 'app-create-modal',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './create-modal.component.html',
  styleUrl: './create-modal.component.scss',
  encapsulation: ViewEncapsulation.None
})
export class CreateModalComponent {
  public activeModal = inject(NgbActiveModal)
  http = inject(HttpClient)
  careerService=inject(CareerService)
  positions: WritableSignal<string[]> = signal(PositionArray)
  career = signal<CareerDto>({});
  isEditMode = signal(false);
  @ViewChild('form', {static: true})
  public form!: NgForm;
  reason!: string;
  title: string = "hello";

  cancel() {
    this.activeModal.dismiss()
  }

  confirm() {
    if (this.isEditMode()) {
      this.careerService.update(this.career());
    } else {
      this.careerService.addCareer(this.career());
    }

    this.careerService.getCareers()
    this.activeModal.dismiss();
  }

}
