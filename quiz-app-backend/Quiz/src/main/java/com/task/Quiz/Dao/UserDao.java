package com.task.Quiz.Dao;

import com.task.Quiz.Model.UserMaster;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDao extends CrudRepository<UserMaster,Integer>{
    UserMaster findAllByRegistrationMail(String registrationMail);

    @Transactional
    @Modifying
    @Query("update UserMaster as cm set cm.highestScore=:highestScore where cm.registrationId=:registrationId")
    Integer updateScore(@Param("registrationId") Integer registrationId,@Param("highestScore") Double highestScore);

    List<UserMaster> findByOrderByHighestScoreDesc();
}
