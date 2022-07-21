package com.himanshu.spring.data.jpa.demo.entity;


import javax.persistence.*;

@Entity
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;


    public CourseMaterial(Long courseMaterialId, String url, Course course) {
        this.courseMaterialId = courseMaterialId;
        this.url = url;
        this.course = course;
    }

    public CourseMaterial() {
    }

    public static CourseMaterialBuilder builder() {
        return new CourseMaterialBuilder();
    }

    public Long getCourseMaterialId() {
        return this.courseMaterialId;
    }

    public String getUrl() {
        return this.url;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourseMaterialId(Long courseMaterialId) {
        this.courseMaterialId = courseMaterialId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CourseMaterial)) return false;
        final CourseMaterial other = (CourseMaterial) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$courseMaterialId = this.getCourseMaterialId();
        final Object other$courseMaterialId = other.getCourseMaterialId();
        if (this$courseMaterialId == null ? other$courseMaterialId != null : !this$courseMaterialId.equals(other$courseMaterialId))
            return false;
        final Object this$url = this.getUrl();
        final Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) return false;
        final Object this$course = this.getCourse();
        final Object other$course = other.getCourse();
        if (this$course == null ? other$course != null : !this$course.equals(other$course)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CourseMaterial;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $courseMaterialId = this.getCourseMaterialId();
        result = result * PRIME + ($courseMaterialId == null ? 43 : $courseMaterialId.hashCode());
        final Object $url = this.getUrl();
        result = result * PRIME + ($url == null ? 43 : $url.hashCode());
        final Object $course = this.getCourse();
        result = result * PRIME + ($course == null ? 43 : $course.hashCode());
        return result;
    }

    public String toString() {
        return "CourseMaterial(courseMaterialId=" + this.getCourseMaterialId() + ", url=" + this.getUrl() + ")";
    }

    public static class CourseMaterialBuilder {
        private Long courseMaterialId;
        private String url;
        private Course course;

        CourseMaterialBuilder() {
        }

        public CourseMaterialBuilder courseMaterialId(Long courseMaterialId) {
            this.courseMaterialId = courseMaterialId;
            return this;
        }

        public CourseMaterialBuilder url(String url) {
            this.url = url;
            return this;
        }

        public CourseMaterialBuilder course(Course course) {
            this.course = course;
            return this;
        }

        public CourseMaterial build() {
            return new CourseMaterial(courseMaterialId, url, course);
        }

        public String toString() {
            return "CourseMaterial.CourseMaterialBuilder(courseMaterialId=" + this.courseMaterialId + ", url=" + this.url + ", course=" + this.course + ")";
        }
    }
}
