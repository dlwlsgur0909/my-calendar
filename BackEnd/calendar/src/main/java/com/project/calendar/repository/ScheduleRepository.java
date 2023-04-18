package com.project.calendar.repository;

import com.project.calendar.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {


    @Query("select s from ScheduleEntity s where s.user.userUsername=:username and s.scheduleFullDate=:fullDate")
    List<ScheduleEntity> findScheduleDetail(@Param("username") String username,
                                            @Param("fullDate") LocalDate fullDate
                                            );

    @Query("select s from ScheduleEntity s where s.user.userUsername=:username and s.scheduleFullDate BETWEEN :begin AND :end")
    List<ScheduleEntity> findScheduleList(@Param("username") String username,
                                          @Param("begin") LocalDate begin,
                                          @Param("end") LocalDate end
                                          );


    @Query("select count(*) from ScheduleEntity s where s.user.userUsername=:username and s.scheduleFullDate=:fullDate")
    int countSchedule(@Param("username") String username,
                      @Param("fullDate") LocalDate fullDate
                      );

    @Query("update ScheduleEntity s set s.scheduleDone=:done where s.scheduleId=:id")
    int changeDone(@Param("done") String done,
                   @Param("id") Long id
                   );

}
