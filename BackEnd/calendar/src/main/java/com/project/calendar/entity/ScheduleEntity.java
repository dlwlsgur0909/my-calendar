package com.project.calendar.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "schedule")
public class ScheduleEntity {

    @Id
    @Column(name = "schedule_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @Column(name = "schedule_year")
    private String scheduleYear;

    @Column(name = "schedule_month")
    private String scheduleMonth;

    @Column(name = "schedule_date")
    private String scheduleDate;

    @Column(name = "schedule_title")
    private String scheduleTitle;

    @Column(name = "schedule_done")
    private String scheduleDone;

    @Column(name = "schedule_full_date")
    private LocalDate scheduleFullDate;

    @CreationTimestamp
    @Column(name = "schedule_create")
    private LocalDate scheduleCreate;

    @CreationTimestamp
    @Column(name = "schedule_update")
    private LocalDate scheduleUpdate;

//    @Column(name = "user_id", insertable = false, updatable = false)
//    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;


    public void changeDone(String done) {
        this.scheduleDone = done;
    }


}
