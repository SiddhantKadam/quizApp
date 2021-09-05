import { Component, OnInit } from '@angular/core';
import { HttpmethodsService } from 'src/app/services/httpmethods.service';
import { GetHighestURL } from '../quizURL';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {

  resultPoints: number | any;
  percentage: any;
  getHighestScoreList: any[];

  constructor(private httpService: HttpmethodsService,) { }

  ngOnInit(): void {
    this.resultPoints = sessionStorage.getItem("pointsCount");
    this.percentage = this.resultPoints / 5 * 100;
    this.getHighestScore();
  }

  getHighestScore()
  {
    this.httpService.getRequest(GetHighestURL).subscribe((data: any) => {
      this.getHighestScoreList = data;
    });
  }

}
