import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable, ReplaySubject} from 'rxjs';
import {CinemaHall} from '../../_model/cinema-hall';

@Injectable({
  providedIn: 'root'
})
export class CinemaHallService {

  private _cinemaHall = new ReplaySubject<CinemaHall>(1);
  private baseUrl = '/api/cinema-hall/';

  constructor(private http: HttpClient) {
  }

  get cinemaHall() {
    return this._cinemaHall.asObservable();
  }

  updateCinemaHall(cinemaHall: CinemaHall) {
    this._cinemaHall.next(cinemaHall);
  }

  createCinemaHall(formData: FormData): Observable<any> {
    return this.http.post<any>(this.baseUrl + 'file', formData, {observe: 'response'});
  }

  retrieveCinemaHall(location: string): Observable<CinemaHall> {
    return this.http.get<CinemaHall>(location);
  }

  updateCinemaHallWithURI(location: string) {
    this.retrieveCinemaHall(location).subscribe(data => this._cinemaHall.next(data));
  }

  retrieveLatestCinemaHall(): Observable<CinemaHall[]> {
    return this.http.get<CinemaHall[]>(this.baseUrl + 'latest');
  }

  updateLatestCinemaHall() {
    this.retrieveLatestCinemaHall().subscribe(data => this._cinemaHall.next(data[0]));
  }

  getAllCinemaHalls(): Observable<CinemaHall[]> {
    return this.http.get<CinemaHall[]>(this.baseUrl);
  }

}
