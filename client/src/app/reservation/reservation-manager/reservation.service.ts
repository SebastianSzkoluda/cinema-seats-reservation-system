import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Reservation} from '../../_model/reservation';
import {ReservationOnSeats} from '../../_model/reservation-on-seats';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  private baseUrl = '/api/reservation';

  constructor(private http: HttpClient) {
  }

  addNewReservation(reservation: Reservation): Observable<any> {
    return this.http.post<any>(this.baseUrl, reservation);
  }

  getAllReservationsOnSeance(id: number): Observable<ReservationOnSeats[]> {
    return this.http.get<ReservationOnSeats[]>(this.baseUrl + '/seance/' + `${id}`);
  }
}
