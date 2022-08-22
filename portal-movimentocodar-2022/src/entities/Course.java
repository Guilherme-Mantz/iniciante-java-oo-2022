package entities;

import entities.enums.CourseStatus;

public class Course {
	
	private static int counterCourseNumber = 1;
	
	private int numberCourse;
	private String name;
	private String teacherName;
	private CourseStatus courseStatus;
	
	public Course(String name, String teacherName, CourseStatus courseStatus) {
		this.numberCourse = Course.counterCourseNumber;
		this.name = name;
		this.teacherName = teacherName;
		this.courseStatus = courseStatus;
		Course.counterCourseNumber += 1;
	}
	
	public int getNumberCourse() {
		return numberCourse;
	}

	public CourseStatus getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(CourseStatus courseStatus) {
		this.courseStatus = courseStatus;
	}

	@Override
	public String toString() {
		return "\n" + "\nNúmero do curso: "+ numberCourse +
				"\nNome do curso: " + name +
				"\nProfessor: " + teacherName + 
				"\nStatus do Curso: " + getCourseStatus().getDescription();
	}
	
}
