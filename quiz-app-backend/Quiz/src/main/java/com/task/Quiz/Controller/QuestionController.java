package com.task.Quiz.Controller;

import com.task.Quiz.Dto.res.UserResDto;
import com.task.Quiz.Model.QuestionMaster;
import com.task.Quiz.Model.UserMaster;
import com.task.Quiz.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    private ResponseEntity create(@RequestBody QuestionMaster questionMaster){
        Boolean flag = questionService.create(questionMaster);
        return new ResponseEntity(flag, HttpStatus.CREATED);
    }

    @GetMapping(value = "getAll")
    private ResponseEntity getAll(){
        List list = questionService.getAll();
        return new ResponseEntity(list, HttpStatus.CREATED);
    }
}
