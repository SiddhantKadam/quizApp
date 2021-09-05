package com.task.Quiz.Service.impl;

import com.task.Quiz.Dao.UserDao;
import com.task.Quiz.Dto.req.HighestScoreReqDto;
import com.task.Quiz.Dto.req.UserLoginReqDto;
import com.task.Quiz.Dto.res.UserLoginResDto;
import com.task.Quiz.Dto.res.UserResDto;
import com.task.Quiz.Model.UserMaster;
import com.task.Quiz.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserResDto create(UserMaster userMaster) {
        Boolean flag = false;
        UserResDto userResDto = new UserResDto();
        try {
            userMaster.setHighestScore(0.0);
            userDao.save(userMaster);
            flag = true;
            userResDto.setRegistrationId(userMaster.getRegistrationId());
            return userResDto;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return userResDto;
    }

    @Override
    public UserLoginResDto customerLogin(UserLoginReqDto userLoginReqDto) {

            UserMaster userMaster = userDao.findAllByRegistrationMail(userLoginReqDto.getRegistrationMail());
            UserLoginResDto userLoginResDto = new UserLoginResDto();
            if (userMaster == null) {
                userLoginResDto.setResponseCode(HttpStatus.NOT_FOUND.value());
                userLoginResDto.setMessage("Mail is not found");
            } else if (!userMaster.getRegistrationMail().equalsIgnoreCase(userLoginReqDto.getRegistrationMail())) {
                userLoginResDto.setResponseCode(HttpStatus.NOT_FOUND.value());
                userLoginResDto.setMessage("User Name is not found");
            } else {
                if (userMaster.getRegistrationPassword().equals(userLoginReqDto.getRegistrationPassword())) {
                    System.out.println("In THIS IF");
                    userLoginResDto.setResponseCode(HttpStatus.OK.value());
                    userLoginResDto.setMessage("Login Success");
                    userLoginResDto.setRegistrationId(userMaster.getRegistrationId());
                    userLoginResDto.setRegistrationMail(userMaster.getRegistrationMail());
                    userLoginResDto.setRegistrationName(userMaster.getRegistrationName());
                    userLoginResDto.setHighestScore(userMaster.getHighestScore());
                } else {
                    userLoginResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
                    userLoginResDto.setMessage("Password is Invalid.");
                }
            }
            return userLoginResDto;
    }

    @Override
    public Boolean highestScoreUpdate(HighestScoreReqDto highestScoreReqDto) {

        Boolean flag=false;
        UserMaster userMaster=userDao.findOne(highestScoreReqDto.getRegistrationId());

        if (userMaster!=null)
        {
            if (userMaster.getHighestScore() < highestScoreReqDto.getHighestScore())
            {
                Integer updateScore=userDao.updateScore(highestScoreReqDto.getRegistrationId(),highestScoreReqDto.getHighestScore());
                if (updateScore==1)
                {
                    flag=true;
                }
            }
        }
        return flag;
    }

    @Override
    public List getHighestScoreUsers() {
        List<UserMaster> list=userDao.findByOrderByHighestScoreDesc();
        return list;
    }


}