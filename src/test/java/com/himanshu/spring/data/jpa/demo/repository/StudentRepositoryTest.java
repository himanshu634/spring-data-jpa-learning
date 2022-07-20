package com.himanshu.spring.data.jpa.demo.repository;

import com.himanshu.spring.data.jpa.demo.entity.Guardian;
import com.himanshu.spring.data.jpa.demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailAddress("himanshu@gmail.com")
                .firstName("Himanshu")
                .lastName("Mendapara")
//                .guardianEmail("kanubhai@gmail.com")
//                .guardianMobileNumber("9429336957")
//                .guardianName("Kanubhai")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .mobileNumber("9429336947")
                .name("Prafulbhai")
                .emailAddress("prafulbhai@gmail.com")
                .build();

        Student student = Student.builder()
                .firstName("Ridham")
                .lastName("Shingala")
                .emailAddress("ridham@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student List : " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("Himanshu");
        System.out.println("#####################################################################");
        System.out.println("Student List " + studentList);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("sh");
        System.out.println("##################################################################");
        System.out.println("Student List " + studentList);
    }

    @Test
    public void printStudentByLastName(){
        List<Student> studentList = studentRepository.findByLastNameNotNull();
        System.out.println("##############################################################");
        System.out.println("Student List " + studentList);
    }

    @Test
    public void printStudentByGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianName("Prafulhai");
        System.out.println("###############################################################");
        System.out.println("Student List " + studentList);
    }

    @Test
    public void printStudentByFirstNameAndLastName(){
        Student student = studentRepository.findByFirstNameAndLastName("Himanshu", "Mendapara");
        System.out.println("################################################################");
        System.out.println("Student :" + student);
    }

    @Test
    public void printStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("himanshu@gmail.com");
        System.out.println("##########################################################");
        System.out.println(student);
    }

    @Test
    public void printFirstNameByEmailAddress(){
        String studentFirstName = studentRepository.getStudentFirstNameByEmailAddress("himanshu@gmail.com");
        System.out.println("#####################################################################3");
        System.out.println(studentFirstName);
    }

    @Test
    public void printStudentByNativeQuery(){
        Student student = studentRepository.getStudentByEmailAddressNative("ridham@gmail.com");
        System.out.println("#############################################################################");
        System.out.println(student);
    }

    @Test
    public void printStudentByNativeQueryByNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("ridham@gmail.com");
        System.out.println("#############################################################################");
        System.out.println(student);
    }

    @Test
    public void printUpdateStudentFirstNameByEmailAddress(){
        int value = studentRepository.updateStudentNameByEmailAddress("Ronil", "himanshu@gmail.com");
        System.out.println("###################################################");
        System.out.println(value);
    }


}