package oops.Generic;

import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private final String evaluationMethod;

    CourseType(String evaluationMethod) {
        this.evaluationMethod = evaluationMethod;
    }

    public String getEvaluationMethod() {
        return evaluationMethod;
    }
}

class ExamCourse extends CourseType {
    ExamCourse() {
        super("Exam-Based");
    }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse() {
        super("Assignment-Based");
    }
}

class ResearchCourse extends CourseType {
    ResearchCourse() {
        super("Research-Based");
    }
}

class Course<T extends CourseType> {
    private final String courseCode;
    private final String courseName;
    private final T courseType;

    Course(String courseCode, String courseName, T courseType) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return courseCode + " - " + courseName + " | " + courseType.getEvaluationMethod();
    }
}

public class UniversityCourseManagementSystem {
    public static void displayCourseTypes(List<? extends CourseType> courseTypes) {
        for (CourseType courseType : courseTypes) {
            System.out.println(courseType.getEvaluationMethod());
        }
    }

    public static void main(String[] args) {
        Course<ExamCourse> mathematics = new Course<>("M101", "Mathematics", new ExamCourse());
        Course<AssignmentCourse> webDevelopment = new Course<>("C201", "Web Development", new AssignmentCourse());
        Course<ResearchCourse> artificialIntelligence = new Course<>("R301", "Artificial Intelligence", new ResearchCourse());

        List<CourseType> evaluationTypes = new ArrayList<>();
        evaluationTypes.add(mathematics.getCourseType());
        evaluationTypes.add(webDevelopment.getCourseType());
        evaluationTypes.add(artificialIntelligence.getCourseType());

        System.out.println(mathematics);
        System.out.println(webDevelopment);
        System.out.println(artificialIntelligence);
        System.out.println("Available evaluation types:");
        displayCourseTypes(evaluationTypes);
    }
}
