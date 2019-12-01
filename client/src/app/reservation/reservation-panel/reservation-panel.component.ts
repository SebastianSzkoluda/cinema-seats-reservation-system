import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {ActivatedRoute, Router} from '@angular/router';
import {map} from 'rxjs/operators';
import {SeanceService} from '../../seance/seance-manager/seance.service';
import {Seance} from '../../_model/seance';
import {Seat} from '../../_model/seat';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Reservation} from '../../_model/reservation';
import {ReservationService} from '../reservation-manager/reservation.service';
import {CinemaHallService} from '../../cinema-hall/cinema-hall-manager/cinema-hall.service';
import {SnackbarService} from '../../snackbar/snackbar-service';
import {ReservationOnSeats} from '../../_model/reservation-on-seats';

@Component({
  selector: 'app-reservation-panel',
  templateUrl: './reservation-panel.component.html',
  styleUrls: ['./reservation-panel.component.css']
})
export class ReservationPanelComponent implements OnInit {

  id$: Observable<string>;
  seance: Seance;
  reservation = new Reservation();
  reservationForm: FormGroup;
  seatsForReservation = [];
  reservedSeats: Seat[] = [];
  reservationsOnSeats: ReservationOnSeats[] = [];
  displayedColumns: string[] = ['id', 'firstName', 'lastName', 'seats'];

  constructor(private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private seanceService: SeanceService,
              private cinemaHallService: CinemaHallService,
              private reservationService: ReservationService,
              private snackbarService: SnackbarService,
              private router: Router) {
  }

  ngOnInit() {
    this.reservationForm = this.formBuilder.group({
      firstName: new FormControl(null, Validators.required),
      lastName: new FormControl(null, Validators.required),
    });
    this.id$ = this.route.paramMap.pipe(map(paramMap => paramMap.get('id')));
    this.id$.subscribe(id => {
      this.seanceService.updateSeance(+id);
      this.seanceService.reservationSeance.subscribe(data => {
        this.seance = data;
        this.cinemaHallService.updateCinemaHall(this.seance.cinemaHall);
      });
      this.getAllReservationsOnSeance(id);
      this.getReservedSeats(id);
    });
  }

  onSubmit() {
    this.reservation.firstName = this.reservationForm.get('firstName').value;
    this.reservation.lastName = this.reservationForm.get('lastName').value;
    this.reservation.seanceId = this.seance.id;
    this.reservation.seatIds = this.filterSeatsForReservation();
    this.reservationService.addNewReservation(this.reservation).subscribe();
    setTimeout(() => {
      this.seanceService.updateReservedSeatsForSeance(this.seance.id);
      this.getAllReservationsOnSeance(this.seance.id);
      }, 1500
    );
    this.snackbarService.openSnackBar('Reservation added successfully', 'success');
    this.resetForm();
  }

  getReservedSeats(id) {
    this.seanceService.updateReservedSeatsForSeance(+id);
    this.seanceService.reservedSeats.subscribe(data => this.reservedSeats = data);
  }

  setSeatsForReservation(seatsForReservation) {
    this.seatsForReservation = seatsForReservation;
  }

  filterSeatsForReservation() {
    const numbers = this.reservedSeats.map(data => data.id);
    return this.seatsForReservation.filter(item => numbers.indexOf(item) < 0);
  }

  getAllReservationsOnSeance(id) {
    this.reservationService.getAllReservationsOnSeance(+id)
      .subscribe(data => this.reservationsOnSeats = data);
  }

  convertListOfSeatsToString(seats: Array<Seat>) {
    return seats.map(x => x.seatYPosition + x.seatXPosition).join(', ');
  }

  resetForm() {
    this.reservationForm.reset();
    Object.keys(this.reservationForm.controls).forEach(key => {
      this.reservationForm.get(key).setErrors(null);
    });
  }

}
