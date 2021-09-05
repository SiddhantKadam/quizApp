package com.task.Quiz.Dao;

import com.task.Quiz.Model.QuestionMaster;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionDao extends CrudRepository<QuestionMaster,Integer> {
//    @Query("from QuestionMaster as qm order by RAND()")
//    List getRandomQuestions(Pageable topFive);
}
