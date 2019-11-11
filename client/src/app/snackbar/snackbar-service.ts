import {Injectable} from '@angular/core';
import {MatSnackBar} from '@angular/material';
import {SnackbarComponent} from './snackbar.component';

@Injectable({
  providedIn: 'root'
})
export class SnackbarService {

  constructor(
    private snackBar: MatSnackBar) {
  }

  openSnackBar(message: string, panelClass: string) {
    this.snackBar.openFromComponent(SnackbarComponent, {
      data: message,
      panelClass: [panelClass],
      duration: 1000,
      verticalPosition: 'top',
      horizontalPosition: 'right'
    });
  }
}
