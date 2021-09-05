package com.task.Quiz.Dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginReqDto {

    private String registrationMail;
    private String registrationPassword;
}
