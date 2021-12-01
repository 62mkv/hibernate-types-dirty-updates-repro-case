package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReproTest {

    private static EntityManager em;
    private EntityTransaction txn;

    @BeforeAll
    static void setUpEntityManager() {
        em = Persistence.createEntityManagerFactory("default").createEntityManager();
        em.setFlushMode(FlushModeType.AUTO);
    }

    @BeforeEach
    void startTransaction() {
        txn = em.getTransaction();
        txn.begin();
    }

    @AfterEach
    void rollback() {
        txn.rollback();
    }

    @Test
    void testHibernate() {
        SchoolCourse algebraCourse = SchoolCourse.builder()
                .courseName("algebra")
                .courseDuration(Duration.ofDays(90))
                .build();
        StudentDetails details = StudentDetails.builder()
                .studentName("kiki")
                .courses(Collections.singletonList(algebraCourse))
                .build();
        Student student = Student.builder()
                .details(details)
                .build();

        em.persist(student);

        List<Student> res = em.createQuery("from Student").getResultList();
        assertThat(res)
                .hasSize(1)
                .allSatisfy(s -> assertThat(s.getCreatedAt()).isNotNull());
    }

}
