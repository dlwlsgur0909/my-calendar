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

    public ScheduleListResponseDTO(ScheduleEntity entity) {
        id = entity.getScheduleId();
        title = entity.getScheduleTitle();
        done = entity.getScheduleDone();
    }

}
