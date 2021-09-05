import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { QuizGameComponent } from './quiz-game/quiz-game.component';
import { QuizHomeComponent } from './quiz-home/quiz-home.component';
import { ResultComponent } from './result/result.component';

const routes: Routes = [
  { path:'quiz-home' ,component:QuizHomeComponent},
  { path:'quiz-game' ,component:QuizGameComponent},
  { path:'result' ,component:ResultComponent},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class QuizRoutingModule { }
