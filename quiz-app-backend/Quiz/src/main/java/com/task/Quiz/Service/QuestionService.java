package com.task.Quiz.Service;

import com.task.Quiz.Model.QuestionMaster;

import java.util.List;

public interface QuestionService {
    Boolean create(QuestionMaster questionMaster);

    List getAll();
}
