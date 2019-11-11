import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CinemaHall} from '../../_model/cinema-hall';
import {Seat} from '../../_model/seat';
import {CinemaHallService} from '../cinema-hall-manager/cinema-hall.service';
import {SeanceService} from '../../seance/seance-manager/seance.service';

@Component({
  selector: 'app-cinema-hall-table',
  templateUrl: './cinema-hall-table.component.html',
  styleUrls: ['./cinema-hall-table.component.css']
})
export class CinemaHallTableComponent implements OnInit {
  @Output()
  emitter = new EventEmitter();
  @Input()
  reservedSeats: Seat[] = [];
  @Input()
  isForReservationView: boolean;
  seatsForReservation = [];
  cinemaHall: CinemaHall = new CinemaHall();

  constructor(private cinemaHallService: CinemaHallService, private seanceService: SeanceService) {
  }

  ngOnInit() {
    this.cinemaHallService.cinemaHall.subscribe(data => this.cinemaHall = data);
    this.seanceService.reservedSeats.subscribe(data => {
      this.reservedSeats = data;
    });
  }

  isReserved(seat: Seat) {
    if (this.isForReservationView === false) {
      return 'default';
    } else if (this.reservedSeats.some((item) => item.id === seat.id)) {
      return 'reserved';
    } else {
      return 'free';
    }
  }

  addSeatToReservation(seat: Seat, e: HTMLElement) {
    if (e.classList.contains('reserved')) {
      if (this.reservedSeats.some((item) => item.id === seat.id)) {
        return;
      }
      console.log('seat removed: ' + seat.id);
      this.seatsForReservation.splice(this.seatsForReservation.indexOf(seat.id), 1);
      this.emitSeatsForReservation();
      e.className = 'free';
      return;
    }
    e.className = 'reserved';
    console.log('seat added: ' + seat.id);
    this.seatsForReservation.push(seat.id);
    this.emitSeatsForReservation();
  }

  emitSeatsForReservation() {
    this.emitter.emit(this.seatsForReservation);
  }
}
