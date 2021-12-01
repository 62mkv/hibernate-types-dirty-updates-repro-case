package org.example;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.jackson.Jacksonized;

import java.time.Duration;

@Data
@Builder
@EqualsAndHashCode
@Jacksonized
public class SchoolCourse {
    private String courseName;
    private Duration courseDuration;
}
