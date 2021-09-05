package com.task.Quiz.Service.impl;

import com.task.Quiz.Dao.QuestionDao;
import com.task.Quiz.Model.QuestionMaster;
import com.task.Quiz.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;
    @Override
    public Boolean create(QuestionMaster questionMaster) {
        try {
            questionDao.save(questionMaster);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List getAll() {
        return (List) questionDao.findAll();

//        Pageable topFive = new PageRequest(0, limit);
//        List list=questionDao.getRandomQuestions(topFive);
//        return list;
    }
}
