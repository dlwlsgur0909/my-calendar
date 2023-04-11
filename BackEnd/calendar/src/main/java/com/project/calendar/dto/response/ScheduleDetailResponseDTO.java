package com.project.calendar.dto.response;

import com.project.calendar.entity.ScheduleEntity;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleDetailResponseDTO {


    private Long id;
    private String title;
    private String done;

    public ScheduleDetailResponseDTO(ScheduleEntity entity) {
        this.id = entity.getScheduleId();
        this.title = entity.getScheduleTitle();
        this.done = entity.getScheduleDone();
    }

}
