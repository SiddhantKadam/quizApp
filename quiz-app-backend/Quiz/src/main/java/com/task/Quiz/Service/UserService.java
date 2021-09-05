package com.task.Quiz.Service;

import com.task.Quiz.Dto.req.HighestScoreReqDto;
import com.task.Quiz.Dto.req.UserLoginReqDto;
import com.task.Quiz.Dto.res.UserLoginResDto;
import com.task.Quiz.Dto.res.UserResDto;
import com.task.Quiz.Model.UserMaster;

import java.util.List;

public interface UserService {
    UserResDto create(UserMaster userMaster);

    UserLoginResDto customerLogin(UserLoginReqDto userLoginReqDto);

    Boolean highestScoreUpdate(HighestScoreReqDto highestScoreReqDto);

    List getHighestScoreUsers();
}
