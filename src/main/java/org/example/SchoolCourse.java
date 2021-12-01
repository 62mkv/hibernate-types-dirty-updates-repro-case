package org.example;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Duration;

@Data
@Builder
@EqualsAndHashCode
public class SchoolCourse {
    private String courseName;
    private Duration courseDuration;
}
