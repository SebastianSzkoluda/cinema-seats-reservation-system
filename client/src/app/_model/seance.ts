import {CinemaHall} from './cinema-hall';

export interface Seance {
  id: number;
  filmName: string;
  showingTime: string;
  filmDuration: number;
  cinemaHall: CinemaHall;
}
