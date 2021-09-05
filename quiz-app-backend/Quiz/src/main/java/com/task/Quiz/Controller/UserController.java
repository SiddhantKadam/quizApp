package com.task.Quiz.Controller;

import com.task.Quiz.Dto.req.HighestScoreReqDto;
import com.task.Quiz.Dto.req.UserLoginReqDto;
import com.task.Quiz.Dto.res.UserLoginResDto;
import com.task.Quiz.Dto.res.UserResDto;
import com.task.Quiz.Model.UserMaster;
import com.task.Quiz.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    private ResponseEntity create(@RequestBody UserMaster userMaster){
        UserResDto userResDto = userService.create(userMaster);
        return new ResponseEntity(userResDto, HttpStatus.CREATED);
    }

    @PostMapping(value = "/userLogin")
    public ResponseEntity customerLogin(@RequestBody UserLoginReqDto userLoginReqDto)
    {
        UserLoginResDto userLoginResDto = userService.customerLogin(userLoginReqDto);
        return new ResponseEntity(userLoginResDto,HttpStatus.OK);
    }

    @PostMapping(value = "/highestScoreUpdate")
    public ResponseEntity highestScoreUpdate(@RequestBody HighestScoreReqDto highestScoreReqDto)
    {
        Boolean flag = userService.highestScoreUpdate(highestScoreReqDto);
        return new ResponseEntity(flag,HttpStatus.OK);
    }


    @GetMapping(value = "getHighestScoreUsers")
    private ResponseEntity getHighestScoreUsers(){
        List list = userService.getHighestScoreUsers();
        return new ResponseEntity(list, HttpStatus.CREATED);
    }


}
