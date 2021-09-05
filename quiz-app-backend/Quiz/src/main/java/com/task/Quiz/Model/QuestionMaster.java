package com.task.Quiz.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "question_master")
@Getter
@Setter
public class QuestionMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private Integer questionId;

    @Column(length = 500)
    private String questionName;

    @Column(length = 50)
    private String optionA;

    @Column(length = 50)
    private String optionB;

    @Column(length = 50)
    private String optionC;

    @Column(length = 50)
    private String optionD;

    @Column(length = 50)
    private String correctAnswer;

}
