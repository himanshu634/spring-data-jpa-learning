package com.himanshu.spring.data.jpa.demo.repository;

import com.himanshu.spring.data.jpa.demo.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    public Page<Course> findByTitleContaining(
            String title,
            Pageable pageable
    );
}
