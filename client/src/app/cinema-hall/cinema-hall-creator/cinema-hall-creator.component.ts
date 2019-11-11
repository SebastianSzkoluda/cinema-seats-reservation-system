import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {CinemaHallService} from '../cinema-hall-manager/cinema-hall.service';
import {CinemaHall} from '../../_model/cinema-hall';
import {SnackbarService} from '../../snackbar/snackbar-service';

@Component({
  selector: 'app-cinema-hall-creator',
  templateUrl: './cinema-hall-creator.component.html',
  styleUrls: ['./cinema-hall-creator.component.css']
})
export class CinemaHallCreatorComponent implements OnInit {

  uploadForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private snackbarService: SnackbarService,
              private cinemaHallService: CinemaHallService) { }

  ngOnInit() {
    this.uploadForm = this.formBuilder.group({
      file: new FormControl(null, Validators.required),
      name: new FormControl(null, Validators.required)
    });
  }

  onFileSelect(event) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.uploadForm.get('file').setValue(file);
    }
  }

  onSubmit() {
    const formData = new FormData();
    formData.append('file', this.uploadForm.get('file').value);

    this.cinemaHallService.createCinemaHall(formData).subscribe(
      (res: Response) => {
        const location = res.headers.get('location');
        this.cinemaHallService.updateCinemaHallWithURI(location);
        this.snackbarService.openSnackBar('Cinema hall added successfully', 'success');
      },
      (err) => console.log(err)
    );
    this.uploadForm.reset();
  }

}
