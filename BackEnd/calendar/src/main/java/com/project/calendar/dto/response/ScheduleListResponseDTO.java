package com.project.calendar.dto.response;

import com.project.calendar.entity.ScheduleEntity;
import lombok.*;

@Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleListResponseDTO {

    private Long id;
    private String title;
    private String done;
    private String year;
    private String month;
    private String date;

    public ScheduleListResponseDTO(ScheduleEntity entity) {
        id = entity.getScheduleId();
        title = entity.getScheduleTitle();
        year = entity.getScheduleYear();
        month = entity.getScheduleMonth();
        date = entity.getScheduleDate();
        done = entity.getScheduleDone();
    }

}
