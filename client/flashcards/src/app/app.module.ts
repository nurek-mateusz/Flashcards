import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { BoxComponent } from './box/box.component';
import { AddCardComponent } from './add-card/add-card.component';
import { LearningComponent } from './learning/learning.component';
import { HttpClientModule } from '@angular/common/http';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

const appRoutes: Routes = [
  { path: 'box', component: BoxComponent },
  { path: 'add', component: AddCardComponent },
  { path: 'learn/:boxId', component: LearningComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    BoxComponent,
    AddCardComponent,
    LearningComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes
    ),
    HttpClientModule,
    FontAwesomeModule,
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
