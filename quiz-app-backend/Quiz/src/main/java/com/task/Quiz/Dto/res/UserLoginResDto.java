package com.task.Quiz.Dto.res;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter@Setter@NoArgsConstructor
public class UserLoginResDto {
    private Integer registrationId;
    private String registrationName;
    private String registrationPassword;
    private String registrationMail;
    private Double highestScore;
    private String message;
    private Integer responseCode;
}
