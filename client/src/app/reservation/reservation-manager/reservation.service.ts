import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Reservation} from '../../_model/reservation';

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
}
