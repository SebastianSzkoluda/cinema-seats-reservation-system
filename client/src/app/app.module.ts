import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {RouterModule, Routes} from '@angular/router';
import {HomePageComponent} from './page-content/home-page/home-page.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HeaderComponent} from './page-content/header/header.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {FlexLayoutModule} from '@angular/flex-layout';
import {CinemaHallCreatorComponent} from './cinema-hall/cinema-hall-creator/cinema-hall-creator.component';
import {CinemaHallService} from './cinema-hall/cinema-hall-manager/cinema-hall.service';
import {HttpClientModule} from '@angular/common/http';
import {CinemaHallPanelComponent} from './cinema-hall/cinema-hall-panel/cinema-hall-panel.component';
import {FileInputConfig, MaterialFileInputModule, NGX_MAT_FILE_INPUT_CONFIG} from 'ngx-material-file-input';
import {CinemaHallTableComponent} from './cinema-hall/cinema-hall-table/cinema-hall-table.component';
import {SeancePanelComponent} from './seance/seance-panel/seance-panel.component';
import {AngularMaterialModule} from './material.module';
import {SeanceCreatorComponent} from './seance/seance-creator/seance-creator.component';
import {SeanceService} from './seance/seance-manager/seance.service';
import {ReservationPanelComponent} from './reservation/reservation-panel/reservation-panel.component';
import {ReservationService} from './reservation/reservation-manager/reservation.service';
import {SnackbarComponent} from './snackbar/snackbar.component';
import {SnackbarService} from './snackbar/snackbar-service';

const appRoutes: Routes = [
  {
    path: '',
    component: HomePageComponent
  },
  {
    path: 'cinema-halls',
    component: CinemaHallPanelComponent
  },
  {
    path: 'seances',
    component: SeancePanelComponent
  },
  {
    path: 'reservation/:id',
    component: ReservationPanelComponent
  }, {
    path: '**',
    redirectTo: '',
  }
];

export const config: FileInputConfig = {
  sizeUnit: 'Octet'
};

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    HeaderComponent,
    CinemaHallCreatorComponent,
    CinemaHallPanelComponent,
    CinemaHallTableComponent,
    SeancePanelComponent,
    SeanceCreatorComponent,
    ReservationPanelComponent,
    SnackbarComponent
  ],
  imports: [
    AngularMaterialModule,
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    FormsModule,
    FlexLayoutModule,
    BrowserAnimationsModule,
    MaterialFileInputModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    SnackbarComponent
  ],
  entryComponents: [
    SnackbarComponent
  ],
  providers: [
    CinemaHallService,
    SeanceService,
    ReservationService,
    SnackbarService,
    {provide: NGX_MAT_FILE_INPUT_CONFIG, useValue: config}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
