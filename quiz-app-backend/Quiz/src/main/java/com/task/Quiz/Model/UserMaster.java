package com.task.Quiz.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_master")
@Getter
@Setter
public class UserMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private Integer registrationId;

    @Column(length = 500)
    private String registrationName;

    @Column(length = 50)
    private String registrationPassword;

    @Column(length = 50)
    private String registrationMail;

    @Column
    private Double highestScore=0.0;
}
