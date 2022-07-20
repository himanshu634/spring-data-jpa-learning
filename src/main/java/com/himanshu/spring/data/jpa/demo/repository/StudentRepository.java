package com.himanshu.spring.data.jpa.demo.repository;

import com.himanshu.spring.data.jpa.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String firstName);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName,String lastName);

    @Query("select s from Student s where s.emailAddress = ?1") //jpql query
    Student getStudentByEmailAddress(String emailAddress);

    @Query("select s.firstName from Student s where s.emailAddress = ?1")//jpql query
    String getStudentFirstNameByEmailAddress(String emailAddress);

    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1",
            nativeQuery = true
    ) // native sql query
    Student getStudentByEmailAddressNative(String emailAddress);

    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address = :emailAddress",
            nativeQuery = true
    ) // native sql query
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailAddress") String emailAddress);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tbl_student SET first_name = :newFirstName WHERE email_address = :emailAddress",
            nativeQuery = true
    )
    int updateStudentNameByEmailAddress(@Param("newFirstName") String newFirstName, @Param("emailAddress") String emailAddress);
}
