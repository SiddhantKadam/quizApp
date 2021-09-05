import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { QuizRoutingModule } from './quiz-routing.module';
import { QuizHomeComponent } from './quiz-home/quiz-home.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { QuizGameComponent } from './quiz-game/quiz-game.component';
import { ResultComponent } from './result/result.component';


@NgModule({
  declarations: [
    QuizHomeComponent,
    QuizGameComponent,
    ResultComponent
  ],
  imports: [
    CommonModule,
    QuizRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
  ]
})
export class QuizModule { }
