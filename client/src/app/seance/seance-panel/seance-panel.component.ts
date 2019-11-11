import { Component, OnInit } from '@angular/core';
import {CinemaHall} from '../../_model/cinema-hall';
import {CinemaHallService} from '../../cinema-hall/cinema-hall-manager/cinema-hall.service';
import {SeanceDto} from '../../_model/seance-dto';
import {SeanceService} from '../seance-manager/seance.service';
import * as moment from 'moment';
import {Router} from '@angular/router';

@Component({
  selector: 'app-seance-panel',
  templateUrl: './seance-panel.component.html',
  styleUrls: ['./seance-panel.component.css']
})
export class SeancePanelComponent implements OnInit {

  cinemaHalls: CinemaHall[] = [];
  seances: Map<string, SeanceDto[]> = new Map();

  constructor(private cinemaHallService: CinemaHallService, private seanceService: SeanceService, private router: Router) { }

  ngOnInit() {
    this.cinemaHallService.getAllCinemaHalls().subscribe(value => {
      this.cinemaHalls = value;
      console.log(this.cinemaHalls);
    });
    this.seanceService.updateAllSeancesByFilmName();
    this.seanceService.seances.subscribe(data => this.seances = data);
  }

  formatTimestamp(timestamp) {
    return moment(timestamp).format('YYYY-MM-DD HH:mm');
  }

  openReservationView(seance: SeanceDto) {
    this.router.navigate(['/reservation/', seance.id]);
  }
}
