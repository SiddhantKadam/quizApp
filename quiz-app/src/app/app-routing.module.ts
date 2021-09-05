import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', loadChildren: () => import('./authorization/authorization.module').then(mod => mod.AuthorizationModule) },
  { path: 'quiz', loadChildren: () => import('./quiz/quiz.module').then(mod => mod.QuizModule) },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
