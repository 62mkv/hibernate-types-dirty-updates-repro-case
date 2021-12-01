package org.example;

import com.vladmihalcea.hibernate.type.json.JsonBlobType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "STUDENT")
@TypeDef(name = "json",
        typeClass = JsonBlobType.class)
@Getter
@Builder
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    UUID id;

    @CreationTimestamp
    @Column(name = "CREATED_AT", nullable = false)
    LocalDateTime createdAt;

    @Column(name = "DETAILS_JSON")
    @Type(type = "json")
    StudentDetails details;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!id.equals(student.id)) return false;
        if (!createdAt.equals(student.createdAt)) return false;
        return details != null ? details.equals(student.details) : student.details == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + (details != null ? details.hashCode() : 0);
        return result;
    }
}
