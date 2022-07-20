package com.himanshu.spring.data.jpa.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="tbl_student",
        uniqueConstraints = @UniqueConstraint(
            name = "unique_email",
            columnNames = "email_address"
    ) //to add constraints in database
)  //to give different name of table in database
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence",
                       sequenceName = "student_sequence",
                       allocationSize = 1
    ) // to make sequence generator that will generate new ids for every data entry
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(name = "email_address",
            nullable = false
    ) //to give different name of column in database
    private String emailAddress;
    @Embedded
    private Guardian guardian;

    public Student(Long studentId, String firstName, String lastName, String emailAddress, Guardian guardian) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.guardian = guardian;
    }

    public Student() {
    }

    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    public Long getStudentId() {
        return this.studentId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public Guardian getGuardian() {
        return this.guardian;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Student)) return false;
        final Student other = (Student) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$studentId = this.getStudentId();
        final Object other$studentId = other.getStudentId();
        if (this$studentId == null ? other$studentId != null : !this$studentId.equals(other$studentId)) return false;
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
        final Object this$lastName = this.getLastName();
        final Object other$lastName = other.getLastName();
        if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
        final Object this$emailAddress = this.getEmailAddress();
        final Object other$emailAddress = other.getEmailAddress();
        if (this$emailAddress == null ? other$emailAddress != null : !this$emailAddress.equals(other$emailAddress))
            return false;
        final Object this$guardian = this.getGuardian();
        final Object other$guardian = other.getGuardian();
        if (this$guardian == null ? other$guardian != null : !this$guardian.equals(other$guardian)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Student;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $studentId = this.getStudentId();
        result = result * PRIME + ($studentId == null ? 43 : $studentId.hashCode());
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        final Object $emailAddress = this.getEmailAddress();
        result = result * PRIME + ($emailAddress == null ? 43 : $emailAddress.hashCode());
        final Object $guardian = this.getGuardian();
        result = result * PRIME + ($guardian == null ? 43 : $guardian.hashCode());
        return result;
    }

    public String toString() {
        return "Student(studentId=" + this.getStudentId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", emailAddress=" + this.getEmailAddress() + ", guardian=" + this.getGuardian() + ")";
    }

    public static class StudentBuilder {
        private Long studentId;
        private String firstName;
        private String lastName;
        private String emailAddress;
        private Guardian guardian;

        StudentBuilder() {
        }

        public StudentBuilder studentId(Long studentId) {
            this.studentId = studentId;
            return this;
        }

        public StudentBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public StudentBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StudentBuilder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public StudentBuilder guardian(Guardian guardian) {
            this.guardian = guardian;
            return this;
        }

        public Student build() {
            return new Student(studentId, firstName, lastName, emailAddress, guardian);
        }

        public String toString() {
            return "Student.StudentBuilder(studentId=" + this.studentId + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", emailAddress=" + this.emailAddress + ", guardian=" + this.guardian + ")";
        }
    }
}
