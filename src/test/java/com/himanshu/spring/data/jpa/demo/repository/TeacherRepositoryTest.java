package com.himanshu.spring.data.jpa.demo.repository;

import com.himanshu.spring.data.jpa.demo.entity.Course;
import com.himanshu.spring.data.jpa.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course course = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course course1 = Course.builder()
                .title("Java")
                .credit(4)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Yogitaben")
                .lastName("Maheta")
//                .courseList(List.of(course, course1))
                .build();

        teacherRepository.save(teacher);
    }
}
