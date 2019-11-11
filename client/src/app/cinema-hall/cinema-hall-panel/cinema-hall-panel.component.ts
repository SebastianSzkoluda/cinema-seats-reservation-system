import {Component, OnInit} from '@angular/core';
import {CinemaHall} from '../../_model/cinema-hall';
import {CinemaHallService} from '../cinema-hall-manager/cinema-hall.service';

@Component({
  selector: 'app-cinema-hall-panel',
  templateUrl: './cinema-hall-panel.component.html',
  styleUrls: ['./cinema-hall-panel.component.css']
})
export class CinemaHallPanelComponent implements OnInit {

  actualCinemaHall: CinemaHall = new CinemaHall();

  constructor(private cinemaHallService: CinemaHallService) {
  }

  ngOnInit() {
    this.cinemaHallService.updateLatestCinemaHall();
    this.cinemaHallService.cinemaHall.subscribe(data => this.actualCinemaHall = data);
  }
}
