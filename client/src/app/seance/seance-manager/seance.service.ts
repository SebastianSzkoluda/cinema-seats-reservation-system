import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable, ReplaySubject} from 'rxjs';
import {SeanceDto} from '../../_model/seance-dto';
import {Seance} from '../../_model/seance';
import {Seat} from '../../_model/seat';

@Injectable({
  providedIn: 'root'
})
export class SeanceService {

  private _seances = new BehaviorSubject<Map<string, SeanceDto[]>>(new Map());
  private _reservationSeance = new ReplaySubject<Seance>(1);
  private _reservedSeats = new ReplaySubject<Seat[]>(1);
  private baseUrl = '/api/seance/';

  constructor(private http: HttpClient) {
  }

  get seances() {
    return this._seances.asObservable();
  }

  get reservationSeance() {
    return this._reservationSeance.asObservable();
  }

  get reservedSeats() {
    return this._reservedSeats.asObservable();
  }

  createSeance(seance: SeanceDto): Observable<any> {
    return this.http.post<any>(this.baseUrl, seance, {observe: 'response'});
  }

  updateSeance(id: number) {
    return this.http.get<Seance>(this.baseUrl + `${id}`).subscribe(data => this._reservationSeance.next(data));
  }

  updateReservedSeatsForSeance(id: number) {
    this.http.get<Seat[]>(this.baseUrl + `${id}` + '/seats').subscribe(data => {
      this._reservedSeats.next(data);
      console.log(data);
    });
  }

  updateAllSeancesByFilmName() {
    this.http.get<Map<string, SeanceDto[]>>(this.baseUrl).subscribe(data => {
      this._seances.next(data);
    }, error => console.log('Could not load seances.'));
  }
}
