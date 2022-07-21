package com.himanshu.spring.data.jpa.demo.entity;

import javax.persistence.*;

@Entity
public class Teacher {
    @Id
    @SequenceGenerator(
            sequenceName = "teacher_sequence",
            name = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "teacher_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long teacherId;
    private String firstName;
    private String lastName;

    public Teacher(Long teacherId, String firstName, String lastName) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Teacher() {
    }

    public static TeacherBuilder builder() {
        return new TeacherBuilder();
    }

    public Long getTeacherId() {
        return this.teacherId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Teacher)) return false;
        final Teacher other = (Teacher) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$teacherId = this.getTeacherId();
        final Object other$teacherId = other.getTeacherId();
        if (this$teacherId == null ? other$teacherId != null : !this$teacherId.equals(other$teacherId)) return false;
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
        final Object this$lastName = this.getLastName();
        final Object other$lastName = other.getLastName();
        if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Teacher;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $teacherId = this.getTeacherId();
        result = result * PRIME + ($teacherId == null ? 43 : $teacherId.hashCode());
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        return result;
    }

    public String toString() {
        return "Teacher(teacherId=" + this.getTeacherId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ")";
    }

    public static class TeacherBuilder {
        private Long teacherId;
        private String firstName;
        private String lastName;

        TeacherBuilder() {
        }

        public TeacherBuilder teacherId(Long teacherId) {
            this.teacherId = teacherId;
            return this;
        }

        public TeacherBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public TeacherBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Teacher build() {
            return new Teacher(teacherId, firstName, lastName);
        }

        public String toString() {
            return "Teacher.TeacherBuilder(teacherId=" + this.teacherId + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ")";
        }
    }

//    @OneToMany(
//            cascade = CascadeType.ALL
//    )
//    @JoinColumn(
//            name = "teacher_id",
//            referencedColumnName = "teacherId"
//    )
//    private List<Course> courseList;
}
