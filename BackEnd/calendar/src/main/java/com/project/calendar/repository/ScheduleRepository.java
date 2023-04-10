package com.project.calendar.repository;

import com.project.calendar.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {

    @Query("select s from ScheduleEntity s where s.user.userUsername=:username and s.scheduleYear=:year and s.scheduleMonth=:month and s.scheduleDate=:date" )
    List<ScheduleEntity> findScheduleList(@Param("username") String username,
                                          @Param("year") String year,
                                          @Param("month") String month,
                                          @Param("date") String date
                                          );

}
