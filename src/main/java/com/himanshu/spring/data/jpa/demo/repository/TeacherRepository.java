package com.himanshu.spring.data.jpa.demo.repository;

import com.himanshu.spring.data.jpa.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
