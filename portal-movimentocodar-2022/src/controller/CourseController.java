package controller;

import java.util.List;
import java.util.stream.Collectors;

import entities.Course;
import entities.enums.CourseStatus;

public class CourseController {
	
	public static boolean setFinishedCourse(List<Course> courses, int numberCourse) {
		Course getCourse = getCourseByNumber(courses, numberCourse);
		
		if(getCourse == null) {
			System.out.println("Curso não encontrado!");
			return false;
		}
		else if (getCourse.getCourseStatus() == CourseStatus.FINISHED) {
			System.out.println("O curso ja foi finalizado!");
			return false;
		}
		else {
			getCourse.setCourseStatus(CourseStatus.FINISHED);
			System.out.println("Curso finalizado com sucesso!");
		}
		return true;
	}
	
	public static Course getCourseByNumber(List<Course> courses, int numberCourse) {
		Course getByNumber = courses.stream()
				.filter(c -> c.getNumberCourse() == numberCourse)
				.findAny().orElse(null);
		return getByNumber;
	}
	
	public static List<Course> getFinishedCourses(List<Course> courses){
		List<Course> finished = courses.stream()
				.filter(x -> x.getCourseStatus() == CourseStatus.FINISHED)
				.collect(Collectors.toList());
		
		return finished;
	}
	
	public static List<Course> getInProgressCourses(List<Course> courses){
		List<Course> inProgress = courses.stream()
				.filter(x -> x.getCourseStatus() == CourseStatus.IN_PROGRESS)
				.collect(Collectors.toList());
		
		return inProgress;
	}
	
	public static List<Course> getNotStartedCourses(List<Course> courses){
		List<Course> notStarted = courses.stream()
				.filter(x -> x.getCourseStatus() == CourseStatus.NOT_STARTED)
				.collect(Collectors.toList());
		
		return notStarted;
	}
}
