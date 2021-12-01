package org.example;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Builder
@Jacksonized
@EqualsAndHashCode
public class StudentDetails {
    private String studentName;
    private List<SchoolCourse> courses;
}
