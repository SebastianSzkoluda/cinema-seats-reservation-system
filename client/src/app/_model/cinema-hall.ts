import {Seat} from './seat';

export class CinemaHall {
  id: number;
  cinemaHallNumber: number;
  cinemaHallName: string;
  seats: Map<string, Seat[]>;

  constructor() {}
}
