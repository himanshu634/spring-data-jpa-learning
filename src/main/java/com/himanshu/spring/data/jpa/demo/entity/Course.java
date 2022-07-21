package com.himanshu.spring.data.jpa.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            allocationSize = 1,
            sequenceName = "course_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "student_course_mapping",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns =  @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student> studentList;

    public Course(Long courseId, String title, Integer credit, CourseMaterial courseMaterial, Teacher teacher, List<Student> studentList) {
        this.courseId = courseId;
        this.title = title;
        this.credit = credit;
        this.courseMaterial = courseMaterial;
        this.teacher = teacher;
        this.studentList = studentList;
    }

    public Course() {
    }

    public static CourseBuilder builder() {
        return new CourseBuilder();
    }

    public void addStudent(Student student){
        if(studentList == null) studentList = new ArrayList<>();
        studentList.add(student);
    }


    public Long getCourseId() {
        return this.courseId;
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getCredit() {
        return this.credit;
    }

    public CourseMaterial getCourseMaterial() {
        return this.courseMaterial;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public void setCourseMaterial(CourseMaterial courseMaterial) {
        this.courseMaterial = courseMaterial;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Course)) return false;
        final Course other = (Course) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$courseId = this.getCourseId();
        final Object other$courseId = other.getCourseId();
        if (this$courseId == null ? other$courseId != null : !this$courseId.equals(other$courseId)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$credit = this.getCredit();
        final Object other$credit = other.getCredit();
        if (this$credit == null ? other$credit != null : !this$credit.equals(other$credit)) return false;
        final Object this$courseMaterial = this.getCourseMaterial();
        final Object other$courseMaterial = other.getCourseMaterial();
        if (this$courseMaterial == null ? other$courseMaterial != null : !this$courseMaterial.equals(other$courseMaterial))
            return false;
        final Object this$teacher = this.getTeacher();
        final Object other$teacher = other.getTeacher();
        if (this$teacher == null ? other$teacher != null : !this$teacher.equals(other$teacher)) return false;
        final Object this$studentList = this.getStudentList();
        final Object other$studentList = other.getStudentList();
        if (this$studentList == null ? other$studentList != null : !this$studentList.equals(other$studentList))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Course;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $courseId = this.getCourseId();
        result = result * PRIME + ($courseId == null ? 43 : $courseId.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $credit = this.getCredit();
        result = result * PRIME + ($credit == null ? 43 : $credit.hashCode());
        final Object $courseMaterial = this.getCourseMaterial();
        result = result * PRIME + ($courseMaterial == null ? 43 : $courseMaterial.hashCode());
        final Object $teacher = this.getTeacher();
        result = result * PRIME + ($teacher == null ? 43 : $teacher.hashCode());
        final Object $studentList = this.getStudentList();
        result = result * PRIME + ($studentList == null ? 43 : $studentList.hashCode());
        return result;
    }

    public String toString() {
        return "Course(courseId=" + this.getCourseId() + ", title=" + this.getTitle() + ", credit=" + this.getCredit() + ", courseMaterial=" + this.getCourseMaterial() + ", teacher=" + this.getTeacher() + ", studentList=" + this.getStudentList() + ")";
    }

    public static class CourseBuilder {
        private Long courseId;
        private String title;
        private Integer credit;
        private CourseMaterial courseMaterial;
        private Teacher teacher;
        private List<Student> studentList;

        CourseBuilder() {
        }

        public CourseBuilder courseId(Long courseId) {
            this.courseId = courseId;
            return this;
        }

        public CourseBuilder title(String title) {
            this.title = title;
            return this;
        }

        public CourseBuilder credit(Integer credit) {
            this.credit = credit;
            return this;
        }

        public CourseBuilder courseMaterial(CourseMaterial courseMaterial) {
            this.courseMaterial = courseMaterial;
            return this;
        }

        public CourseBuilder teacher(Teacher teacher) {
            this.teacher = teacher;
            return this;
        }

        public CourseBuilder studentList(List<Student> studentList) {
            this.studentList = studentList;
            return this;
        }

        public Course build() {
            return new Course(courseId, title, credit, courseMaterial, teacher, studentList);
        }

        public String toString() {
            return "Course.CourseBuilder(courseId=" + this.courseId + ", title=" + this.title + ", credit=" + this.credit + ", courseMaterial=" + this.courseMaterial + ", teacher=" + this.teacher + ", studentList=" + this.studentList + ")";
        }
    }
}


