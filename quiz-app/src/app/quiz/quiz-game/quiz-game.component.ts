import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpmethodsService } from 'src/app/services/httpmethods.service';
import { CountList, resultClass } from '../quizMode';
import { GetAllQuestionsURl, postResult } from '../quizURL';

@Component({
  selector: 'app-quiz-game',
  templateUrl: './quiz-game.component.html',
  styleUrls: ['./quiz-game.component.css']
})
export class QuizGameComponent implements OnInit {

  resultModel = new resultClass();
  registeredId: number | any;

  ansOption: String;
  questionNumberCount: number = 0;

  countList = new Array<CountList>();
  countObj = new CountList();
  questionList: any[];

  status1: boolean;
  status12: boolean;

  status2: boolean;
  status22: boolean;

  status3: boolean;
  status32: boolean;

  status4: boolean;
  status42: boolean;


  constructor(private httpService: HttpmethodsService, private router: Router) { }

  ngOnInit(): void {
    this.getAllQuestion();
  }

  // ==== Get All Random Questions ====
  getAllQuestion() {
    this.httpService.getRequest(GetAllQuestionsURl).subscribe((data: any) => {
      this.questionList = data;
      this.questionList = this.questionList.sort(() => Math.random() - 0.5);
    });
  }

  dFunc(quest: any) {
    if (quest.correctAnswer == 'd') {
      this.status4 = true;
      this.countList.push(this.countObj);
    }
    else {
      this.status42 = true;
      this.correctOption(quest);
    }
    this.questionNumberCount++;
    this.nextQuestion(quest);
  }

  nextQuestion(quest: any) {
    setTimeout(() => {
      for (let i = 0; i < this.questionList.length; i++) {
        if (this.questionList[i].questionId == quest.questionId) {
          this.questionList.splice(i, 1);
          this.status1 = false;
          this.status12 = false;

          this.status2 = false;
          this.status22 = false;

          this.status3 = false;
          this.status32 = false;

          this.status4 = false;
          this.status42 = false;
        }
      }
    }, 2000);
  }

  correctOption(quest: any) {
    if (quest.correctAnswer == 'a') {
      this.status1 = true;
    }
    if (quest.correctAnswer == 'b') {
      this.status2 = true;
    }
    if (quest.correctAnswer == 'c') {
      this.status3 = true;
    }
    if (quest.correctAnswer == 'd') {
      this.status4 = true;
    }
  }

  cFunc(quest: any) {
    if (quest.correctAnswer == 'c') {
      this.status3 = true;
      this.countList.push(this.countObj);
    }
    else {
      this.status32 = true;
      this.correctOption(quest);
    }
    this.questionNumberCount++;
    this.nextQuestion(quest);
  }

  bFunc(quest: any) {
    if (quest.correctAnswer == 'b') {
      this.status2 = true;
      this.countList.push(this.countObj);
    }
    else {
      this.status22 = true;
      this.correctOption(quest);
    }
    this.questionNumberCount++;
    this.nextQuestion(quest);
  }

  aFunc(quest: any) {
    if (quest.correctAnswer == 'a') {
      this.status1 = true;
      this.countList.push(this.countObj);
    }
    else {
      this.status12 = true;
      this.correctOption(quest);
    }
    this.questionNumberCount++;
    this.nextQuestion(quest);
  }

  // ==== Post Result ====
  getResult() {
    this.registeredId = sessionStorage.getItem("registrationId");
    this.resultModel.highestScore = this.countList.length / 5 * 100;
    this.resultModel.registrationId = this.registeredId;
    this.httpService.postRequest(postResult, this.resultModel).subscribe((data: any) => {
    })
    sessionStorage.pointsCount = this.countList.length;
  }
}
