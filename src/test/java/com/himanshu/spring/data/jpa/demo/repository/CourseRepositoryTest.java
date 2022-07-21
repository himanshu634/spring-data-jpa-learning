package com.himanshu.spring.data.jpa.demo.repository;

import com.himanshu.spring.data.jpa.demo.entity.Course;
import com.himanshu.spring.data.jpa.demo.entity.Guardian;
import com.himanshu.spring.data.jpa.demo.entity.Student;
import com.himanshu.spring.data.jpa.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository ;

    @Test
    public void printListOfCourse(){
        List<Course> courseList = courseRepository.findAll();

        System.out.println("############################");
        System.out.println("Course List : " + courseList);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Singh")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void printListOfCourseByPagination(){
        Pageable page2 = PageRequest.of(1, 3);
        Pageable page1 = PageRequest.of(1, 1);

        List<Course> courses = courseRepository.findAll(page1).getContent();

        long totalElements = courseRepository.findAll(page1).getTotalElements();

        long totalPages = courseRepository.findAll(page1).getTotalPages();

        System.out.println("#########################################################");
        System.out.println("courses : " + courses);
        System.out.println("totalElements : " + totalElements);
        System.out.println("totalPages : " + totalPages);
        System.out.println("##########################################################");
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));

        Pageable sortByTitleDescending = PageRequest.of(0, 2, Sort.by("title").descending());

        Pageable sortByCredit = PageRequest.of(0, 2, Sort.by("credit"));

        List<Course> courses = courseRepository.findAll(sortByCredit).getContent();

        System.out.println("##########################################################");
        System.out.println("courses : " + courses);

    }

    @Test
    public void findByTitleContaining(){
        Pageable pagination = PageRequest.of(0, 10);

        List<Course>  courses = courseRepository.findByTitleContaining("d", pagination).getContent();

        System.out.println("#############################################################");
        System.out.println("courses : " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Guardian guardian = Guardian.builder()
                .name("Ashokbhai")
                .mobileNumber("86868686867")
                .emailAddress("ashokbhai@gmail.com")
                .build();

        Student student = Student.builder()
                .firstName("Dhruvit")
                .lastName("Pokiya")
                .guardian(guardian)
                .emailAddress("dhruvit@gmail.com")
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Kareena")
                .lastName("Kapoor")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudent(student);

        courseRepository.save(course);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~done~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }
}
