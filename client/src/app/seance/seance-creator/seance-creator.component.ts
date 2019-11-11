import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {CinemaHallService} from '../../cinema-hall/cinema-hall-manager/cinema-hall.service';
import {CinemaHall} from '../../_model/cinema-hall';
import {SeanceService} from '../seance-manager/seance.service';
import {SeanceDto} from '../../_model/seance-dto';
import {SnackbarService} from '../../snackbar/snackbar-service';

@Component({
  selector: 'app-seance-creator',
  templateUrl: './seance-creator.component.html',
  styleUrls: ['./seance-creator.component.css']
})
export class SeanceCreatorComponent implements OnInit {

  @Input()
  cinemaHalls: CinemaHall[] = [];
  seanceDto = new SeanceDto();
  seanceForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private cinemaHallService: CinemaHallService,
              private snackbarService: SnackbarService,
              private seanceService: SeanceService) {
  }

  ngOnInit() {
    this.seanceForm = this.formBuilder.group({
      filmName: new FormControl(null, Validators.required),
      showingTime: new FormControl(null, Validators.required),
      filmDuration: new FormControl(null, Validators.required),
      cinemaHallId: new FormControl(null, Validators.required)
    });
  }

  onSubmit() {
    this.seanceDto.filmName = this.seanceForm.get('filmName').value;
    this.seanceDto.showingTime = this.seanceForm.get('showingTime').value;
    this.seanceDto.filmDuration = this.seanceForm.get('filmDuration').value;
    this.seanceDto.cinemaHallId = this.seanceForm.get('cinemaHallId').value;
    this.seanceService.createSeance(this.seanceDto).subscribe(() => {
      this.seanceService.updateAllSeancesByFilmName();
      this.snackbarService.openSnackBar('Seance added successfully', 'success');
    });
    this.resetForm();
  }

  resetForm() {
    this.seanceForm.reset();
    Object.keys(this.seanceForm.controls).forEach(key => {
      this.seanceForm.get(key).setErrors(null);
    });
  }

}
