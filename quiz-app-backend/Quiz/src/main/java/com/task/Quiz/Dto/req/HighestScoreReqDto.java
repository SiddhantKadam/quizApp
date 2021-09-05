package com.task.Quiz.Dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class HighestScoreReqDto {
    private Integer registrationId;
    private Double highestScore;
}
