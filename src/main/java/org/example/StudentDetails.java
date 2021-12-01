package org.example;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder
@Jacksonized
@EqualsAndHashCode
public class StudentDetails {
    private String studentName;
    private List<SchoolCourse> courses;
}
